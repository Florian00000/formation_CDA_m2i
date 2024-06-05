import jdk.jshell.spi.ExecutionControl;
import org.example.exercice06Mock.Frame;
import org.example.exercice06Mock.IGenerateur;
import org.example.exercice06Mock.Roll;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class FrameTest {
    private Frame frame;

    private IGenerateur iGenerateur = Mockito.mock(IGenerateur.class);

    @Before
    public void setUp() {
        frame = new Frame(iGenerateur, false);
    }

    @Test public void Roll_SimpleFrame_FirstRoll_CheckScore() {
        //arrange
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(2);

        //act
        frame.makeRoll();

        //Assert
        Assert.assertEquals(2 , frame.getScore());
    }

    @Test public void Roll_SimpleFrame_SecondRoll_CheckScore(){
        //arrange
        frame.setScore(2);
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(2);
        frame.getRolls().add(new Roll(2));

        //act
        frame.makeRoll();

        //Assert
        Assert.assertEquals(4 , frame.getScore());
    }

    @Test public void Roll_SimpleFrame_SecondRoll_FirstRollStrick_ReturnFalse(){
        //arrange
        frame.setScore(10);
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(2);
        frame.getRolls().add(new Roll(10));

        //act
        frame.makeRoll();
        boolean result = frame.makeRoll();

        //Assert
        Assert.assertFalse(result);
    }

    @Test public void Roll_SimpleFrame_MoreRolls_ReturnFalse(){
        //arrange
        frame.setScore(5);
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(2);
        frame.getRolls().add(new Roll(5));

        //act
        frame.makeRoll();
        boolean result = frame.makeRoll();

        //Assert
        Assert.assertFalse(result);
    }

}
