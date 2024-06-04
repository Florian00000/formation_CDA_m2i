import jdk.jshell.spi.ExecutionControl;
import org.example.exercice04.NotFoundException;
import org.example.exercice04.RechercheVille;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RechercheVilleTest {

    private RechercheVille rechercheVille;

    @Test public void WhenArgsLess2CharactersLong_ThenThrowsException ()  {
        //Arrange
        rechercheVille = new RechercheVille();

        //Assert
        Assert.assertThrows(NotFoundException.class, () -> rechercheVille.rechercher("a"));
    }

    @Test public void  WhenArgsMore2Characters_ThenRechercherBeTrue () {
        //Arrange
        rechercheVille = new RechercheVille();

        //Act
        List<String> res =  rechercheVille.rechercher("Va");
        List<String> excepted = List.of("Valence", "Vancouver");

        //Assert
        Assert.assertEquals(excepted, res);
    }
}
