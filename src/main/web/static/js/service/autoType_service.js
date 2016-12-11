'use strict';

App.factory('AutoTypeService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllAutoTypes: function() {
					return $http.get('http://localhost:8080/service/autotype/')
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
		    
		    createAutoType: function(autoType){
					return $http.post('http://localhost:8080/service/autotype/', autoType)
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
		    
		    updateAutoType: function(autoType, id){
					return $http.put('http://localhost:8080/service/autotype/'+id, autoType)
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
		    
			deleteAutoType: function(id){
					return $http.delete('http://localhost:8080/service/autotype/'+id)
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
