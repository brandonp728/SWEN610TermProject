<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
  <div class="page">
  
    <h1>Log In</h1>
    
    <div class="navigation" align="center">
      <a href="/">my home</a>
    </div>

    <h3 align="center">Got an account? Log in</h3>
    <div id="loginform" align="center">
        <h4>${error}</h4>
        <form method = "POST">
          <table align="center">
            <tr><td>Username: <input name = "username"/></td></tr>
            <tr><td>Password: <input name = "password" /></td></tr>
          </table>
          <button type="submit">Log In</button>
        </form>
    </div>
</body>
</html>
