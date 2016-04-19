/**
 * Created by xavierbarrufet on 18/4/16.
 */

var URLService=require("../2-service/URLService");
var logger=require("../2-service/logger");

function serviceDispatch(req, res) {
    var parsedUrl = url.parse(req.url);

    URLService.getURL({ url: parsedUrl.pathname }, function(err, service) {
        if(err) {
            logger.error(err);
            send500(res);
            return;
        }

        var authorized = roleCheck(req.context.authPayload.jwt, service);
        if(!authorized) {
            send401(res);
            return;
        }

        // Fanout all requests to all related endpoints.
        // Results are aggregated (more complex strategies are possible).
        var promises = [];
        service.endpoints.forEach(function(endpoint) {
            logger.debug(sprintf('Dispatching request from public endpoint ' +
                '%s to internal endpoint %s (%s)',
                req.url, endpoint.url, endpoint.type));

            switch(endpoint.type) {
                case 'http-get':
                case 'http-post':
                    promises.push(httpPromise(req, endpoint.url,
                        endpoint.type === 'http-get'));
                    break;
                case 'amqp':
                    promises.push(amqpPromise(req, endpoint.url));
                    break;
                default:
                    logger.error('Unknown endpoint type: ' + endpoint.type);
            }
        });

        //Aggregation strategy for multiple endpoints.
        Q.allSettled(promises).then(function(results) {
            var responseData = {};

            results.forEach(function(result) {
                if(result.state === 'fulfilled') {
                    responseData = _.extend(responseData, result.value);
                } else {
                    logger.error(result.reason.message);
                }
            });

            res.setHeader('Content-Type', 'application/json');
            res.end(JSON.stringify(responseData));
        });
    }, 'services');
}