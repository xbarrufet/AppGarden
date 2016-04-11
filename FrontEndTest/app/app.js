

var app=angular.module('gviewTest', ['ngRoute','ui.bootstrap']);
app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/gardenCenter', {
        templateUrl: 'templates/gardenCenter_view.html',
        controller: 'GardenCenterController'
      }).
      when('/gardenCenterEdit', {
          templateUrl: 'templates/gardenCenterEdit_view.html',
          controller: 'GardenCenterEditController'
       }).
      when('/gardenCenterEdit/:gardenCenterId', {
          templateUrl: 'templates/gardenCenterEdit_view.html',
          controller: 'GardenCenterEditController'
        }).
       when('/client', {
            templateUrl: 'templates/client_view.html',
            controller: 'clientController'
          }).
       when('/clientEdit', {
              templateUrl: 'templates/clientEdit_view.html',
              controller: 'clientEditController'
           }).
          when('/clientEdit/:clientId', {
              templateUrl: 'templates/clientEdit_view.html',
              controller: 'clientEditController'
            }).
      otherwise({
        redirectTo: '/gardenCenter'
      });
  }]);