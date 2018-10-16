//package;

/*

    Done. What is a MenuItem?
    What is a Button?
    How do forms work?
    Done. Different panels?
    Difference between types of panes?

    Guide index:
    https://docs.oracle.com/javase/8/javase-clienttechnologies.htm

    Creating forms:
    https://docs.oracle.com/javase/8/javafx/get-started-tutorial/form.htm

    Layouts:
    https://docs.oracle.com/javase/8/javafx/layout-tutorial/index.html

    Event handlers:
    https://docs.oracle.com/javase/8/javafx/events-tutorial/events.htm#JFXED117
    https://docs.oracle.com/javase/8/javafx/events-tutorial/handlers.htm#BABBHHCJ

    Creating a JavaFX app:
    https://docs.oracle.com/javase/8/javafx/get-started-tutorial/hello_world.htm

 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameGUI extends Application {
    static Game Game = new Game();

    static Scene scene;
    static AnimationTimer timer;

    public static int WIDTH = 300;
    public static int HEIGHT = 250;

    public static void main(String[] args) {
        launch(args);
    }

    private static void render() {
        scene.setRoot(Game.getCurrentPane());
    }

    public static void handleAction(ActionEvent e) {
        Button b = (Button) e.getSource();
        switch (b.getId()) {
            case "PANE1_BTN_HI":
                Game.pressedPane1BtnHi();
                break;
            case "PANE1_BTN_SWITCH":
                Game.pressedPane1BtnSwitch();
                break;
            case "PANE2_BTN":
                Game.pressedPane2Btn();
                break;
            case "PANE2_btn_buyClickMult":
                Game.pressedPane2Btn_buyClickMult();
                break;
            case "PANE2_btn_buyIdleMult":
                Game.pressedPane2Btn_buyIdleMult();
                break;
            default:
                break;
        }
    }

    @Override public void start(Stage primaryStage) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Game.update();
                render();
            }
        };

        scene = new Scene(Game.getCurrentPane(), WIDTH, HEIGHT);

        primaryStage.setTitle(":)");
        primaryStage.setScene(scene);
        primaryStage.show();

        timer.start();
    }
}
