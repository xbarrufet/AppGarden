// ROUTES FOR OUR API
// =============================================================================
var express    = require('express');



var router = express.Router(); 				// get an instance of the express Router

// middleware to use for all requests
router.use(function(req, res, next) {
    // do logging
    console.log('Something is happening.');
    next(); // make sure we go to the next routes and don't stop here
});

router.get('/', function(req, res) {
    res.json({ message: 'hooray! welcome to our api!' });
});

// visit routes ==================================================================
router.route('/visit')
    .get(function(req, res) {
       res.send("hola que tal")
    })
    .post(function(req,res) {
        res.send("hola que tal")
    });

router.route('/visit/:visitId')
    .get(function(req,res) {
        res.send("hola que tal id")
    })
    .put(function(req,res) {
        res.send("hola que tal")
    });



module.exports=router;
