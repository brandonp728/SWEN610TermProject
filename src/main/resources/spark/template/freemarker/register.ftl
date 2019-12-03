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
    
    <div class="navigation">
      <a href="/">my home</a>
    </div>

    <h3>No account? Sign up</h3>
    <div>
        <h4>${error}</h4>
        <form method = "POST">
          First Name: <input name = "f_name"/>
          <br />
          Last Name: <input name = "l_name"/>
          <br />
          Username: <input name = "username"/>
          <br />
          Password:  <input name = "password" />
          <br />
          <button type = "submit">Register</button>
        </form>
    </div>
  </div>
</body>
</html>