package gleideveloper.com.br.javaavancado.docxml.api.sax;

import org.xml.sax.InputSource;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by gleides.s on 28/03/2017.
 */
public class ReadValidateFileApiSax {
    public static void main(String []args)throws Exception{
        String pathFile = ReadValidateFileApiSax.class.getResource("/xml/usuarios.xml").getPath();
        String url = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        //Adiciona a Validacao no xml usando o arquivo .xsd
        factory.setValidating(true);
        factory.setNamespaceAware(true);

        SAXParser parser = factory.newSAXParser();
        parser.setProperty(url, XMLConstants.W3C_XML_SCHEMA_NS_URI);

        InputSource source = new InputSource(pathFile);
        XMLHandler xmlHandler = new XMLHandler();
        parser.parse(source, xmlHandler);
    }
}

