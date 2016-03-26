app.factory('gardenCenterFactory', ['$http', function($http) {

    var urlBase = 'http://localhost:8080/v1/gardencenters';
    var dataFactory = {};

    dataFactory.getGardenCenters = function () {
        return $http.get(urlBase);
    };
    
     dataFactory.getGardenCenter = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    dataFactory.addGardenCenter = function (gardenCenter) {
        return $http.post(urlBase, gardenCenter);
    };

    dataFactory.updateGardenCenter = function (gardenCenter) {
        return $http.put(urlBase + '/' + gardenCenter.gardenCenterId, gardenCenter)
    };

    dataFactory.deleteGardenCenter = function (id) {
        return $http.delete(urlBase + '/' + id);
    };


    return dataFactory;
}]);