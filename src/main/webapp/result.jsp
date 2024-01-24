<!DOCTYPE html>
<html lang="fr">
  <head>
    <title>Equation second degree</title>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./styling/bootstrap.min.css" />
  </head>

  <body>
    <div class="container">
      <h3 class="my-3">
        Bonjour, vous cherchez a resoudre une equation du type : ax^2+bx+c=0
      </h3>

      <h1>Racines du polynome</h1>

      <% double[] roots = (double[])request.getAttribute("roots"); if
      (roots.length > 0) { %>
      <p>Les racines du polynôme sont :</p>
      <ul>
        <% for (double root : roots) { %>
        <li><%= root %></li>
        <% } %>
      </ul>
      <% } else { %>
      <p>Aucune racine trouvée.</p>
      <% } %>
    </div>
  </body>
</html>
