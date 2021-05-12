import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void test_Given_SeeAWelcomeMessage_When_WeGetTheMessage_Then_TheMessageShouldBeWelcomeAtMaintenanceMonitor(){
        //arrange

        //act
        String actual = Main.message();

        //assert
        Assertions.assertEquals("Welcome at MaintanceMonitor", actual);
    }


}
