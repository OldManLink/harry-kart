package se.atg.service.harrykart.utils;

import se.atg.service.harrykart.models.xjc.HarryKartType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestFileReader {

    public static String readInputFileString(final int fileNumber) {
        final String fileName = "input_" + fileNumber + ".xml";
        try {
            //noinspection ConstantConditions
            return new String(Files.readAllBytes(Paths.get(TestFileReader.class.getClassLoader().getResource(fileName).toURI())));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HarryKartType readInputFile(final int fileNumber) {
        final String xmlExample = readInputFileString(fileNumber);
        return new XmlUnmarshaller<HarryKartType>().unmarshall(xmlExample);
    }
}
