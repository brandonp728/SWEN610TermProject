<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
  <div class="page">
  
    <h1>Web Checkers</h1>
    
    <div class="navigation" align="center">
      <a href="/">my home</a><a href="/choosegame" style="margin-left: 40px;">choose a game</a>
    </div>
    <h2 align="center"><h2>${error}</h2>
    <div class="body">
    <table align="center" cellspacing="30">
      <tr>
        <td>
        <form method = "POST">
        <table align="left">
            <tr><td>Username: <input name = "username"/></td></tr>
            <tr><td>Password: <input name = "password" /></td></tr>
          </table>
          <button type="submit">Log In</button>
        </form>
        </td>
        <td>
        Register:
        <form method = "POST">
          <table align="right">
            <tr><td>First Name: <input name = "f_name"/></td></tr>
            <tr><td>Last Name: <input name = "l_name"/></td></tr>
            <tr><td>Username: <input name = "username"/></td></tr>
            <tr><td>Password: <input name = "password" /></td></tr>
          </table>
          <button type = "submit">Register</button>
        </form>
        </td>
      </tr>
    </table>
    </div>
  </div>
</body>
</html>