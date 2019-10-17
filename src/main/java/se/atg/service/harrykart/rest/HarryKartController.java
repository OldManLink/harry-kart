package se.atg.service.harrykart.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HarryKartController {

    @RequestMapping(value = "/play", method = RequestMethod.POST, consumes = "application/xml", produces = "application/json")
    public String playHarryKart() {
        return "{ \"message\": \"Don't know how to play yet\" }";
    }

}
