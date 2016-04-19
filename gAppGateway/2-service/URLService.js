/**
 * Created by xavierbarrufet on 18/4/16.
 */

var URLService = function() {

    var _getURL = function(url,callback) {

        var urlRes="";

        callback(null,urlRes)
    }

    return {
        getURL: _getURL
    }
}();

module.exports = URLService;
