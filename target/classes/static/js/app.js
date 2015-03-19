var simple = angular.module('simple', ['ngRoute', 'ngResource']);

simple.config(function($routeProvider){
	$routeProvider
	.when('/date', {
		templateUrl: '/partials/datesnippet.html',
//		controller: ''
	})
	.otherwise({
		templateUrl: '/partials/homesnippet.html',
		controller: 'HomeCtrl'
	});
})

simple.controller('HomeCtrl', function($scope, $resource) {
	
	$scope.toGetData = $resource('/rest', {isArray:true});	
	$scope.toPostData = $resource('/rest/:name', {name: '@name'}, {isArray:true});
	
	//now get data
	$scope.toGetData.query(function(data){
		$scope.data = data;
	});	
	
	$scope.send = function() {
		
		console.log($scope.name);
		
		$scope.toGetData.get({name: $scope.name}, function() {
			console.log('done');
		});
	
	};

});