app.controller('GardenCenterEditController', 
		['$scope','$location','$routeParams','gardenCenterFactory','alertService',
		 function ($scope,$location,$routeParams, gardenCenterFactory,alertService) {
	
	//"error"
	
	
	$scope.currentGarden={};
	var gardenCenterId = $routeParams.gardenCenterId;	
	console.log
	if(gardenCenterId==null||gardenCenterId=="")
		newGardenCenter();
	else
		getGardenCenter(gardenCenterId);
	
	function getGardenCenter(gardenCenterId) {
		gardenCenterFactory.getGardenCenter(gardenCenterId)
        .then(function (response) {
            $scope.currentGarden = response.data;
        }, function (error) {
        	alertService.add("alert-danger", error.message);
            $scope.status = 'Unable to get garden center: ' + error.message;
        });
	}	
		
	function newGardenCenter() {	
		$scope.currentGarden.name="";
		$scope.currentGarden.address="";
		$scope.currentGarden.city="";
		$scope.currentGarden.email="gview@sample.com";
		$scope.currentGarden.phone="+(34)";
		 
	}
	
	$scope.saveGardenCenter = function saveGardenCenter() {
		if(gardenCenterId==null||gardenCenterId=="") {
			gardenCenterFactory.addGardenCenter($scope.currentGarden)
	            .then(function (response) {
	                $scope.result = response.data;
	                alertService.add("alert-success", "Garden Center saved succesfully");
	                $location.path( '/gardenCenter' );	
	            }, function (error) {
	            	alertService.add("alert-danger", error.message);
	                $scope.status = 'Unable to save garden center: ' + error.message;
	            });
		} else {
			gardenCenterFactory.updateGardenCenter($scope.currentGarden)
            .then(function (response) {
                $scope.result = response.data;
                alertService.add("alert-success", "Garden Center saved succesfully");
                $location.path( '/gardenCenter' );	
            }, function (error) {
            	alertService.add("alert-danger", error.message);
                $scope.status = 'Unable to save garden center: ' + error.message;
            });
		}
    }
	

}]);	
