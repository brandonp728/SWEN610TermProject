<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
  <div class="page">
  
    <h1>Register With Us</h1>
    
    <div class="navigation" align="center">
      <a href="/">my home</a>
    </div>

    <h3 align ="center">No account? Sign up</h3>
    <div align="center">
        <h4>${error}</h4>
        <form method = "POST">
        <h2 align="center">Register with us!</h2>
          <table align="center">
            <tr><td>First Name: <input name = "f_name"/></td></tr>
            <tr><td>Last Name: <input name = "l_name"/></td></tr>
            <tr><td>Username: <input name = "username"/></td></tr>
            <tr><td>Password: <input name = "password" /></td></tr>
          </table>
          <button type = "submit">Register</button>
        </form>
    </div>
  </div>
</body>
</html>