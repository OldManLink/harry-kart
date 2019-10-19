package se.atg.service.harrykart.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

    @RequestMapping("/")
    public String home(Model model) {
        String xmlExample = null;
        try {
            //noinspection ConstantConditions
            xmlExample = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("input_0.xml").toURI())));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        model.addAttribute("xml_example", xmlExample);
        return "home";
    }
}
