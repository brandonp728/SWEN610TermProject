<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
  <title> Web Checkers</title>
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/game.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script>
  </script>
</head>
<body>
  <div class="page">
    <h1>Web Checkers</h1>
    
    <div class="navigation">
    <#if currentPlayer??>
      <a href="/">my home</a> |
    <#else>
      <a href="/signin">sign in</a>
    </#if>
    </div>
    
    <div class="body">
     <p>Piece One: </p> 
     <ul>
      <li>Color: ${blackPieceColor}</li>
      <li>King?: ${isBlackKing}</li> 
     </ul>
     <p>Piece Two: </p> 
     <ul>
      <li>Color: ${redPieceColor}</li>
      <li>King?: ${isRedKing}</li> 
     </ul>
    </div>
  </div>

  <audio id="audio" src="http://www.soundjay.com/button/beep-07.mp3" autostart="false" ></audio>
  
  <script data-main="js/game/index" src="js/require.js"></script>
  
</body>
</html>
