app.controller('clientEditController', 
		['$rootScope','$scope','$location','$routeParams','clientFactory','alertService',
		 function ($rootScope,$scope,$location,$routeParams, clientFactory,alertService) {
	
	//"error"
	
	
	$scope.currentClient={};
	var clientId = $routeParams.clientId;	
	console.log
	if(clientId==null||clientId=="")
		newClient();
	else
		getClient(clientId);
	
	function getClient(clientId) {
		var gardenCenterId=$rootScope.gardenCenterId;
		clientFactory.getClient(gardenCenterId,clientId)
        .then(function (response) {
            $scope.currentClient = response.data;
        }, function (error) {
        	alertService.add("alert-danger", error.message);
            $scope.status = 'Unable to get client: ' + error.message;
        });
	}	
		
	function newClient() {	
		$scope.currentClient.name="";
		$scope.currentClient.address="";
		$scope.currentClient.city="";
		$scope.currentClient.email="gview@sample.com";
		$scope.currentClient.phone="+(34)";
		 
	}
	
	$scope.saveClient = function saveClient() {
		if(clientId==null||clientId=="") {
			clientFactory.addClient($rootScope.gardenCenterId,$scope.currentClient)
	            .then(function (response) {
	                $scope.result = response.data;
	                alertService.add("alert-success", "Client saved succesfully");
	                $location.path( '/client' );	
	            }, function (error) {
	            	alertService.add("alert-danger", error.message);
	                $scope.status = 'Unable to save client: ' + error.message;
	            });
		} else {
			clientFactory.updateClient($rootScope.gardenCenterId,$scope.currentClient)
            .then(function (response) {
                $scope.result = response.data;
                alertService.add("alert-success", "Client saved succesfully");
                $location.path( '/client' );	
            }, function (error) {
            	alertService.add("alert-danger", error.message);
                $scope.status = 'Unable to save client: ' + error.message;
            });
		}
    }
	

}]);	
