package t4.page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import t4.Main;
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
        VBox vbxResult = new VBox();
        vbxResult.setAlignment(Pos.CENTER);
        vbxResult.setPadding(new Insets(300));
        vbxResult.setSpacing(10);

        HBox hbxBars = new HBox();
        hbxBars.setAlignment(Pos.CENTER);
        hbxBars.setSpacing(10);

        Text txtTitle = new Text("Résultats\n");
        txtTitle.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        vbxResult.getChildren().add(txtTitle);

        Bar barHealth = new Bar(0, 0, Color.RED, Color.BLACK, health);
        Bar barHappiness = new Bar(0, 0, Color.YELLOW, Color.BLACK, happiness);
        Bar barMoney = new Bar(0, 0, Color.GREEN, Color.BLACK, money);

        // Drawing info messages

        String text = "";
        int newHealth = health - 20;
        int newHappiness = happiness - 20;
        int newMoney = money - 20;

        if(newHealth > happiness && newHealth > money)
            text += "\nVous êtes en grande forme, peut-être même trop ; il faut penser à dépenser l'énergie que vous avez.\n";
        else if(newHappiness > health && newHappiness > money)
            text += "\nVous êtes heureux !  ...mais ne vous avez-vous pas un peu trop gaté ?\n";
        else if(newMoney > health && newMoney > happiness)
            text += "\nIl vous reste beaucoup d'argent ! C'est une bonne chose, mais cet argent devrait être dépensé pour vous.\n";

        newHealth = health + 20;
        newHappiness = happiness + 20;
        newMoney = money + 20;

        if(newHealth < happiness && newHealth < money)
            text += "\nVous n'allez pas bien... Vos objectifs sont malheureusement entrain de vous consummer.\n";
        else if(newHappiness < health && newHappiness < money)
            text += "\nIl vous est nécessaire de vous faire plaisir ; vous n'avancerez pas sans motivation.\n";
        else if(newMoney < health && newMoney < happiness)
            text += "\nVous manquez de fonds pour répondre à vos besoins, et cela devient critique...\n";

        hbxBars.getChildren().addAll(barHealth, barHappiness, barMoney);

        Text txtInfo = new Text(text == "" ? "Vous êtes sur la bonne voie ! Vos choix sont cohérents !" : text);
        txtInfo.setTextAlignment(TextAlignment.CENTER);
        txtInfo.setFont(Font.font("Arial", FontWeight.LIGHT, 16));

        Button btnMainMenu = new Button("Menu principal");
        btnMainMenu.setOnAction(actionEvent -> Main.setShowedPage(new PageMainMenu()));

        vbxResult.getChildren().addAll(hbxBars, txtInfo, btnMainMenu);

        add(vbxResult);
    }
}
