<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
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
              <div class="panel-heading"><span class="lead">{{ctrl.tableName}} registration form </span></div>
              <div class="formcontainer">
                  <form action="select1.php" method="post">
                      <%--<p><select size="3" multiple name="tableNames[]">--%>
                          <%--<option disabled>привет</option>--%>
                          <%--<option value="autotype">привет 1</option>--%>
                          <%--<option selected value="automodel">привет 2</option>--%>
                          <%--<option value="automarka">привет 3</option>--%>
                      <%--</select></p>--%>
                      <button type="button" ng-click="ctrl.changeTable('autotype')" >autotype</button>
                      <button type="button" ng-click="ctrl.changeTable('automodel')" >automodel</button>
                      <button type="button" ng-click="ctrl.changeTable('automarka')" >automarka</button>
                      <select ng-options="x in ctrl.cars"></select>

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
                        <select ng-options="x in ctrl.cars"></select>
                      </div>
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="Add" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of {{ctrl.tableName}}</span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th ng-repeat="header in ctrl.tableStructure.headers">{{header}}</th>
                          </tr>
                      </thead>
                      <tbody >
                            <tr ng-repeat="dataElement in ctrl.elements">
                                    <td ng-repeat="fieldName in ctrl.tableStructure.fields">
                                        <%--<span ng-bind="ctrl.getElementData(fieldName, dataElement)"></span>--%>
                                        <%--<input type="text" ng-model="ctrl.getElementData(fieldName, dataElement)" name="uname" class="elementName form-control input-sm"/>--%>
                                        <input ng-if="fieldName == 'isDelete'" type="checkbox" ng-model="dataElement[fieldName]" class="elementName form-control input-sm"/>
                                        <input ng-if="fieldName != 'isDelete' && !dataElement[fieldName]['name']" type="text" ng-model="dataElement[fieldName]" class="elementName form-control input-sm"/>
                                        <select ng-if="fieldName != 'isDelete' && dataElement[fieldName]['name']" ng-options="x in ctrl.tableStructure.headers" class="elementName form-control input-sm"></select>
                                    </td>
                                    <td>
                                        <button type="button" ng-click="ctrl.edit(dataElement.id)" class="btn btn-success custom-width">Edit</button>
                                        <button type="button" ng-click="ctrl.remove(dataElement.id)" class="btn btn-danger custom-width">Remove</button>
                                    </td>
                            </tr>
                      </tbody>
                      <span ng-if="data.field.length">
                          <span ng-repeat="item in data.field">
                              <span ng-bind="item.value"></span>
                          </span>
                      </span>
                      <span ng-if="!data.field.length">
                          <span ng-bind="data.field">

                          </span>
                      </span>
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