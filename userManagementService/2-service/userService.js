/**
 * Created by xavierbarrufet on 19/4/16.
 */

var logger = require('../2-service/logger');
var Q = require('Q');
var userRepository = require("../3-repository/userRepository");
var profileRepository = require("../3-repository/profileRepository");

var userService = function() {

    var _getUsers = function() {
        var deferred = Q.defer();
        logger.debug("userService._getUsers");
        userRepository.getAllUsers()
            .then(function (users) {
                logger.debug("userService._getAllUsers:number of users " + users.length);
                deferred.resolve(users);
            })
            .fail(function (err) {
                logger.debug("userService._getAllUsers:error " + err);
                deferred.reject(err);
            })
        return deferred.promise;
    };

    var _addUser = function(user) {
        var deferred = Q.defer();
        userRepository.addUser(user)
            .then(function (user) {
                profileRepository.createProfile(user.email)
                    .then(function() {
                        deferred.resolve(user);
                    })
                    .fail(function(err) {
                        userRepository.deleteUser(user.email)
                            .then(function(user) {
                                deferred.rejected("User not created:" + err);
                            })
                            .fail(function(user) {
                                deferred.rejected("User not created, profile created" + err);
                            })


                    })

            })
            .fail(function (err) {
                deferred.reject(err);
            })
        return deferred.promise;
    };

    var _validate = function(username,password) {
        var deferred = Q.defer();
        winston.info("userService._validate");
        repository.validate(username,password)
            .then(function (user) {
                winston.info("userService._validate OK");
                deferred.resolve(user);
            })
            .fail(function (err) {
                winston.info("userService._validate NOK " + err);
                deferred.reject(err);
            })
        return deferred.promise;
    };

    return {
        getUsers: _getUsers,
        addUser:_addUser,
        validate:_validate
    }
}();

module.exports = userService;

