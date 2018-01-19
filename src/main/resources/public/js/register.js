angular.module('register', [])
    .controller('registerController', function($scope, $http) {
        $scope.showAlert = false;

        $scope.addUsers = function (userdto) {
            console.log("We are supposed to add this user here");
            console.log(userdto);
            $http({
                url: '../api/users',
                method: "POST",
                data: userdto,
                headers: {
                    'Content-type': 'application/json'
                }
            })
                .then(function(response) {
                        // success
                        $scope.showAlert = true;
                        console.log("SUCCESS");
                    },
                    function(response) {
                        // failed
                        console.log("error");
                        console.error(response);
                    });
        };


    });