package golfx;/**
 * Created by gleides.s on 16/01/2017.
 */

import golfx.controller.Carrinho;
import golfx.model.ItensProperty;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VitrineApp extends Application {

    private AnchorPane pane;
    private TextField txPesquisa;
    private TableView<ItensProperty> tbVitrine;
    private TableColumn<ItensProperty,String> columnProduto;
    private TableColumn<ItensProperty,Double> columnPreco;
    private static ObservableList<ItensProperty> listItens = FXCollections.observableArrayList();
    private static Carrinho carrinho;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    private void initComponents(){
        pane = new AnchorPane();
        pane.setPrefSize(800,600);
        txPesquisa =  new TextField();
        tbVitrine = new TableView<ItensProperty>();
        tbVitrine.setPrefSize(780,550);
        columnProduto = new TableColumn<ItensProperty, String>();
        columnPreco = new TableColumn<ItensProperty, Double>();
        tbVitrine.getColumns().addAll(columnProduto,columnPreco);
        pane.getChildren().addAll(txPesquisa, tbVitrine);

        carrinho = new Carrinho();
    }
}
