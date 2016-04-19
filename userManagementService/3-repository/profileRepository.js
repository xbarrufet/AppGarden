var logger = require('../2-service/logger');
var Q = require('Q');

var profileRepository = function() {

    var mongoose = require('mongoose');
    var Schema = require('mongoose').Schema;


    var _profileSchema = new Schema({
        email: { type : String , unique : true, required : true, dropDups: true },
        gardenCenter:[String],
        garden:[String],
        audit: {
            dateCreated:Date,
            dateUpdated:Date
        }

    });

    var _model = mongoose.model('Profile', _profileSchema);

    var _getProfile=function(email) {
        var deferred = Q.defer();
        _model.findOne({email:email},function(err,doc) {
            if(err)
                deferred.reject(err)
            deferred.resolve(doc)
        })
        return deferred.promise;
    }

    var _addGarden= function(email,garden) {
        var deferred = Q.defer();
        _getProfile(email)
            .then(function(profile) {
                if(profile.garden.indexOf(garden)==-1) {
                    profle.garden.push(garden);
                    profile.save(function (err) {
                        if(err)
                            deferred.reject(err);
                        deferred.resolve(profile);
                    });
                } else {
                    deferred.resolve(profile);
                }
            })
            .fail(function(err) {
                deferred.reject(err);
            })
        return deferred.promise;
    };

    var _addGardenCenter = function(email,gardenCenter) {
        var deferred = Q.defer();
        _getProfile(email)
            .then(function(profile) {
                if(profile.gardenCenter.indexOf(gardenCenter)==-1) {
                    profle.gardenCenter.push(gardenCenter);
                    profile.save(function (err) {
                        if(err)
                            deferred.reject(err);
                        deferred.resolve(profile);
                    });
                } else {
                    deferred.resolve(profile);
                }
            })
            .fail(function(err) {
                deferred.reject(err);
            })
        return deferred.promise;
    };



    var _createProfile = function(email) {
        var deferred = Q.defer();
        var profile =({
            email: email,
            audit:{
                dateCreated:new Date(),
                dateUpdatede:new Date()
            }
        });
        _model.create(profile,
            function (err, vProfile) {
                if (err)
                    deferred.reject(err);
                // get and return the element
                deferred.resolve (vProfile);
            });
        return deferred.promise;
    };

    return {
        getProfile: _getProfile,
        createProfile:_createProfile,
        addGardenCenter:_addGardenCenter,
        addGarden:_addGarden,
        
        schema: _profileSchema,
        model: _model,
        TYPE_CLIENT:TYPE_CLIENT,
        TYPE_GARDEN:TYPE_GARDEN
    }
}();

module.exports = userRepository;
