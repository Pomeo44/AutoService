'use strict';

App.controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
          var self = this;
          self.autoType={id:null,name:''};
          self.autoTypes=[];
              
          self.fetchAllUsers = function(){
              UserService.fetchAllUsers()
                  .then(
      					       function(d) {
      						        self.autoTypes = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
           
          self.createUser = function(autoType){
              UserService.createUser(autoType)
		              .then(
                      self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while creating User.');
				              }	
                  );
          };

         self.updateUser = function(autoType, id){
              UserService.updateUser(autoType, id)
		              .then(
				              self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while updating User.');
				              }	
                  );
          };

         self.deleteUser = function(id){
              UserService.deleteUser(id)
		              .then(
				              self.fetchAllUsers, 
				              function(errResponse){
					               console.error('Error while deleting User.');
				              }	
                  );
          };

          self.fetchAllUsers();

          self.submit = function() {
              if(self.autoType.id==null){
                  console.log('Saving New User', self.autoType);
                  self.createUser(self.autoType);
              }else{
                  self.updateUser(self.autoType, self.autoType.id);
                  console.log('User updated with id ', self.autoType.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.users.length; i++){
                  if(self.autoTypes[i].id == id) {
                     self.autoType = angular.copy(self.autoTypes[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.autoType.id === id) {//clean form if the user to be deleted is shown there.
                 self.reset();
              }
              self.deleteUser(id);
          };

          
          self.reset = function(){
              self.autoType={id:null,name:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
