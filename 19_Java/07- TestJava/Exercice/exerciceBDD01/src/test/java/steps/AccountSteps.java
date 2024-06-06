package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.entities.Account;
import org.example.error.AccountAlreadyExist;
import org.junit.Assert;

public class AccountSteps {
    Account account;

    @Given(": Un utilisateur veut se créer un compte")
    @When(":  L utilisateur peut acceder à un formulaire d inscription.")
    @And(":  L utilisateur doit fournir un email, un nom d utilisateur, et un mot de passe.")
    public void lUtilisateurDoitFournirUnEmailUnNomDUtilisateurEtUnMotDePasse() {
         account = new Account("mail", "Abidbol", "MondeDeMerde");
    }

    @Then(":   L utilisateur reçoit une confirmation après l inscription.")
    public void lUtilisateurRecoitUneConfirmationApresLInscription() {
        boolean response = Account.verifyAccount(account);
        Assert.assertTrue(response);
    }
    @And(": Une erreure est renvoye lors que la creation d'un compte avec un identifiant deja existant")
    public void lUtilisateurRecoitUneErreureExistant() {
        try {
            Account.verifyAccount(account);
        }catch (AccountAlreadyExist e){
            Assert.assertTrue(!e.getMessage().isEmpty());
        }
    }

    @Given(":  En tant qu'utilisateur, je veux me connecter à mon compte pour acceder et passer des commandes.")
    @When(": L utilisateur peut accéder à un formulaire de connexion.")
    @And(": L utilisateur doit entrer son nom d utilisateur et son mot de passe.")
    @Then(": L utilisateur voit un message d'erreur en cas de connexion echouee.")
    public void lUtilisateurVoitUnMessageDErreurEnCasDeConnexionEchouee() {
        try {
            Account.login("mauvaisUtilisateur", "test");
        }catch (AccountAlreadyExist e){
            Assert.assertTrue(!e.getMessage().isEmpty());
        }
    }

    @And(":  L utilisateur est redirigé vers la page d'accueil après une connexion reussie.")
    public void lUtilisateurEstRedirigeVersLaPageDAccueilApresUneConnexionReussie() {
        boolean response = Account.login("Abidbol", "MondeDeMerde");
        Assert.assertTrue(response);
    }
}
