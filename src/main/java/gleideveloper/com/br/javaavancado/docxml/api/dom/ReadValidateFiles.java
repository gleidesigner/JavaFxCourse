package gleideveloper.com.br.javaavancado.docxml.api.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

/**
 * Created by gleides.s on 15/03/2017.
 */
public class ReadValidateFiles {
    public static void main(String []args)throws Exception{
        String pathFile = ReadValidateFiles.class.getResource("/xml/usuarios.xml").getPath();

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema();
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(pathFile));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(pathFile);

        Element element = doc.getDocumentElement();
        NodeList userNodeList = element.getElementsByTagName("usuario");

        for (int i = 0; i < userNodeList.getLength();i++){
            Element tagUser = (Element) userNodeList.item(i);
            String id = tagUser.getAttribute("id");

            NodeList nomeNodeList = tagUser.getElementsByTagName("nome");
            String nome = nomeNodeList.item(0).getTextContent();

            NodeList idadeNodeList = tagUser.getElementsByTagName("idade");
            String idade = idadeNodeList.item(0).getTextContent();

            NodeList emailNodeList = tagUser.getElementsByTagName("email");
            Element tagEmail = (Element) emailNodeList.item(0);
            String email = tagEmail.getTextContent();

            System.out.println(id + ", " + nome+ ", " + idade+ ", " + email);
        }
    }
}

