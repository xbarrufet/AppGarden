var winston = require('winston');
var Q = require('Q');

var userRepository = function() {

    var mongoose = require('mongoose');
    var Schema = require('mongoose').Schema;

    var TYPE_CLIENT="CLIENT";
    var TYPE_GARDEN="GARDEN";

    var _userSchema = new Schema({
        name: String,
        email: { type : String , unique : true, required : true, dropDups: true },
        password:{ type : String, required: true},
        admin: { type : Boolean, default: false},
        type:{ type:  String , default : TYPE_GARDEN },
        audit: {
            dateCreated:Date,
            dateUpdated:Date
        }

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

    var _getUser = function(email) {
        var deferred = Q.defer();
        _model.find({email:email},function(err,docs) {
            if(err) {
                deferred.reject(err);
            }
            deferred.resolve (docs)
        });
        return deferred.promise;
    };

    var _validate = function(email,password) {
        var deferred = Q.defer();
        winston.info("userRepository._validate " + email + "," + password);
        _model.findOne({email:email},function(err,user) {
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
    

    var _addUser = function(newUser) {
        var deferred = Q.defer();
        var user =({
            name: newUser.name,
            email: newUser.email,
            password: newUser.password,
            admin: newUser.admin,
            type:newUser.type,
            audit:{
                dateCreated:new Date(),
                dateUpdatede:new Date()
            }
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

    var _deleteUser =function(email) {
        var deferred = Q.defer();
        _getUser(email)
            .then(function (user) {
                user.delete();
                deferred.resolve (email);
            })
            .fail(function(err) {
                deferred.reject(err);
            })
        return deferred.promise;
    };

    return {
        getAllUsers: _getAllUsers,
        deleteUser:_deleteUser,
        getUser: _getUser,
        addUser:_addUser,
        validate: _validate,
        schema: _userSchema,
        model: _model,
        TYPE_CLIENT:TYPE_CLIENT,
        TYPE_GARDEN:TYPE_GARDEN
    }
}();

module.exports = userRepository;
