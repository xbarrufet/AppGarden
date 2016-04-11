app.controller('clientController', 
		['$rootScope','$scope','$location','clientFactory',
		 function ($rootScope,$scope,$location, clientFactory) {
	
	console.log("clientController start");
	$rootScope.gardenCenterId="56f4cdcb9248d758b10eb8e2"
		
	getClients($rootScope.gardenCenterId);	
	$scope.newClient=function() {
		$location.path( '/clientEdit' );		 
	}
	
	$scope.editClient = function editClient(clientId) {
		$location.path( '/clientEdit/'+ clientId);
	}
	
	function getClients(gardenCenterId) {
		clientFactory.getClients(gardenCenterId)
            .then(function (response) {
            	console.log(response.data);
                $scope.clients = response.data;
            }, function (error) {
                $scope.status = 'Unable to load customer data: ' + error.message;
            });
    }

}]);	

	
	/*
	$scope.updateCustomer = function (id) {
        var cust;
        for (var i = 0; i < $scope.customers.length; i++) {
            var currCust = $scope.customers[i];
            if (currCust.ID === id) {
                cust = currCust;
                break;
            }
        }

         dataFactory.updateCustomer(cust)
          .then(function (response) {
              $scope.status = 'Updated Customer! Refreshing customer list.';
          }, function (error) {
              $scope.status = 'Unable to update customer: ' + error.message;
          });
    };

    $scope.insertCustomer = function () {
        //Fake customer data
        var cust = {
            ID: 10,
            FirstName: 'JoJo',
            LastName: 'Pikidily'
        };
        dataFactory.insertCustomer(cust)
            .then(function (response) {
                $scope.status = 'Inserted Customer! Refreshing customer list.';
                $scope.customers.push(cust);
            }, function(error) {
                $scope.status = 'Unable to insert customer: ' + error.message;
            });
    };

    $scope.deleteCustomer = function (id) {
        dataFactory.deleteCustomer(id)
        .then(function (response) {
            $scope.status = 'Deleted Customer! Refreshing customer list.';
            for (var i = 0; i < $scope.customers.length; i++) {
                var cust = $scope.customers[i];
                if (cust.ID === id) {
                    $scope.customers.splice(i, 1);
                    break;
                }
            }
            $scope.orders = null;
        }, function (error) {
            $scope.status = 'Unable to delete customer: ' + error.message;
        });
    };
	*/
	
