// Продемонстрировать применение экранных кнопок
// и обработку событий в JavaFX
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.* ;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx . event .*;
import javafx . geometry .*;
import javafx.scene.control.Alert.*;

public class JavaFXEventDemo extends Application {
    Label response;

    public static void main(String[] args) {
        // запустить JаvаFХ-приложение , вызвав метод launch ()
        launch(args);
    }

    // переопределить метод start ()
    public void start(Stage myStage) {


        // присвоить заголовок подмосткам
        myStage.setTitle(" Demonstrate JavaFX Buttons and Events .");
        // Продемонстрировать кнопки и события в JavaFX
        // Исполь зовать панель поточной компоновки FlovPane
        // в качестве корневого узла . Установить промежутки
        // между элементами управления по горизонтали и
        // по вертикали равными 10
        FlowPane rootNode = new FlowPane(10, 10);
        // выровнять элементы управления по центру сцены
        rootNode.setAlignment(Pos.CENTER);


        BorderPane root=new BorderPane();



        // создать сцену
        Scene myScene = new Scene(rootNode, 300, 100);

        // установить сцену на подмостках
        myStage.setScene(myScene);
        // создать метку
        response = new Label(" Нажмите кнопку"); // Нажать кнопку
        // создать две экранные кнопки
        Button btnAlpha = new Button("1 ");
        Button btnВеtа = new Button(" 2 ");

        // обработать события действия от кнопки Alpha
        btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ае) {
                response.setText("1 was pressed.");
                // Нажата кнопка Alpha
            }
        });
        // обработать события действия от кнопки Beta
        btnВеtа.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ае) {
                btnВеtа.setOnMouseEntered(event -> {
                response.setText("2 was pressed.");

                double a1 = btnВеtа.getMaxWidth();
                double a2 = btnВеtа.getMaxHeight();
                double b1 = (myScene.getWidth() - btnВеtа.getMaxWidth());
                double b2 = (myScene.getHeight() - btnВеtа.getMaxHeight());
                double x = a1 + (int) (Math.random() * b1);
                double y = a2 + (int) (Math.random() * b2);
                btnВеtа.setLayoutX(x);
                btnВеtа.setLayoutY(y);});
                // Нажата кнопка Beta
            }
        });
        Pane pane = new Pane();
        // ввести метку и кнопки в граф сцены
        pane.getChildren().addAll(btnВеtа);
        rootNode.getChildren().addAll(btnAlpha, pane, response);
        // показать подмостки и сцену на них
        myStage.show();
    }
}
