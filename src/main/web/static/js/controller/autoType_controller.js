'use strict';

App.controller('AutoTypeController', ['$scope', 'AutoTypeService', function($scope, AutoTypeService) {
          var self = this;
          self.autoType={id:null,name:'',isDelete:false};
          self.autoTypes=[];
              
          self.fetchAllAutoTypes = function(){
              AutoTypeService.fetchAllAutoTypes()
                  .then(
      					       function(d) {
      						        self.autoTypes = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
           
          self.createAutoType = function(autoType){
              AutoTypeService.createAutoType(autoType)
		              .then(
                      self.fetchAllAutoTypes,
				              function(errResponse){
					               console.error('Error while creating AutoType.');
				              }	
                  );
          };

         self.updateAutoType = function(autoType, id){
             AutoTypeService.updateAutoType(autoType, id)
		              .then(
				              self.fetchAllAutoTypes,
				              function(errResponse){
					               console.error('Error while updating AutoType.');
				              }	
                  );
          };

         self.deleteAutoType = function(id){
             AutoTypeService.deleteAutoType(id)
		              .then(
				              self.fetchAllAutoTypes,
				              function(errResponse){
					               console.error('Error while deleting AutoType.');
				              }	
                  );
          };

          self.fetchAllAutoTypes();

          self.submit = function() {
              if(self.autoType.id==null){
                  console.log('Saving New AutoType', self.autoType);
                  self.createAutoType(self.autoType);
              }else{
                  self.updateAutoType(self.autoType, self.autoType.id);
                  console.log('AutoType updated with id ', self.autoType.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.autoTypes.length; i++){
                  if(self.autoTypes[i].id == id) {
                     self.autoType = angular.copy(self.autoTypes[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.autoType.id === id) {//clean form if the AutoType to be deleted is shown there.
                 self.reset();
              }
              self.deleteAutoType(id);
          };

          
          self.reset = function(){
              self.autoType={id:null,name:'',isDelete:false};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
