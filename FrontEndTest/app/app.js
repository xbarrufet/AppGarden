

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
      otherwise({
        redirectTo: '/gardenCenter'
      });
  }]);