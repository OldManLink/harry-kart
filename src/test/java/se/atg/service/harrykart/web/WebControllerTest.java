package se.atg.service.harrykart.web;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.testng.Assert;
import org.testng.annotations.Test;

import static se.atg.service.harrykart.utils.TestFileReader.readInputFileString;

public class WebControllerTest {

    @Test
    public void testHome() {
        WebController controller = new WebController();
        Model model = new ExtendedModelMap();
        Assert.assertEquals(controller.home(model), "home");
        final Object parameter = model.asMap().get("xml_example");
        Assert.assertEquals(parameter, readInputFileString(0));
    }
}