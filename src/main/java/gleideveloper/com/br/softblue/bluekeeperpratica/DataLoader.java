package gleideveloper.com.br.softblue.bluekeeperpratica;

import gleideveloper.com.br.softblue.bluekeeperpratica.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gleidesilva on 17/01/17.
 */
public class DataLoader {
    public static List<SenhaServico> load(){
        List<SenhaServico> list = new ArrayList<>();

        list.add(new SenhaServico("Amazon", "abc@amazon.com"));
        list.add(new SenhaServico("Google", "edf@gmail.com"));

        return list;
    }
}
