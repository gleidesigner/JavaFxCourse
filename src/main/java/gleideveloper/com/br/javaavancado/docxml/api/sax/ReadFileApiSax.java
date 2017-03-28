package gleideveloper.com.br.javaavancado.docxml.api.sax;

import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by gleides.s on 28/03/2017.
 */
public class ReadFileApiSax {
    public static void main(String []args)throws Exception{
        String pathFile = ReadFileApiSax.class.getResource("/xml/usuarios.xml").getPath();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        InputSource source = new InputSource(pathFile);
        XMLHandler xmlHandler = new XMLHandler();
        parser.parse(source, xmlHandler);
    }
}

