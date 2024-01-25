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
      <h1>Resultats de l'equation</h1>

      <div id="roots">
        <% double[] roots = (double[])request.getAttribute("roots"); if (roots
        != null && roots.length > 0) { %>
        <p>
          Les racines du polynome sont <% for (int i = 0; i < roots.length; i++)
          { %> <%= "x" + (i + 1) + " = " + roots[i] %>, <% } %>
        </p>
        <% } else { %>
        <p>Pas de solutions reelles pour cette equation</p>
        <% } %>
      </div>
    </div>
  </body>
</html>
