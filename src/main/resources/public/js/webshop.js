angular.module('products', [])
  .controller('hello', function($scope, $http) {
    $http.get('http://rest-service.guides.spring.io/greeting').
    then(function(response) {
      $scope.greeting = response.data;
    });
  });