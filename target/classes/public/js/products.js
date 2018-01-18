angular.module('hello', [])
    .controller('articles', function($scope, $http) {
        $scope.checked = false;

        $http.get('http://localhost:8080/articles').
        then(function(response) {
            $scope.articles = response.data;
        });

        $scope.editArticle = function(article){
            $scope.checked = true;
            $scope.tempUserData = {
                articleid:article.articleid,
                articlename:article.articlename,
                brand:article.brand,
                price:article.price,
                description:article.description
            };
//            $('.formData').slideDown();
        };

        $scope.addArticle = function () {
            console.log("WE SHALL ADD A ARTICLE HERE");
        };

        $scope.deleteArticle = function (article) {
            console.log("We are supposed to delete a article here");
            console.log(article);
        };

        $scope.changeChecked = function () {
            $scope.checked = false;
        }
    });