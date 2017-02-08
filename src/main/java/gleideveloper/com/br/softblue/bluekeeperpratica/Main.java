package gleideveloper.com.br.softblue.bluekeeperpratica;

/**
 * Created by gleidesilva on 17/01/17.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = FXMLLoader.load(getClass().getResource("../../../../../../resources/fxml/softblue/LayoutPratica.fxml"));
        //test merger feito no P4
        Scene scene = new Scene(root, 850,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("templatemvc");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
