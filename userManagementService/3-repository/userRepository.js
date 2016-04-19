var winston = require('winston');
var Q = require('Q');

var userRepository = function() {

    var mongoose = require('mongoose');
    var Schema = require('mongoose').Schema;


    var _userSchema = new Schema({
        username: String,
        password: String,
        admin: Boolean
    });

    var _model = mongoose.model('Users', _userSchema);

    var _getAllUsers = function() {
        var deferred = Q.defer();
        winston.info("userRepository._getAllUsers");
        _model.find({},function(err,docs) {
            winston.info("userRepository._getAllUsers:results " + docs.length);
            if(err) {
               deferred.reject(err);
            }
           deferred.resolve (docs) 
        });
        return deferred.promise;
    };

    var _validate = function(username,password) {
        var deferred = Q.defer();
        winston.info("userRepository._validate " + username + "," + password);
        _model.findOne({username:username},function(err,user) {
            if(err) {
                deferred.reject(err);
            }
            if(!user)
                deferred.reject("Authentication failed. User not found.");
            else {
                if (user.password != password)
                    deferred.reject("Authentication failed. Wrong pasword.");
            }
            deferred.resolve (user);
        });
        return deferred.promise;
    };
    

    var _addUser = function(username,password,admin) {
        var deferred = Q.defer();
        var user =({
            username: username,
            password: password,
            admin: admin
        });
        _model.create(user,
            function (err, vUser) {
                if (err)
                    deferred.reject(err);
                // get and return the element
                deferred.resolve (vUser);
            });
        return deferred.promise;
    };

    return {
        getAllUsers: _getAllUsers,
        addUser:_addUser,
        validate: _validate,
        schema: _userSchema,
        model: _model
    }
}();

module.exports = userRepository;
