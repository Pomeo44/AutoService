'use strict';

App.factory('MainService', ['$http', '$q', function($http, $q){

	return {
		
			getAllElements: function(tableName) {
					return $http.get('http://localhost:8080/service/' + tableName + '/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching autoTypes');
										return $q.reject(errResponse);
									}
							);
			},
		    
		    createElement: function(tableName, autoType){
					return $http.post('http://localhost:8080/service/' + tableName + '/', autoType)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating autoTypes');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateElement: function(tableName, autoType, id){
					return $http.put('http://localhost:8080/service/' + tableName + '/'+id, autoType)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating autoType');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteElement: function(tableName, id){
					return $http.delete('http://localhost:8080/service/' + tableName + '/'+ id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting autoType');
										return $q.reject(errResponse);
									}
							);
			}
		
	};

}]);
