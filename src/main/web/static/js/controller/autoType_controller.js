'use strict';

App.controller('MainController', ['$scope', 'MainService', function($scope, MainService) {
    var self = this;
    self.element={id:null,name:'',isDelete:false};
    self.elements=[];
    self.tableName = 'autotype';

    self.getAllElements = function(){
        MainService.getAllElements(self.tableName)
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
        MainService.createElement(self.tableName, element)
		.then(
            self.getAllElements,
			function(errResponse){
                console.error('Error while creating ' + tableName + '.');
			}
        );
    };

    self.updateElement = function(element, id){
        MainService.updateElement(self.tableName, element, id)
        .then(
            self.getAllElements,
            function(errResponse){
                console.error('Error while updating ' + tableName + '.');
            }
        );
    };

    self.deleteElement = function(id) {
        MainService.deleteElement(self.tableName, id)
        .then(
            self.getAllElements,
			function(errResponse) {
			    console.error('Error while deleting ' + tableName + '.');
			}
        );
    };

    self.submit = function() {
        if(self.element.id==null) {
            console.log('Saving New ' + tableName, self.element);
            self.createElement(self.element);
        } else {
            self.updateElement(self.element, self.element.id);
            console.log(tableName + ' updated with id ', self.element.id);
        }
        self.reset();
    };
              
    self.edit = function(id) {
        console.log('id to be edited', id);
        for(var i = 0; i < self.elements.length; i++) {
            if(self.elements[i].id == id) {
                self.element = angular.copy(self.elements[i]);
                break;
            }
        }
    };
              
    self.remove = function(id){
        console.log('id to be deleted', id);
        if (self.element.id === id) {//clean form if the element to be deleted is shown there.
            self.reset();
        }
        self.deleteElement(id);
    };

          
    self.reset = function(){
        self.element = {id:null,name:'',isDelete:false};
        $scope.myForm.$setPristine(); //reset Form
    };

    self.changeTable = function(tableName){
        self.tableName = tableName;
        $scope.myForm.$setPristine(); //reset Form
        self.getAllElements();
    };

    self.getAllElements();

}]);
