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
    
    <div class="navigation">
      <a href="/">my home</a>
    </div>
    
    <div class="body">
      <h2>Welcome to the world of online Checkers!</h2>
    </div>

    <div class = "image" align="center">
      <img src = "/img/checkers_image.jpg" height="300" width="500">
    </div>
  <#if loggedIn == false>
    <div class = "body">
      <table cellspacing = "30" align="center">
        <tr>
          <td><h3><a href="/login">Log In</a></h3></td>
          <td><h3><a href="/register">Register</a><h3></td>
        </tr>
      </table>
    </div>
    </#if>
    <#if loggedIn>
      <div class = "body">
        <p>Ready to play a game?</p>
         <button type="submit" formaction="/choosegame">You bet!</button>
      </div>
    </#if>
  </div>
</body>
</html>
