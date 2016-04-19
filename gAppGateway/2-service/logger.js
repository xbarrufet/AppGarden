/**
 * Created by xavierbarrufet on 18/4/16.
 */
var winston=require("winston")

var log = new (winston.Logger)({
    transports: [
        new (winston.transports.Console)(),
        new (winston.transports.File)({ filename: 'gAppGateway.log' })
    ]
});

function metadata() {
    var res ={};
    res.service="gAppGateway";
    res.timestamp = new Date();
    return res;
}

var logger = function() {

    var _info=function(msg) {
        log.info('info',msg,metadata());
    }
    var _debug=function(msg) {
        log.debug('debug',msg,metadata());
    }
    var _error=function(msg) {
        log.error('error',msg,metadata());
    }

    return {
        info: _info,
        debug: _debug,
        error: _error,
    }
}();

module.exports = logger;

