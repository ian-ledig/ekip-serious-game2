package t4.page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import t4.component.Bar;
import t4.util.ActivityInfo;

public class PageResult extends Page{

    private final int health;
    private final int happiness;
    private final int money;

    public PageResult(ActivityInfo activityInfo){
        this.health = activityInfo.getHealth();
        this.happiness = activityInfo.getHappiness();
        this.money = activityInfo.getMoney();

        draw();
    }

    @Override
    public void draw() {
        HBox hbxBars = new HBox();
        hbxBars.setAlignment(Pos.CENTER);
        hbxBars.setPadding(new Insets(300));
        hbxBars.setSpacing(10);

        Bar barHealth = new Bar(0, 0, Color.RED, Color.BLACK, health);
        Bar barHappiness = new Bar(0, 0, Color.YELLOW, Color.BLACK, happiness);
        Bar barMoney = new Bar(0, 0, Color.GREEN, Color.BLACK, money);

        Text txtInfo = new Text();

        String text = "";
        if(health > happiness && health > money)
            text += "Vous êtes en grande forme, peut-être même trop ; il faut penser à dépenser l'énergie que vous avez.";


        hbxBars.getChildren().addAll(barHealth, barHappiness, barMoney);

        add(hbxBars);
    }
}
