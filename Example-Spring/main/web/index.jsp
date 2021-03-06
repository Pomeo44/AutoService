<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Devcolibri.com exam REST</title>
</head>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
  var prefix = '/service';

  var RestGetAll = function() {
    $.ajax({
      type: 'GET',
      url:  prefix + '/',
      dataType: 'json',
      async: true,
      success: function(result) {
        alert('Время: ' + result.id
                + ', сообщение: ' + result.message);
      },
      error: function(jqXHR, textStatus, errorThrown) {
        alert(jqXHR.status + ' ' + jqXHR.responseText);
      }
    });
  }

  var RestGet = function() {
    $.ajax({
      type: 'GET',
      url:  prefix + '/' + '321',
      dataType: 'json',
      async: true,
      success: function(result) {
        alert('Время: ' + result.id
                + ', сообщение: ' + result.message);
      },
      error: function(jqXHR, textStatus, errorThrown) {
        alert(jqXHR.status + ' ' + jqXHR.responseText);
      }
    });
  }

  var RestPut = function() {
    var JSONObject= {
      'id': Date.now(),
      'message': 'Это пример вызова PUT метода'
    };

    $.ajax({
      type: 'PUT',
      url:  prefix,
      contentType: 'application/json; charset=utf-8',
      data: JSON.stringify(JSONObject),
      dataType: 'json',
      async: true,
      success: function(result) {
        alert('Время: ' + result.id
                + ', сообщенеи: ' + result.message);
      },
      error: function(jqXHR, textStatus, errorThrown) {
        alert(jqXHR.status + ' ' + jqXHR.responseText);
      }
    });
  }

  var RestPost = function() {
    $.ajax({
      type: 'POST',
      url:  prefix,
      dataType: 'json',
      async: true,
      success: function(result) {
        alert('Время: ' + result.id
                + ', сообщение: ' + result.message);
      },
      error: function(jqXHR, textStatus, errorThrown) {
        alert(jqXHR.status + ' ' + jqXHR.responseText);
      }
    });
  }

  var RestDelete = function() {
    $.ajax({
      type: 'DELETE',
      url:  prefix + '/' + '321',
      dataType: 'json',
      async: true,
      success: function(result) {
        alert('Время: ' + result.id
                + ', сообщение: ' + result.message);
      },
      error: function(jqXHR, textStatus, errorThrown) {
        alert(jqXHR.status + ' ' + jqXHR.responseText);
      }
    });
  }
</script>

<body>

<h3>Это простой пример использования REST c помощью Ajax</h3>

<button type="button" onclick="RestGetAll()">Метод GET ALL</button>
<button type="button" onclick="RestGet()">Метод GET</button>
<button type="button" onclick="RestPost()">Метод POST</button>
<button type="button" onclick="RestDelete()">Метод DELETE</button>
<button type="button" onclick="RestPut()">Метод PUT</button>

</body>
</html>
