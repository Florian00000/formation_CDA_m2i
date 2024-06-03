import org.example.exerciceMock.DiceScore;
import org.example.exerciceMock.Ide;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DiceScoreTest {

    private DiceScore diceScore;
    private Ide ide = Mockito.mock(Ide.class);


    @Test public void When2DeHaveSameValues_ThenGetScoreReturnTrue (){
        //arrange
        diceScore = new DiceScore(ide);
        Mockito.when(ide.getRoll()).thenReturn(2);

        //act
        int score = diceScore.getScore();
        int expected = 2 * 2 + 10;

        //assert
        Assert.assertEquals(expected, score);

    }

    @Test public void When2DeWithValue6_ThenGetScoreReturnTrue (){
        //arrange
        diceScore = new DiceScore(ide);
        Mockito.when(ide.getRoll()).thenReturn(6);

        //act
        int score = diceScore.getScore();
        int expected = 30;

        //assert
        Assert.assertEquals(expected, score);
    }

    @Test public void When2DeWithDifferentValues_ThenGetScoreReturnMax (){
        //arrange
        diceScore = new DiceScore(ide);
        Mockito.when(ide.getRoll()).thenReturn(2).thenReturn(6);

        //act
        int score = diceScore.getScore();

        //assert
        Assert.assertEquals(6, score);
    }
}
