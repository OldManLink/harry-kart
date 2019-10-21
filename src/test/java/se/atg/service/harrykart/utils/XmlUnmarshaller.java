package se.atg.service.harrykart.utils;

import se.atg.service.harrykart.models.xjc.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

class XmlUnmarshaller<T> {

    T unmarshall(final String xml) {
        try {
            final Unmarshaller unmarshaller = JAXBContext.newInstance(ObjectFactory.class).createUnmarshaller();
            return asJAXBElement(unmarshaller.unmarshal(new StringReader(xml))).getValue();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    private JAXBElement<T> asJAXBElement(Object obj) {
        //noinspection unchecked
        return (JAXBElement<T>) obj;
    }
}
