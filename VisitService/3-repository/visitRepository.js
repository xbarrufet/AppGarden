var winston = require('winston');
var Q = require('Q');

var visitRepository = function() {

    var mongoose = require('mongoose');
    var Schema = require('mongoose').Schema;

    var status = 'PENDING ACTIVE DELETED NOT_CONFIRMED'.split(' ');

    var _visitSchema = new Schema({
        gardenId: { type: String, index: true },
        visitDay: Date,
        type: String,
        description:String,
        image: String,
        conversationId: String,
        geoCheck:Boolean,
        services: [String]
    });

    _visitSchema.index({ "location" : "geoHaystack", type : 1},{ bucketSize : 1});

    var _model = mongoose.model('visits', _visitSchema);

    var _getGardenVisitsShortList = function(gardenId) {
        var deferred = Q.defer();
        winston.info('visitRepository._getGardenVisitsShortList access');
        _model.find({'gardenId':gardenId},function(err,docs) {
            if(err) {
               deferred.reject(err);
            }
            winston.info('visitRepository._getGardenVisitsShortList return:');
            winston.info(docs.length);
           deferred.resolve (docs) 
        }).limit(10);
        return deferred.promise;
    };
    
      var _newPOI = function(req,res) {
       
    };
    var _addVisit = function(visit) {
         winston.info('new visit');
         var deferred = Q.defer();              
        _model.create(visit,
            function (err, vVisit) {
            if (err)
                deferred.reject(err);
             // get and return the element
            deferred.resolve (vVisit);
        });
        return deferred.promise;
    };

    return {
        getGardenVisitsShortList: _getGardenVisitsShortList,
        addVisit:_addVisit,
        schema: _visitSchema,
        model: _model
    }
}();

module.exports = visitRepository;
