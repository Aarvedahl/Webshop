angular.module('webshop', [])
    .controller('usersController', function($scope, $http) {

        $http.get('http://localhost:8080/api/users').
        then(function(response) {
            $scope.users = response.data;
        });

        // TODO Display the articles of each order
    });