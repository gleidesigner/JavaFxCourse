package gleideveloper.com.br.softblue.bluekeeper.application;

import java.util.ArrayList;
import java.util.List;

import gleideveloper.com.br.softblue.bluekeeper.model.SenhaServico;

public class DataLoader {

	private static final List<SenhaServico> itens;
	
	static {
		itens = new ArrayList<>();
		
		SenhaServico senhaServico = null;
		
		senhaServico = new SenhaServico();
		senhaServico.setId(1);
		senhaServico.setServico("GMail");
		senhaServico.setLogin("abc@gmail.com");
		senhaServico.setSenha("1234");
		senhaServico.setObservacoes("E-mail pessoal");
		itens.add(senhaServico);
		
		senhaServico = new SenhaServico();
		senhaServico.setId(2);
		senhaServico.setServico("Hotmail");
		senhaServico.setLogin("abc@hotmail.com");
		senhaServico.setSenha("xpto");
		senhaServico.setObservacoes("E-mail secund�rio");
		itens.add(senhaServico);
	}
	
	public static List<SenhaServico> getItens() {
		return itens;
	}
}
