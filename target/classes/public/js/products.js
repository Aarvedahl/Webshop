angular.module('hello', [])
    .controller('articles', function($scope, $http) {
        $http.get('http://localhost:8080/articles').
        then(function(response) {
            $scope.articles = response.data;
        });
    });