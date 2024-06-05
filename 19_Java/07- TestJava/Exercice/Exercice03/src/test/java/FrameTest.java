import jdk.jshell.spi.ExecutionControl;
import org.example.exercice06Mock.Frame;
import org.example.exercice06Mock.IGenerateur;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FrameTest {
    private Frame frame;

    private IGenerateur iGenerateur = Mockito.mock(IGenerateur.class);

    @Test public void Roll_SimpleFrame_FirstRoll_CheckScore() throws ExecutionControl.NotImplementedException {
        //arrange
        frame = new Frame(iGenerateur, false);
        Mockito.when(iGenerateur.randomPin(10)).thenReturn(2);

        //act
        frame.makeRoll();

        //Assert
        Assert.assertEquals(2 , frame.getScore());
    }
}
