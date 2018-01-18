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
           // $scope.showAlert = true;
            $scope.users = {};
        };

        $scope.create = function(album) {
            album.songs = [];
            console.log(album);
            $http({
                url: 'http://localhost:8080/albums/addAlbum',
                method: "POST",
                data: album,
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(function(response) {
                        // success
                        $scope.failed = false;
                        $scope.success = true;
                    },
                    function(response) {
                        // failed
                        $scope.success = false;
                        $scope.failed = true;
                        console.error(response);
                    });
        };

    });