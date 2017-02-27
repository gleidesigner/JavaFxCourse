package gleideveloper.com.br.javafxmvc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gleides on 26/01/2017.
 */
public class FXMLVBoxCadastroClienteMain implements Initializable{
    public Button btnHello;
    @FXML
    private  MenuItem menuItemProcessoVenda;
    @FXML
    private  MenuItem menuItemGraficoVendaMes;
    @FXML
    private  MenuItem menuItemRelatorioQtdeProdutoEstoque;
    @FXML
    private MenuItem menuItemCadastroCliente;
    @FXML
    private MenuItem menuItemCadastroCategoria;
    @FXML
    private  AnchorPane anchoPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void handleMenuItemCadastrosClientes() throws IOException {
        AnchorPane anchorPaneChild = FXMLLoader.load(getClass().getResource("/fxml/javafxmvc/FXMLAnchorPaneCadastroCliente.fxml"));
        anchoPane.getChildren().setAll(anchorPaneChild);
    }

    public void btnHelloWord(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hello world");
        alert.setHeaderText("world");
        alert.setContentText("Ola mundo!");
        alert.showAndWait();
    }
}
