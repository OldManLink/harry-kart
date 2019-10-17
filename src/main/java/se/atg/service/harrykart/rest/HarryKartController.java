package se.atg.service.harrykart.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.atg.service.harrykart.models.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.StringReader;

@RestController
@RequestMapping("/api")
public class HarryKartController {

    @RequestMapping(value = "/play",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,

            produces = MediaType.APPLICATION_JSON_VALUE)
    public String handleXML(@RequestBody String xml) throws JAXBException {
        HarryKartType harryKart;
        JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        harryKart = ((JAXBElement<HarryKartType>) jaxbContext.createUnmarshaller().unmarshal(new StringReader(xml))).getValue();

        System.out.println(harryKart.toString());
        return "{\"unmarshalled\": \"" + harryKart.toString() + "\"}";
    }
}
