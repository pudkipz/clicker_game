import javafx.scene.layout.GridPane;

public class Game {
    private static long points = 0;
    private static long idleMultiplier = 1;
    private static long clickMultiplier = 2;
    private static long idleMultCost = 10;
    private static long clickMultCost = 10;

    private static boolean clickPoints = false;

    private static long delay = 200_000_000;       // 100_000_000 == tenth sec
    private static long previousTime = System.nanoTime();

    private MainPane mainPane = new MainPane(points, idleMultiplier, clickMultiplier);
    private ShopPane shopPane = new ShopPane(clickMultCost, idleMultCost, points);

    private GridPane currentPane = mainPane;

    public void pressedPane1BtnHi() {
        clickPoints = true;
    }

    public void pressedPane1BtnSwitch() {
        currentPane = shopPane;
    }

    public void pressedPane2Btn_buyClickMult() {
        if (points >= clickMultCost) {
            clickMultiplier *= 2;
            points -= clickMultCost;
            clickMultCost = (25 * clickMultCost * clickMultCost) / 100;
        }
    }

    public void pressedPane2Btn_buyIdleMult() {
        if (points >= idleMultCost) {
            idleMultiplier += 3;
            points -= idleMultCost;
            idleMultCost = (11 * idleMultCost * idleMultCost) / 100;
        }
    }

    public void pressedPane2Btn() {
        clickMultiplier = clickMultiplier*2;
        currentPane = mainPane;
    }

    private void updatePane1() {
        mainPane.setPointsLabel(points, idleMultiplier, clickMultiplier);
    }

    private void updatePane2() {
        shopPane.setPointsLabel(points);
        shopPane.setButtonTexts(clickMultCost, idleMultCost);
    }

    public void update() {
        if (System.nanoTime() - previousTime < delay) {
            return;
        }

        previousTime = System.nanoTime();

        points += idleMultiplier;
        if (clickPoints) {
            points += clickMultiplier;
            clickPoints = false;
        }

        updatePane1();
        updatePane2();
    }

    public GridPane getCurrentPane() {
        return currentPane;
    }

    public long getPoints() {
        return this.points;
    }

    public static void setIdleMultiplier(int idleMultiplier) {
        Game.idleMultiplier = idleMultiplier;
    }

    public static void setClickMultiplier(int clickMultiplier) {
        Game.clickMultiplier = clickMultiplier;
    }

    public static long getIdleMultiplier() {
        return idleMultiplier;
    }

    public static long getClickMultiplier() {
        return clickMultiplier;
    }
}