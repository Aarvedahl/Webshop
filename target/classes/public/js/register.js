angular.module('register', [])
    .controller('registerController', function($scope, $http) {
        $scope.showAlert = false;

        $scope.addUsers = function (users) {
            console.log("We are supposed to add this user here");
            console.log(users);
            $http({
                url: '../users',
                method: "POST",
                data: users,
                headers: {
                    'Content-type': 'application/json'
                }
            })
                .then(function(response) {
                        // success
                        $scope.showAlert = true;
                    },
                    function(response) {
                        // failed
                        console.error(response);
                    });
            $scope.users = {};
        };


    });