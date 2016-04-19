// ROUTES FOR OUR API
// =============================================================================
var express    = require('express');
var winston    = require('winston');
var router = require('./1-app/routes');


var router = express.Router(); 				// get an instance of the express Router

// middleware to use for all requests
router.use(function(req, res, next) {
    // do logging
    next(); // make sure we go to the next routes and don't stop here
});

router.get('/', function(req, res) {
    res.json({ message: 'hooray! welcome to our api!' });
});

// visit routes ==================================================================
router.route('/visit/garden/:gardenId')
    .get(function(req, res) {
        visitService.getGardenVisitsShortList(req.params.gardenId)
            .then(function(docs) {
                res.send(docs);
            }).fail(function(err) {
                res.status(500).send(err);
            })
    })


module.exports=router;
