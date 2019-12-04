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
      <h2>Welcome ${username}!</h2>
      <p>What would you like to do?</p>
    </div>
    <table align="center" cellspacing="30">
      <tr>
        <td><a href="/creategame">Play A Game</a></td><td><a href="/createtournament">Play a Tournament</a></td>
      </tr>
    </table>
    
  </div>
</body>
</html>