package gleideveloper.com.br.javaavancado.docxml.api.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;

/**
 * Created by gleidesilva on 27/03/17.
 */
public class WriteFiles {
    public static void main(String []args)throws Exception{

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        Element rootElem = doc.createElement("usuarios");
        doc.appendChild(rootElem);

        Element usuarioElem = doc.createElement("usuario");
        usuarioElem.setAttribute("id", "1");
        rootElem.appendChild(usuarioElem);

        Element nomeElem = doc.createElement("nome");
        Text nome = doc.createTextNode("Jose da Silva");
        nomeElem.appendChild(nome);
        usuarioElem.appendChild(nomeElem);

        Element idadeElem = doc.createElement("idade");
        Text idade = doc.createTextNode("20");
        idadeElem.appendChild(idade);
        usuarioElem.appendChild(idadeElem);

        //Transforma de uma origem para uma saida
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        //Cria um arquivo xml
        FileWriter fw = new FileWriter("usuarios.xml");
        StreamResult sr = new StreamResult(fw);
        DOMSource domSource = new DOMSource(doc);

        transformer.transform(domSource, sr);
    }
}
