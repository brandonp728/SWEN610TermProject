<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>${title} | Web Checkers</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script src="/js/main.js"></script>
</head>
<body>
  <div class="page">
  
    <h1>Web Checkers</h1>
    
    <div class="navigation" align="center">
      <a href="/">my home</a><a href="/choosegame" style="margin-left: 40px;">choose a game</a>
    </div>
    <h2 align="center">${error}</h2>
    <div class="body">
    <#if !twoplayer>
      <h2>Set your rules</h2>
      <form method="POST">
        Number of Players:
        <table align="center" cellspacing="30">
            <tr>
                <td><input type="radio" name="playerNum" value="1 Player">1 Player</td>
                <td><input type="radio" name="playerNum" value="2 Players">2 Players</td>
            </tr>
        </table>
        <br /> 
        Difficulty:
        <table align="center" cellspacing="50">
            <tr>
                <td><input type="radio" name="difficulty" value="Easy">Easy</td>
                <td><input type="radio" name="difficulty" value="Hard">Hard</td>
            </tr>
        </table>
        <button type="submit">Submit</button>
      </form>
      </#if>
      <#if twoplayer>
        <h3><a href="/playertwosignin">Sign in!</a></h3>
      </#if>
    </div>
  </div>
</body>
</html>