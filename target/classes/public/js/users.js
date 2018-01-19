angular.module('webshop', [])
    .controller('usersController', function($scope, $http) {
        $scope.showAlert = false;

        $http.get('http://localhost:8080/api/users').
        then(function(response) {
            $scope.users = response.data;
            console.log(response.data);
        });


    });