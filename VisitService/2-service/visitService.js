var winston = require('winston');
var Q = require('Q');
var visitRepository =require('../3-repository/visitRepository');

var visitService = function() {

  
    var _getGardenVisits = function(gardenId,limit) {
        var deferred = Q.defer();
        winston.info('_getGardenVisits access');
        _model.find({'gardenId':gardenId},function(err,docs) {
            if(err) {
                var deferred = Q.defer();
            }
           deferred.resolve (docs) 
        }).limit(10);
    };
    
      var _newPOI = function(req,res) {
       
    };
    var _addVisit = function(visit) {
         winston.info('new visit);
         var deferred = Q.defer();              
        _model.create(visit,
            function (err, vVisit) {
            if (err)
                var deferred = Q.defer();
             // get and return the element
            deferred.resolve (vVisit) 
        });
    };

    return {
        getGardenVisits: _getGardenVisits,
        addVisit:_addVisit,
        schema: _visitSchema,
        model: _model
    }
}();

module.exports = visitRepository;
