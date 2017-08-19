'use strict';

App.controller('MainController', ['$scope', 'MainService', function($scope, MainService) {
    var self = this;
    self.element;
    self.elements=[];
    self.tableNames = ["autoType", "autoModel", "autoType", "lift", "master", "ownerAuto", "price", "specialization", "work", "workType"];
    self.tableName = 'automodel';

    self.tableStructure = {};
    self.tableStructure.headers = ["ID", "Name", "Delete", "Automarka", "Autotype"];
    self.tableStructure.fields = ["id", "name", "isDelete", "autoMarka", "autoType"];

    self.cars = [
        {model : "Ford Mustang", color : "red"},
        {model : "Fiat 500", color : "white"},
        {model : "Volvo XC90", color : "black"}
    ];

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
                console.error('Error while creating ' + self.tableName + '.');
			}
        );
    };

    self.updateElement = function(element, id){
        MainService.updateElement(self.tableName, element, id)
        .then(
            self.getAllElements,
            function(errResponse){
                console.error('Error while updating ' + self.tableName + '.');
            }
        );
    };

    self.deleteElement = function(id) {
        MainService.deleteElement(self.tableName, id)
        .then(
            self.getAllElements,
			function(errResponse) {
			    console.error('Error while deleting ' + self.tableName + '.');
			}
        );
    };

    self.submit = function() {
        if(self.element.id==null) {
            console.log('Saving New ' + self.tableName, self.element);
            self.createElement(self.element);
        } else {
            self.updateElement(self.element, self.element.id);
            console.log(self.tableName + ' updated with id ', self.element.id);
        }
        self.reset();
    };
              
    self.edit = function(id) {
        console.log('id to be edited', id);
        for(var i = 0; i < self.elements.length; i++) {
            if(self.elements[i].id == id) {
                self.updateElement(self.elements[i], self.elements[i].id);
                break;
            }
        }
    };
              
    self.remove = function(id){
        console.log('id to be deleted', id);
        if (self.element != null && self.element.id === id) {//clean form if the element to be deleted is shown there.
            self.reset();
        }
        self.deleteElement(id);
    };

          
    self.reset = function(){
        self.element = {id:null,name:'',isDelete:false};
        $scope.myForm.$setPristine(); //reset Form
    };

    self.getElementData = function(name, data)
    {
        var result;
      var pathArr = name.split('.');
      angular.forEach(pathArr, function (path) {
          result = result? result[path] : data[path];
      });
      return result;
    };

    self.changeTable = function(tableName){
        if (tableName) {
            self.tableName = tableName;
        }
        if (self.tableName == "autotype") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        } else if (self.tableName == "automodel") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        } else if (self.tableName == "automodel") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete", "Automarka", "Autotype"];
            self.tableStructure.fields = ["id", "name", "isDelete", "autoMarka", "autoType"];
        } else if (self.tableName == "lift") {  "lift", "master", "ownerAuto", "price", "specialization", "work", "workType"
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        } else if (self.tableName == "master") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        } else if (self.tableName == "price") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        } else if (self.tableName == "specialization") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        } else if (self.tableName == "work") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        } else if (self.tableName == "workType") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        }
        $scope.myForm.$setPristine(); //reset Form
        self.getAllElements(self.tableName);
    };

    self.getAllElements(self.tableName);

    self.getDataFromElement = function(field){

    }

}]);
