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
import se.atg.service.harrykart.models.xjc.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

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
    public String handleXML(@RequestBody String xml) throws JAXBException {
        HarryKartType harryKart;
        Unmarshaller unmarshaller = JAXBContext.newInstance(ObjectFactory.class).createUnmarshaller();
        harryKart = ((JAXBElement<HarryKartType>) unmarshaller.unmarshal(new StringReader(xml))).getValue();

        return new JSONObject(harryKartService.computeResult(harryKart)).toString();
    }
}
