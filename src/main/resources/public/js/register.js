angular.module('register', [])
    .controller('registerController', function($scope, $http) {
        $scope.showAlert = false;

        $scope.addUsers = function (users) {
            console.log("We are supposed to add this user here");
            console.log(users);
            $scope.showAlert = true;
            $scope.users = {};
        };

    });