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
