import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MainPane extends GridPane {
    Button btn_hi;
    Button btn_switch;
    Label lbl_pts;
    Label lbl_idleMult;
    Label lbl_clickMult;

    MainPane(int points, int idleMultiplier, int clickMultiplier) {
        btn_hi = new Button();
        btn_hi.setText("Say 'Hi!'");
        btn_hi.setId("PANE1_BTN_HI");

        btn_hi.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Game_GUI.handleAction(event);
            }
        });

        btn_switch = new Button();
        btn_switch.setText("Hm?");
        btn_switch.setId("PANE1_BTN_SWITCH");

        btn_switch.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Game_GUI.handleAction(event);
            }
        });

        lbl_pts = new Label("Points: " + String.valueOf(points));
        lbl_idleMult = new Label("Idle multiplier: " + String.valueOf(idleMultiplier));
        lbl_clickMult = new Label("Click multiplier: " + String.valueOf(clickMultiplier));



        this.setAlignment(Pos.TOP_LEFT);
        this.setVgap(10);
        this.setHgap(10);
        this.setPadding(new Insets(25, 25, 25, 25));
        this.add(btn_hi, 1, 0);
        this.add(btn_switch, 1, 1);
        this.add(lbl_pts, 0, 0);
        this.add(lbl_idleMult, 0, 1);
        this.add(lbl_clickMult, 0, 2);

    }

    public void setPointsLabel(int points, int idleMult, int clickMult) {
        lbl_pts.setText("Points: " + String.valueOf(points));
        lbl_idleMult.setText("Idle multiplier: " + String.valueOf(idleMult));
        lbl_clickMult.setText("Click multiplier: " + String.valueOf(clickMult));
    }
}
