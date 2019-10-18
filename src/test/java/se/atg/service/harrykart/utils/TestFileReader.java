package se.atg.service.harrykart.utils;

import se.atg.service.harrykart.models.xjc.HarryKartType;
import se.atg.service.harrykart.models.xjc.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Objects;

public class TestFileReader {

    public static HarryKartType readInputFile(int fileNumber) {
        HarryKartType harryKart = null;
        String fileName = "input_" + fileNumber + ".xml";
        File xml = new File(Objects.requireNonNull(TestFileReader.class.getClassLoader().getResource(fileName)).getFile());

        try {
            Unmarshaller unmarshaller = JAXBContext.newInstance(ObjectFactory.class).createUnmarshaller();
            harryKart = ((JAXBElement<HarryKartType>)  unmarshaller.unmarshal(xml)).getValue();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        assert harryKart != null;
        return harryKart;
    }
}
