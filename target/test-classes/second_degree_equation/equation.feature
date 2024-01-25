Feature: Resolution d'equation second degree

  Scenario: Accès à la page de saisi des nombres
    Given J'accède au site "http://localhost:8080/second_degree_equation-1.0.0"
    Then Je devrais voir le formulaire "equation_form"


   Scenario Outline: Saisie des coefficients et résolution de l'équation
      Given J'accède au site "http://localhost:8080/second_degree_equation-1.0.0"
      When Je saisis "<a>" dans le champ "a"
      And Je saisis "<b>" dans le champ "b"
      And Je saisis "<c>" dans le champ "c"
      And Je clique sur le bouton
      Then je devrais etre redirigé sur la page "http://localhost:8080/second_degree_equation-1.0.0/api" avec les resultats "<resultat>"

    Examples:
          | a | b | c | resultat                                      |
          | 2 | 5 | 3 | Les racines du polynome sont x1 = -1, x2 = -1.5|
          | 1 | 1 | 1 | Pas de solutions reelles pour cette equation   |
          | 0 | 5 | 2 | Les racines du polynome sont x = -0.4          |
          | 4 | 0 | 0 | Les racines du polynome sont x = 0.0           |
          | 3 | 2 | 1 | Les racines du polynome sont x1 = -0.333, x2 = -1.0 |