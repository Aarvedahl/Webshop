angular.module('register', [])
    .controller('registerController', function($scope, $http) {
        $scope.showAlert = false;

        $scope.addUsers = function (user) {
            $http({
                url: '../api/users/add',
                method: "POST",
                data: user,
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
                        console.log("error");
                        console.error(response);
                    });
        };


    });