package gleideveloper.com.br.javafxmvc.controller;

import gleideveloper.com.br.javafxmvc.model.domain.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gleides on 07/02/2017.
 */
public class FXMLAnchorPaneCadastroClienteDialogController implements Initializable{
    @FXML
    private Label lblClienteNome;
    @FXML
    private Label lblClienteCPF;
    @FXML
    private Label lblClienteTelefone;
    @FXML
    private TextField txtFieldClienteNome;
    @FXML
    private TextField txtFieldClienteCPF;
    @FXML
    private TextField txtFieldClienteTelefone;
    @FXML
    private Button btnConfirma;
    @FXML
    private Button btnCancelar;

    private Stage dialogStage;
    private Boolean isClickedBtnConfirma = false;
    private Cliente cliente;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public Boolean getClickedBtnConfirma() {
        return isClickedBtnConfirma;
    }

    public void setClickedBtnConfirma(Boolean clickedBtnConfirma) {
        isClickedBtnConfirma = clickedBtnConfirma;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void handleBtnConfirmar() {
        cliente.setNome(txtFieldClienteNome.getText());
        cliente.setCpf(txtFieldClienteCPF.getText());
        cliente.setTelefone(txtFieldClienteTelefone.getText());

        isClickedBtnConfirma = true;
        dialogStage.close();
    }

    public void handleBtnCancelar() {
        dialogStage.close();
    }
}
