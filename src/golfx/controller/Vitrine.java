package golfx.controller;

import golfx.model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gleides.s on 16/01/2017.
 */
public class Vitrine {

    private static List<Produto> produtos = new ArrayList<Produto>();

    public void addProdutos(Produto... produto){
        for (Produto p : produto) {
            produtos.add(p);
        }
    }

    public List<Produto> getProdutos(){
        return produtos;
    }
}
