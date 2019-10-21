package se.atg.service.harrykart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class WebController extends WebMvcConfigurerAdapter {
    private final static Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("/")
    public String home(final Model model) {
        try {
            //noinspection ConstantConditions
            final String xmlExample = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("input_0.xml").toURI())));
            model.addAttribute("xml_example", xmlExample);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        logger.info("Serving up home page \"Submit Harry Kart\"");
        return "home";
    }
}
