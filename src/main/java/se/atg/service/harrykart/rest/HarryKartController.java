package se.atg.service.harrykart.rest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.atg.service.harrykart.HarryKartService;
import se.atg.service.harrykart.models.xjc.HarryKartType;

@RestController
@RequestMapping("/api")
public class HarryKartController {

    final private HarryKartService harryKartService;
    @Autowired
    public HarryKartController(HarryKartService harryKartService) {
        this.harryKartService = harryKartService;
    }

    @RequestMapping(value = "/play",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String handleXML(@RequestBody HarryKartType harryKart) {

        return new JSONObject(harryKartService.computeResult(harryKart)).toString();
    }
}
