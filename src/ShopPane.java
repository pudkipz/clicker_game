import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class ShopPane extends GridPane {
    Button btn;
    Label lbl_pts;

    // TODO: Implement btn_buyIdleMult and btn_buyClickMult.
    Button btn_buyIdleMult;
    Button btn_buyClickMult;

    ShopPane(int clickMultCost, int idleMultCost, int points) {
        btn = new Button();
        btn.setText("heyooooooooooooooooo");
        btn.setId("PANE2_BTN");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Game_GUI.handleAction(event);
            }
        });

        btn_buyClickMult = new Button();
        btn_buyClickMult.setText("Increase click multiplier (" + clickMultCost + ")");
        btn_buyClickMult.setId("PANE2_btn_buyClickMult");
        btn_buyClickMult.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Game_GUI.handleAction(event);
            }
        });

        btn_buyIdleMult = new Button();
        btn_buyIdleMult.setText("Increase idle multiplier (" + idleMultCost + ")");
        btn_buyIdleMult.setId("PANE2_btn_buyIdleMult");
        btn_buyIdleMult.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Game_GUI.handleAction(event);
            }
        });

        lbl_pts = new Label("Points: " + String.valueOf(points));

        this.setAlignment(Pos.TOP_LEFT);
        setVgap(10);
        setHgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        add(lbl_pts, 0, 0);
        add(btn, 1, 0);
        add(btn_buyClickMult, 1, 1);
        add(btn_buyIdleMult, 1, 2);

    }

    public void setPointsLabel(int points) {
        lbl_pts.setText("Points: " + String.valueOf(points));
    }

    public void setButtonTexts(int cMult, int iMult) {
        btn_buyClickMult.setText("Increase click multiplier (" + cMult + ")");
        btn_buyIdleMult.setText("Increase idle multiplier (" + iMult + ")");
    }
}
