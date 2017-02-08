package gleideveloper.com.br.materialdesign;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gleides on 07/02/2017.
 */
public class FXMLControllerBook implements Initializable{

    @FXML
    private JFXTextField title;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField author;
    @FXML
    private JFXTextField publisher;
    @FXML
    private JFXButton save;
    @FXML
    private JFXButton cancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addBook(ActionEvent actionEvent) {
    }

    public void cancelBook(ActionEvent actionEvent) {

    }
}
