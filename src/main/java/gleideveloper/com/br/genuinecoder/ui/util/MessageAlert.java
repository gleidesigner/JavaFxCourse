package gleideveloper.com.br.genuinecoder.ui.util;

import javafx.scene.control.Alert;

/**
 * Created by Gleides on 01/03/2017.
 */
public abstract class MessageAlert {
    protected void getMsgAlert(Alert.AlertType type, String contentText) {
        Alert alert = new Alert(type);
        //alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
