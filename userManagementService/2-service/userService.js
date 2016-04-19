/**
 * Created by xavierbarrufet on 19/4/16.
 */

var winston = require('winston');
var Q = require('Q');
var repository = require("../3-repository/userRepository");

var userService = function() {

    var _getUsers = function() {
        var deferred = Q.defer();
        winston.info("userService._getUsers");
        repository.getAllUsers()
            .then(function (users) {
                winston.info("userService._getAllUsers:results " + users.length);
                deferred.resolve(users);
            })
            .fail(function (err) {
                deferred.reject(err);
            })
        return deferred.promise;
    };

    var _addUser = function(user) {
        var deferred = Q.defer();
        repository.addUser(user.name, user.password, user.admin)
            .then(function (user) {
                deferred.resolve(user);
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

