package se.atg.service.harrykart.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.atg.service.harrykart.HarryKartService;
import se.atg.service.harrykart.models.RaceResult;
import se.atg.service.harrykart.models.xjc.HarryKartType;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api")
public class HarryKartController {
    private final static Logger logger = LoggerFactory.getLogger(HarryKartController.class);

    final private HarryKartService harryKartService;
    @Autowired
    public HarryKartController(final HarryKartService harryKartService) {
        this.harryKartService = harryKartService;
    }

    @RequestMapping(value = "/play", method = POST, consumes = APPLICATION_XML_VALUE, produces = APPLICATION_JSON_VALUE)
    public RaceResult handleXML(@RequestBody final HarryKartType harryKart) {
        logger.info("Handling request to /api/play <HarryKartType>");
        return harryKartService.computeResult(harryKart);
    }
}
