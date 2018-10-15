import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ShopPane extends GridPane {
    Button btn;

    // TODO: Implement btn_buyIdleMult and btn_buyClickMult.
    Button btn_buyIdleMult;
    Button btn_buyClickMult;

    ShopPane() {
        btn = new Button();
        btn.setText("heyooooooooooooooooo");
        btn.setId("PANE2_BTN");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Game_GUI.handleAction(event);
            }
        });

        this.setAlignment(Pos.TOP_LEFT);
        setVgap(10);
        setHgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        add(btn, 1, 0);

    }
}
