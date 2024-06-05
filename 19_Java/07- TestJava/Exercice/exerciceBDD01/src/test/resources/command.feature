Feature: Création de compte et Connexion

  Scenario: Création de compte
    Given : Un utilisateur veut se créer un compte
    When :  L'utilisateur peut accéder à un formulaire d'inscription.
    And :  L'utilisateur doit fournir un email, un nom d'utilisateur, et un mot de passe.
    Then :   L'utilisateur reçoit une confirmation après l'inscription.
    And : Une erreure est renvoyé lors que la creation d'un compte avec un identifiant deja existant

  Scenario: Connexion à un compte
    Given :  En tant qu'utilisateur, je veux me connecter à mon compte pour accéder et passer des commandes.
    When : L'utilisateur peut accéder à un formulaire de connexion.
    And : L'utilisateur doit entrer son nom d'utilisateur et son mot de passe.
    Given : L'utilisateur voit un message d'erreur en cas de connexion échouée.
    And :  L'utilisateur est redirigé vers la page d'accueil après une connexion réussie.
