package gleideveloper.com.br.genuinecoder.ui.member;

import com.jfoenix.controls.JFXTextField;
import gleideveloper.com.br.genuinecoder.database.DatabaseHandler;
import gleideveloper.com.br.genuinecoder.ui.util.MessageAlert;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Gleides on 01/03/2017.
 */
public class MemberAddController extends MessageAlert implements Initializable {
    public JFXTextField id;
    public JFXTextField name;
    public JFXTextField mobile;
    public JFXTextField email;
    public AnchorPane rootPaneMember;
    private Member member;
    DatabaseHandler handler;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handler = DatabaseHandler.getInstance();
    }

    public void addMember(ActionEvent actionEvent) {
        member = new Member();
        member.setId(id.getText());
        member.setName(name.getText());
        member.setMobile(mobile.getText());
        member.setEmail(email.getText());

        Boolean flag = member.getId().isEmpty()||member.getEmail().isEmpty();
        if(flag){
            //Metodo Alert herdado da classe abastrata MessageAlert
            getMsgAlert(Alert.AlertType.ERROR, "Please Enter the fields");
            return;
        }

        String sql = "INSERT INTO MEMBER VALUES(" +
                "'" + member.getId() + "'," +
                "'" + member.getName() + "'," +
                "'" + member.getMobile() + "'," +
                "'" + member.getEmail() + "'" +
                ")";

        System.out.println(sql);

        if(handler.execAction(sql)){
            //Metodo Alert herdado da classe abastrata MessageAlert
            getMsgAlert(Alert.AlertType.INFORMATION, "Save whit SUCCESS");
        }
    }

    public void cancel(ActionEvent actionEvent) {
        Stage stage = (Stage) rootPaneMember.getScene().getWindow();
        stage.close();
    }
}
