var winston = require('winston');
var Q = require('Q');
var visitRepository =require('../3-repository/visitRepository');

var visitService = function() {

    
    var _getGardenVisitsShortList = function(gardenId) {
        var deferred = Q.defer();
        winston.info('_getGardenVisitsShortList service access');
        visitRepository.getGardenVisitsShortList(gardenId)
            .then(function (data) {
               deferred.resolve(data)
             })
            .fail(function error(err) {
                console.error(err);
                deferred.reject(err);
                
        });
        return deferred.promise;
    };
    
    var _addVisit = function(visit) {
         winston.info('new visit');
         var deferred = Q.defer();              
        _model.create(visit,
            function (err, vVisit) {
            if (err)
              deferred.reject(err)
             // get and return the element
            deferred.resolve (vVisit) 
        });
        return deferred.promise;
    };

    return {
        getGardenVisits: _getGardenVisits,
        addVisit:_addVisit,
        schema: _visitSchema,
        model: _model
    }
}();

module.exports = visitRepository;
