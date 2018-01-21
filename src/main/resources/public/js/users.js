angular.module('webshop', [])
    .controller('usersController', function($scope, $http) {

        $http.get('http://localhost:8080/api/users').
        then(function(response) {
            $scope.users = response.data;
        });

        $scope.removeUser = function (user) {
          $http({
                url: '../api/users',
                method: "DELETE",
                data: user,
                headers: {
                    'Content-type': 'application/json'
                }
            })
                .then(function(response) {
                        // success
                        $scope.showAlert = true;
                        $scope.users = response.data;

                    },
                    function(response) {
                        // failed
                        console.log("error");
                        console.error(response);
                    });
        };
        // TODO Display the articles of each order
        // TODO Click on each user to view their order details and click on each order to view every article
        /* För att avbeställa en order skicka json i detta format

        {
            "orderid": 5,
            "userid":1,
            "orderdate": 1515538800000,
            "canceled": true
        }

         */
    });