'use strict';

App.controller('MainController', ['$scope', 'MainService', function($scope, MainService) {
    var self = this;
    self.element;
    self.elements=[];
    self.directories=[];
    self.tableNames = ["autoMarka", "autoModel", "autoType", "lift", "master", "ownerAuto", "price", "specialization", "work", "workType"];
    self.tableName = 'autoModel';

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

    self.getDirectory = function(tableName)
    {
        var result;
        angular.forEach(self.directories, function (directory) {
            if (tableName == directory.tableName)
                result = directory.data;
                return;
        });
        return result;
    };

    self.fills = function(){
        MainService.getAllElements("autoMarka").then(
            function(d) {
                self.directories.push({tableName : "autoMarka", data : d});
            },
            function(errResponse){
                console.error('Error while fetching Currencies');
            }
        );

        MainService.getAllElements("autoType").then(
            function(d) {
                self.directories.push({tableName : "autoType", data : d});
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

    self.changeTable = function(tableName){
        if (tableName) {
            self.tableName = tableName;
        }
        if (self.tableName == "autoMarka") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        } else if (self.tableName == "autoModel") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete", "Automarka", "Autotype"];
            self.tableStructure.fields = ["id", "name", "isDelete", "autoMarka", "autoType"];
        } else if (self.tableName == "autoType") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        } else if (self.tableName == "lift") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Number", "Delete"];
            self.tableStructure.fields = ["id", "number", "isDelete"];
        } else if (self.tableName == "master") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        } else if (self.tableName == "ownerAuto") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Year", "Gosnumber", "Delete", "Auto"];
            self.tableStructure.fields = ["id", "name", "year", "gosNumber", "isDelete", "autoModel"];
        } else if (self.tableName == "price") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Time", "Money", "Delete"];
            self.tableStructure.fields = ["id", "time", "money", "isDelete"];
        } else if (self.tableName == "specialization") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        } else if (self.tableName == "work") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Start date", "End date", "Owner", "Work type", "Lift", "Master", "Done", "Actual time", "Actual money", "Delete"];
            self.tableStructure.fields = ["id", "startWorkDate", "endWorkDate", "ownerAuto", "workType", "lift", "master", "done", "actualTime", "actualMoney", "isDelete"];
        } else if (self.tableName == "workType") {
            self.tableStructure = {};
            self.tableStructure.headers = ["ID", "Name", "Delete"];
            self.tableStructure.fields = ["id", "name", "isDelete"];
        }
        //$scope.myForm.$setPristine(); //reset Form
        self.getAllElements(self.tableName);
    };

    self.fills();
    self.changeTable();
    // self.getAllElements(self.tableName);

}]);
