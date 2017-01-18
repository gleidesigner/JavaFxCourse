package golfx.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by gleides.s on 16/01/2017.
 */
public class ItensProperty {
    private SimpleStringProperty produto;
    private SimpleDoubleProperty preco;

    public ItensProperty(String produto, Double preco) {
        this.produto = new SimpleStringProperty(produto);
        this.preco = new SimpleDoubleProperty(preco);
    }

    public String getProduto() {
        return produto.get();
    }

    public SimpleStringProperty produtoProperty() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto.set(produto);
    }

    public double getPreco() {
        return preco.get();
    }

    public SimpleDoubleProperty precoProperty() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco.set(preco);
    }
}
