'use strict';

App.factory('MainService', ['$http', '$q', function($http, $q){
	var self = this;
    self.restAddress = 'http://localhost:8081/service/';
	return {
		
	getAllElements: function(tableName) {
		return $http.get(self.restAddress + tableName + '/')
			.then(function(response) {
					return response.data;
				} ,function(errResponse) {
					console.error('Error while fetching element');
					return $q.reject(errResponse);
				}
			);
		},
		    
		createElement: function(tableName, element) {
			return $http.post(self.restAddress + tableName + '/', element)
				.then(function(response) {
					return response.data;
				}, function(errResponse) {
					console.error('Error while creating element');
					return $q.reject(errResponse);
				}
			);
		},

		updateElement: function(tableName, element, id) {
			return $http.put(self.restAddress + tableName + '/'+id, element)
				.then(function(response) {
					return response.data;
				}, function(errResponse) {
					console.error('Error while updating element');
					return $q.reject(errResponse);
				}
			);
		},

		deleteElement: function(tableName, id) {
			return $http.delete(self.restAddress + tableName + '/'+ id)
			.then(function(response){
					return response.data;
				}, function(errResponse) {
					console.error('Error while deleting element');
					return $q.reject(errResponse);
				}
			);
		}
		
	};

}]);
