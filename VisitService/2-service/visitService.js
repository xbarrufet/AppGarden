var winston = require('winston');
var Q = require('Q');
var visitRepository =require('../3-repository/visitRepository');

var visitService = function() {

    
    var _getGardenVisitsShortList = function(gardenId) {
        var deferred = Q.defer();
        winston.info('visitService.getGardenVisitsShortList access');
        visitRepository.getGardenVisitsShortList(gardenId)
            .then(function (data) {
                winston.info('visitService.getGardenVisitsShortList return');
               deferred.resolve(data)
             })
            .fail(function error(err) {
                console.error(err);
                deferred.reject(err);
        });
        return deferred.promise;
    };
    
    var _addVisit = function(visit) {
        winston.info('visitService.addVisit access');
        var deferred = Q.defer();
        visitRepository.addVisit(visit)
            .then(function (data) {
                winston.info('visitService.addVisit return');
                deferred.resolve(data)
            })
            .fail(function error(err) {
                    console.error(err);
                    deferred.reject(err);
             });
        return deferred.promise;
    };

    return {
        getGardenVisitsShortList: _getGardenVisitsShortList,
        addVisit:_addVisit
    }
}();

module.exports = visitService;
