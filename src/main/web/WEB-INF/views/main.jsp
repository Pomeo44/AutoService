<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Main page Auto Service</title>
    <style>
      .elementName.ng-valid {
          background-color: lightgreen;
      }
      .elementName.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .elementName.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }

      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }

    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet">
  </head>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="MainController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">ctrl.tableName registration form </span></div>
              <div class="formcontainer">
                  <form action="select1.php" method="post">
                      <p><select size="3" multiple name="tableNames[]">
                          <option disabled>???????? ?????</option>
                          <option value="autotype">?????????</option>
                          <option selected value="automodel">???????? ????</option>
                          <option value="automarka">????????</option>
                      </select></p>
                      <button type="button" ng-click="ctrl.changeTable('autotype')" >change table</button>
                      <button type="button" ng-click="ctrl.changeTable('automodel')" >change table</button>
                      <button type="button" ng-click="ctrl.changeTable('automarka')" >change table</button>
                  </form>
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.element.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.element.name" name="uname" class="elementName form-control input-sm" placeholder="Enter name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable">Is delete</label>
                              <div class="col-md-7">
                                  <input type="checkbox" ng-model="ctrl.element.isDelete" class="form-control input-sm"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.element.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of AutoType </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th ng-repeat="header in ctrl.tableStructure.headers">{{header}}</th>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>IsDelete</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody><tr ng-repeat="element in ctrl.elements"></tr>
                            <tr ng-repeat="fieldName in ctrl.tableStructure.fields">
                                <td><span ng-bind="element[fieldName]"></span></td>
                          <tr ng-repeat="u in ctrl.elements">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.name"></span></td>
                              <td><span ng-bind="u.isDelete"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/autoType_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/autoType_controller.js' />"></script>
  </body>
</html>