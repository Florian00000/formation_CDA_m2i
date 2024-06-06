Feature: Création de compte et Connexion

  Scenario: Création de compte
    Given : Un utilisateur veut se créer un compte
    When :  L utilisateur peut acceder à un formulaire d inscription.
    And :  L utilisateur doit fournir un email, un nom d utilisateur, et un mot de passe.
    Then :   L utilisateur reçoit une confirmation après l inscription.
    And : Une erreure est renvoye lors que la creation d'un compte avec un identifiant deja existant

  Scenario: Connexion à un compte
    Given :  En tant qu'utilisateur, je veux me connecter à mon compte pour acceder et passer des commandes.
    When : L utilisateur peut accéder à un formulaire de connexion.
    And : L utilisateur doit entrer son nom d utilisateur et son mot de passe.
    Then : L utilisateur voit un message d'erreur en cas de connexion echouee.
    And :  L utilisateur est redirigé vers la page d'accueil après une connexion reussie.
