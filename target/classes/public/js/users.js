angular.module('webshop', [])
    .controller('usersController', function ($scope, $http) {

        $http.get('http://localhost:8080/api/users').then(function (response) {
            console.log(response.data);
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
                .then(function (response) {
                        // success
                        $scope.showAlert = true;
                        $scope.users = response.data;

                    },
                    function (response) {
                        // failed
                        console.log("error");
                        console.error(response);
                    });
        };

        $scope.cancelOrder = function (user, order) {
            delete order.articleList;
            order.userid = user.userid;
            order.canceled = !order.canceled;
            $http({
                url: '../api/orders',
                method: "PATCH",
                data: order,
                headers: {
                    'Content-type': 'application/json'
                }
            })
                .then(function (response) {
                        // success
                        $http.get('http://localhost:8080/api/users').then(function (response) {
                            console.log(response.data);
                            $scope.users = response.data;
                        });
                    },
                    function (response) {
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
        /*
        "orders": [
            {
                "orderid": 2,
                "orderdate": 1515538800000,
                "canceled": false,
                "articleList": [
                    {
                        "purchaseid": 2,
                        "articleid": {
                            "articleid": 7,
                            "articlename": "Airpods",
                            "description": "Simply Awesome",
                            "price": 1749,
                            "stock": 0,
                            "brand": "Apple"
                        }
                    }
                ]
         */
    });