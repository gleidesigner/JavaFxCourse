package gleideveloper.com.br.javaavancado.xstream.main;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import gleideveloper.com.br.javaavancado.util.ConverteDate;
import gleideveloper.com.br.javaavancado.xstream.bean.Endereco;
import gleideveloper.com.br.javaavancado.xstream.bean.Fornecedor;
import gleideveloper.com.br.javaavancado.xstream.bean.Produto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gleides on 31/03/17.
 */
public class AppMain {
    public static void main(String [] args){
        Fornecedor fornecedor =  setFornecedor();

        XStream xStream = new XStream (new DomDriver());
        xStream.alias("Fornecedor", Fornecedor.class);
        xStream.alias("produto", Produto.class);
        xStream.registerConverter(new ConverteDate());
        String xml =  xStream.toXML(fornecedor);

        /*System.out.println(xml);*/
        createFile(xml);
        findFile();
    }

    public static void findFile(){
        FileReader fileReader = null;
        String path = "/home/gleides/Workspace/Maven/JavaFxCourse/src/main/resources/xml/";
        try {
            fileReader = new FileReader(path + "fileXStream.xml" );
            XStream xStream = new XStream (new DomDriver());
            xStream.alias("Fornecedor", Fornecedor.class);
            xStream.alias("produto", Produto.class);
            xStream.registerConverter(new ConverteDate());
            Fornecedor fornecedor = (Fornecedor) xStream.fromXML(fileReader);
            System.out.println(fornecedor.toString());

            for (Produto prod: fornecedor.getProdutos()){
                System.out.println("\n ----------------------------------");
                System.out.println("Codigo: " + prod.getCodigo());
                System.out.println("Nome: " + prod.getNome());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void createFile(String xml){
        File file = null;
        PrintWriter printWriter = null;
        String path = "/home/gleides/Workspace/Maven/JavaFxCourse/src/main/resources/xml/";
        try {
            file = new File(path + "fileXStream.xml");
            printWriter = new PrintWriter(file);
            printWriter.write(xml);
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            printWriter.close();
        }
    }

    private static Fornecedor setFornecedor(){
        Fornecedor forn = new Fornecedor();
        Endereco end =  new Endereco();
        Produto prod1 = new Produto();
        Produto prod2 = new Produto();
        List<Produto> prodList = new ArrayList<Produto>();

        forn.setNome("Informatica & CIA");
        forn.setCelular("92 3654-1241");
        forn.setTelefone("92 99243-2432");
        forn.setCnpj("23423452345235");
        forn.setEmail("gleidesigner@gmail.com");
        forn.setNomeFantasia("Informatica");
        forn.setInsest("4234346463");
        forn.setDataCadastro(new Date());

        end.setBairro("Centro");
        end.setRua("Av. Das Torres");
        end.setCidade("Manaus");
        end.setEstado("Amazonas");
        end.setCep("69085-288");

        prod1.setCodigo(1);
        prod1.setNome("Mouse");

        prod2.setCodigo(2);
        prod2.setNome("Notebook");

        prodList.add(prod1);
        prodList.add(prod2);

        forn.setEndereco(end);
        forn.setProdutos(prodList);

        return forn;
    }
}
