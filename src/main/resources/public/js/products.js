angular.module('hello', [])
    .controller('articles', function($scope, $http) {
        $scope.checked = false;

        $http.get('http://localhost:8080/articles').
        then(function(response) {
            $scope.articles = response.data;
        });

        $scope.editArticle = function(article){
            $scope.checked = true;
            $scope.tempArticleData = {
                articleid:article.articleid,
                articlename:article.articlename,
                brand:article.brand,
                price:article.price,
                description:article.description
            };
        };

        $scope.addArticle = function (articleToAdd) {
            console.log("We are supposed to add a article here");
            console.log(articleToAdd);
            $scope.checkedFalse();
            $scope.tempArticleData = {};
        };

        $scope.deleteArticle = function (articleToDelete) {
            console.log("We are supposed to delete a article here");
            console.log(articleToDelete);
        };

        $scope.updateArticle = function (articleToUpdate) {
            console.log("We are supposed to update a article here");
            console.log(articleToUpdate);
            $scope.checkedFalse();
            $scope.tempArticleData = {};
        };

        $scope.checkedFalse = function () {
            $scope.checked = false;
        };

        $scope.checkedTrue = function () {
            $scope.checked = true;
        };
    });