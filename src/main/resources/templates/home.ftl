<!DOCTYPE html>
<html>
<script src=https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<body>

<div ng-app="springDemo" ng-controller="AppCtrl">

    <h1 ng-repeat="x in articles">
            {{ x.id }}
           {{ x.name }}
        </h1>
    <a href="article1.html"><button type="button" class="btn btn-primary">Push №1</button></a>
       <a href="article2.html"><button type="button" class="btn btn-info">Push №2</button></a>
    <a href="article3.html"><button type="button" class="btn btn-primary">Push №3</button></a>
</div>

<script>
    var app = angular.module('springDemo', []);
    app.controller('AppCtrl', function($scope, $http) {
        $http.get("http://localhost:8099/get-all")
                .success(function (data){ $scope.articles = data;
                });
    });
</script>

</body>
</html>
