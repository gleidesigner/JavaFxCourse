package gleideveloper.com.br.javaavancado.docjson;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * Created by gleides.s on 08/02/2017.
 */
public class MainJson {

    public static void main(String[] args){
        Gson gson = new Gson();
        Cliente cliente = new Cliente(1, "Joao da Silva", "joaosilva@gmail.com");

        System.out.println("************ Converte Objeto para Json ************");
        String strJson = gson.toJson(cliente);
        System.out.println(strJson);

        System.out.println("\n************ Converte Json para Objeto ************");
        Cliente clienteNew = gson.fromJson(strJson, Cliente.class);
        System.out.println("id: " + clienteNew.getId());
        System.out.println("nome: " + clienteNew.getNome());
        System.out.println("email: " + clienteNew.getEmail());

        System.out.println("\n************ Json Object ************");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("id", new JsonPrimitive(1));
        jsonObject.add("nome", new JsonPrimitive("Joao da Silva"));
        jsonObject.add("email", new JsonPrimitive("joao@gmail.com"));
        String jsonStr = gson.toJson(jsonObject);
        System.out.println(jsonStr);


    }
}
