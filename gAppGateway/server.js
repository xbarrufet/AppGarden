// server.js

// BASE SETUP
// ==============================================

var express = require('express');
var app     = express();
var winston = require('winston');
var morgan      = require('morgan');
//var router = require('./1-app/routes');
var port    =   process.env.PORT || 3000;
var mongoose    = require('mongoose');
var bodyParser  = require('body-parser');
var jwt    = require('jsonwebtoken'); // used to create, sign, and verify tokens

var userService = require("./2-service/userService")


// Start actions
// ==============================================
app.set('superSecret', "ventanajardincafetera");
// use body parser so we can get info from POST and/or URL parameters
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
// use morgan to log requests to the console
app.use(morgan('dev'));


// ROUTES
// ==============================================



// sample route with a route the way we're used to seeing it
app.get('/', function(req, res) {
    res.send('Hello! The API is at http://localhost:' + port + '/api');
});
//create a user
app.get('/setup', function(req, res) {

    // create a sample user
    var nick = {
        name: 'barrufet',
        password: 'xavier',
        admin: false
    };
    // save the sample user
    userService.addUser(nick)
        .then(function (user) {
            console.log('User saved successfully');
            res.json({ success: true ,user:user.name});
        })
        .fail(function (err) {
            throw err;
        })
});

// api routes ==============================================

var apiRoutes = express.Router();

apiRoutes.post('/authenticate', function(req, res) {

    userService.validate(req.body.username,req.body.password)
        .then(function (user) {
           var token = jwt.sign(user.username, app.get('superSecret'), {
                expiresInMinutes: 1440 // expires in 24 hours
            });
            // return the information including token as JSON
            res.json({
                success: true,
                message: 'Enjoy your token!',
                token: token
            });
        })
        .fail(function (err) {
            res.json({ success: false, message: err });
        })
});

//les de sota esta protegides
apiRoutes.use(function(req, res, next) {

    // check header or url parameters or post parameters for token
    var token = req.body.token || req.query.token || req.headers['x-access-token'];
    // decode token
    if (token) {
        // verifies secret and checks exp
        jwt.verify(token, app.get('superSecret'), function(err, decoded) {
            if (err) {
                return res.json({ success: false, message: 'Failed to authenticate token.' });
            } else {
                // if everything is good, save to request for use in other routes
                req.decoded = decoded;
                next();
            }
        });

    } else {
        // if there is no token
        // return an error
        return res.status(403).send({
            success: false,
            message: 'No token provided.'
        });

    }
});

apiRoutes.get('/', function(req, res) {
    res.json({ message: 'Welcome to the coolest API on earth!' });
});


apiRoutes.get('/users', function(req, res) {
    console.log("decoded-->");
    console.log(req.decoded);
    userService.getUsers()
        .then(function (users) {
            res.json(users);
        })
        .fail(function (err) {
            throw err;
        })
});



// apply the routes to our application with the prefix /api
app.use('/api', apiRoutes);


// ERROR HANDLING
app.use(function(err, req, res, next) {
    console.error(err.stack);
    res.send(500);
});


// START THE SERVER
// ==============================================
mongoose.connect('mongodb://127.0.0.1/users', function onMongooseError(err) {
    if(err)
        winston.error("Error connecting to DEV DB " + err);
});
app.listen(port);
console.log('Magic happens on port ' + port);