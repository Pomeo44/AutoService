'use strict';

App.controller('AutoTypeController', ['$scope', 'AutoTypeService', function($scope, AutoTypeService) {
          var self = this;
          self.element={id:null,name:'',isDelete:false};
          self.elements=[];
          self.tableName = 'autotype';
              
          self.getAllElements = function(){
              AutoTypeService.getAllElements(tableName)
                  .then(
      					       function(d) {
      						        self.elements = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
           
          self.createElement = function(element){
              AutoTypeService.createElement(element)
		              .then(
                      self.getAllElements,
				              function(errResponse){
					               console.error('Error while creating AutoType.');
				              }	
                  );
          };

         self.updateAutoType = function(element, id){
             AutoTypeService.updateAutoType(element, id)
		              .then(
				              self.getAllElements,
				              function(errResponse){
					               console.error('Error while updating AutoType.');
				              }	
                  );
          };

         self.deleteAutoType = function(id){
             AutoTypeService.deleteAutoType(id)
		              .then(
				              self.getAllElements,
				              function(errResponse){
					               console.error('Error while deleting AutoType.');
				              }	
                  );
          };

          self.getAllElements();

          self.submit = function() {
              if(self.element.id==null){
                  console.log('Saving New AutoType', self.element);
                  self.createElement(self.element);
              }else{
                  self.updateAutoType(self.element, self.element.id);
                  console.log('AutoType updated with id ', self.element.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.element.length; i++){
                  if(self.elements[i].id == id) {
                     self.element = angular.copy(self.elements[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.element.id === id) {//clean form if the AutoType to be deleted is shown there.
                 self.reset();
              }
              self.deleteAutoType(id);
          };

          
          self.reset = function(){
              self.element={id:null,name:'',isDelete:false};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
