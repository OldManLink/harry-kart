package se.atg.service.harrykart.utils;

import se.atg.service.harrykart.models.xjc.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

class XmlUnmarshaller<T> {

    T unmarshall(String xml) {
        Unmarshaller unmarshaller;
        T result = null;
        try {
            unmarshaller = JAXBContext.newInstance(ObjectFactory.class).createUnmarshaller();
            result = ((JAXBElement<T>)  unmarshaller.unmarshal(new StringReader(xml))).getValue();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result;
    }
}
