package gleideveloper.com.br.softblue.bluekeeperpratica.controller;

import gleideveloper.com.br.softblue.bluekeeperpratica.DataLoader;
import gleideveloper.com.br.softblue.bluekeeperpratica.model.SenhaServico;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

/**
 * Created by gleidesilva on 17/01/17.
 */
public class Controller {
    @FXML
    private TextField txtServico;
    @FXML
    private TextField txtLogin;
    @FXML
    private TableView<SenhaServico> table;

    @FXML
    private void initialize(){
        System.out.println("Controller inicializado");

        List<SenhaServico> list = DataLoader.load();

        table.setItems(FXCollections.observableArrayList(list));

        table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SenhaServico>() {
            @Override
            public void changed(ObservableValue<? extends SenhaServico> observable, SenhaServico oldValue, SenhaServico newValue) {
                txtServico.textProperty().bindBidirectional(newValue.siteProperty());
                txtLogin.textProperty().bindBidirectional(newValue.loginProperty());
            }
        });
    }

    @FXML
    private void onExit() {
        Platform.exit();
    }

    @FXML
    private void onSearch() {

    }
}
