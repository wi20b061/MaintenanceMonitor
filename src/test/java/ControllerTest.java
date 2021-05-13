import slm.controller.Controller;
import slm.controller.Website;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerTest {
    @Test
    public void test_Given_ApplicationStarted_When_URLSent_Then_HTMLPageIsDisplayed() {
        //arrange
        Controller controller = new Controller();

        //act
        String actual = controller.returnHTML();

        //assert
        String expected = readHTML("MaintenanceMonitor.html");
        Assertions.assertEquals(expected, actual);

    }

    private String readHTML(String file) {
        String content = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {
                content += str;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Test
    public void test_Given_ApplicationStarted_When_WebsiteReloads_Then_ExpectedParametersGetReturned() {
        //arrange
        Controller controller = new Controller();

        //act
        Website.setMessage("test");
        Website.setStyle("testStyle");
        String actual = controller.reload();

        //assert
        String expected = createJSON();
        Assertions.assertEquals(expected, actual);

    }

    private String createJSON() {
        return "{\"message\": \"test\", \"style\": \"testStyle\", \"time\": \"" + getTime() + "\"}";
    }

    private String getTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    @Test
    public void test_Given_WebsiteShowsCurrentInformation_When_MessageChangedOnServer_Then_WebsiteChangesMessageToNewMessage() {
        //arrange
        Controller controller = new Controller();

        //act
        controller.changeMessage("test");
        String actual = Website.getMessage();

        //assert
        Assertions.assertEquals("test", actual);
    }

    @Test
    public void test_Given_WebsiteShowsCurrentInformation_When_StyleChangedOnServer_Then_WebsiteChangesStyleToRedStyle() {
        //arrange
        Controller controller = new Controller();

        //act
        controller.changeMessage("test");
        String actual = Website.getStyle();

        //assert
        Assertions.assertEquals("background: linear-gradient(90deg, rgb(255, 255, 255) 0%, rgba(245, 9, 9, 0.5) 50%, rgb(255, 255, 255) 100%)", actual);
    }

    @Test
    public void test_Given_WebsiteShowsCurrentInformation_When_Reset_Then_WebsiteChangesMessageToNoInformation() {
        //arrange
        Controller controller = new Controller();

        //act
        controller.reset();
        String actual = Website.getMessage();

        //assert
        Assertions.assertEquals("no information", actual);
    }

    @Test
    public void test_Given_WebsiteShowsCurrentInformation_When_Reset_Then_WebsiteChangesStyleToWhiteStyle() {
        //arrange
        Controller controller = new Controller();

        //act
        controller.reset();
        String actual = Website.getStyle();

        //assert
        Assertions.assertEquals("", actual);
    }

    @Test
    public void test_Given_WebsiteShowsCurrentInformation_When_StatusChangedToOk_Then_WebsiteChangesMessageToEmpty() {
        //arrange
        Controller controller = new Controller();

        //act
        controller.setToOk();
        String actual = Website.getMessage();

        //assert
        Assertions.assertEquals("", actual);
    }

    @Test
    public void test_Given_WebsiteShowsCurrentInformation_When_StatusChangedToOk_Then_WebsiteChangesStyleToGreenStyle() {
        //arrange
        Controller controller = new Controller();

        //act
        controller.setToOk();
        String actual = Website.getStyle();

        //assert
        Assertions.assertEquals("background: linear-gradient(90deg, rgb(255, 255, 255) 0%, rgba(9, 245, 68, 0.5) 50%, rgb(255, 255, 255) 100%)", actual);
    }
}
