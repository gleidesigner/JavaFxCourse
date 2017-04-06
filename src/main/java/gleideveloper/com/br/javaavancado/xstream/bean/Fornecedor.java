
package gleideveloper.com.br.javaavancado.xstream.bean;

import java.util.Date;
import java.util.List;

/**
 * Created by gleides on 31/03/17.
 */
public class Fornecedor {
    private String nome;
    private String nomeFantasia;
    private String cnpj;
    private String insest;
    private String email;
    private String telefone;
    private String celular;
    private Date dataCadastro;
    private Endereco endereco;
    private List<Produto> produtos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInsest() {
        return insest;
    }

    public void setInsest(String insest) {
        this.insest = insest;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Nome " + getNome() + "\nCNPJ: " + getCnpj() + "\nData: " + getDataCadastro();
    }
}
