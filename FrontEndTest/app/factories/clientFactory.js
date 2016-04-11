app.factory('clientFactory', ['$http', function($http) {

    var urlBase = 'http://localhost:8080/v1/clients';
    var dataFactory = {};
    var GVIEW_CONTEXT="1234"

    dataFactory.getClients = function (gardenCenterId) {
        return $http.get(urlBase,{
            headers: {'GView-Context': gardenCenterId}
        });
    };
    
     dataFactory.getClient = function (gardenCenterId,id) {
        return $http.get(urlBase + '/' + id,{
            headers: {'GView-Context': gardenCenterId}
        });
    };

    dataFactory.addClient = function (gardenCenterId,client) {
        return $http.post(urlBase, client,{
            headers: {'GView-Context': gardenCenterId}
        });
    };

    dataFactory.updateClient = function (gardenCenterId,client) {
        return $http.put(urlBase + '/' + client.clientId, client ,{
            headers: {'GView-Context': gardenCenterId}
        });
    };

    dataFactory.deleteClient = function (gardenCenterId,id) {
        return $http.delete(urlBase + '/' + id,{
            headers: {'GView-Context': gardenCenterId}
        });
    };


    return dataFactory;
}]);