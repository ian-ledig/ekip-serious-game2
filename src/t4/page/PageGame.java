package t4.page;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import t4.Main;
import t4.component.Bar;
import t4.util.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class PageGame extends Page{

    public static final String TEXTURE_BACKGROUND = "src/assets/textures/background.png";

    private final int monthNumber;
    private final int salary;

    private final Text txtTitle = new Text();

    private int month = 1;

    public PageGame(int monthNumber, int salary){
        this.monthNumber = monthNumber;
        this.salary = salary;

        draw();
    }

    @Override
    public void draw() {
        BorderPane pane = new BorderPane();

        // Game view
        Group grpGame = new Group();
        ImageView imgBackground = null;
        try {
            imgBackground = new ImageView(new Image(new FileInputStream(TEXTURE_BACKGROUND)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Bar barHealth = new Bar("Santé", 700, 30, Color.RED, Color.WHITE, 10);
        Bar barHappiness = new Bar("Bonheur", 760, 30, Color.YELLOW, Color.WHITE, 10);
        Bar barMoney = new Bar("Budget", 820, 30, Color.GREEN, Color.WHITE, 10);

        Text txtInfoGame = new Text();
        txtInfoGame.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        txtInfoGame.setFill(Color.WHITE);
        txtInfoGame.setX(10);
        txtInfoGame.setY(25);

        grpGame.getChildren().addAll(imgBackground, barHealth, barHappiness, barMoney, txtInfoGame);

        pane.setRight(grpGame);

        // Menu view
        VBox vbxMenu = new VBox();
        vbxMenu.setPadding(new Insets(15));
        vbxMenu.setSpacing(4);

        updateTitle();
        txtTitle.setFont(Font.font("Arial", FontWeight.BOLD, 13));

        Text txtInfo = new Text("   Remplissez vos choix de ce mois-ci en essayant d'avoir\n   un équilibre des trois jauges (1 choix par catégorie).");
        txtInfo.setFont(Font.font("Arial", FontWeight.LIGHT, 11));

        Text txtShopping = new Text("Courses");
        txtShopping.setFont(Font.font("Arial", FontWeight.BOLD, 11));

        Text txtShoppingSelect = new Text("-");
        txtShoppingSelect.setFont(Font.font("Arial", FontWeight.BOLD, 9));

        vbxMenu.getChildren().addAll(txtTitle, txtInfo, txtShopping, txtShoppingSelect);

        for(int i = 0; i < Shopping.values().length; i++){
            Shopping shopping = Shopping.values()[i];
            String text = shopping.getInfo().getName();
            Button btn = new Button(text);
            btn.setOnAction(actionEvent -> txtShoppingSelect.setText(text));
            vbxMenu.getChildren().add(btn);
        }

        Text txtRelaxation = new Text("Sorties");
        txtRelaxation.setFont(Font.font("Arial", FontWeight.BOLD, 11));

        Text txtRelaxationSelect = new Text("-");
        txtRelaxationSelect.setFont(Font.font("Arial", FontWeight.BOLD, 9));

        vbxMenu.getChildren().addAll(txtRelaxation, txtRelaxationSelect);

        for(int i = 0; i < Relaxation.values().length; i++){
            Relaxation relaxation = Relaxation.values()[i];
            String text = relaxation.getInfo().getName();
            Button btn = new Button(text);
            btn.setOnAction(actionEvent -> txtRelaxationSelect.setText(text));
            vbxMenu.getChildren().add(btn);
        }

        Text txtWork = new Text("Travail");
        txtWork.setFont(Font.font("Arial", FontWeight.BOLD, 11));

        Text txtWorkSelect = new Text("-");
        txtWorkSelect.setFont(Font.font("Arial", FontWeight.BOLD, 9));

        vbxMenu.getChildren().addAll(txtWork, txtWorkSelect);

        for(int i = 0; i < Work.values().length; i++){
            Work work = Work.values()[i];
            String text = work.getInfo().getName();
            Button btn = new Button(text);
            btn.setOnAction(actionEvent -> txtWorkSelect.setText(text));
            vbxMenu.getChildren().add(btn);
        }

        Text txtPurchase = new Text("Achats");
        txtPurchase.setFont(Font.font("Arial", FontWeight.BOLD, 11));

        Text txtPurchaseSelect = new Text("-");
        txtPurchaseSelect.setFont(Font.font("Arial", FontWeight.BOLD, 9));

        vbxMenu.getChildren().addAll(txtPurchase, txtPurchaseSelect);

        for(int i = 0; i < Purchase.values().length; i++){
            Purchase purchase = Purchase.values()[i];
            String text = purchase.getInfo().getName();
            Button btn = new Button(text);
            btn.setOnAction(actionEvent -> txtPurchaseSelect.setText(text));
            vbxMenu.getChildren().add(btn);
        }

        Text txtHealth = new Text("Soins");
        txtHealth.setFont(Font.font("Arial", FontWeight.BOLD, 11));

        Text txtHealthSelect = new Text("-");
        txtHealthSelect.setFont(Font.font("Arial", FontWeight.BOLD, 9));

        vbxMenu.getChildren().addAll(txtHealth, txtHealthSelect);

        for(int i = 0; i < Health.values().length; i++){
            Health health = Health.values()[i];
            String text = health.getInfo().getName();
            Button btn = new Button(text);
            btn.setOnAction(actionEvent -> txtHealthSelect.setText(text));
            vbxMenu.getChildren().add(btn);
        }

        Text txtHome = new Text("Chez moi");
        txtHome.setFont(Font.font("Arial", FontWeight.BOLD, 11));

        Text txtHomeSelect = new Text("-");
        txtHomeSelect.setFont(Font.font("Arial", FontWeight.BOLD, 9));

        vbxMenu.getChildren().addAll(txtHome, txtHomeSelect);

        for(int i = 0; i < Home.values().length; i++){
            Home home = Home.values()[i];
            String text = home.getInfo().getName();
            Button btn = new Button(text);
            btn.setOnAction(actionEvent -> txtHomeSelect.setText(text));
            vbxMenu.getChildren().add(btn);
        }

        Text txtExtra = new Text("Extra");
        txtExtra.setFont(Font.font("Arial", FontWeight.BOLD, 11));

        Text txtExtraSelect = new Text("-");
        txtExtraSelect.setFont(Font.font("Arial", FontWeight.BOLD, 9));

        vbxMenu.getChildren().addAll(txtExtra, txtExtraSelect);

        for(int i = 0; i < Extra.values().length; i++){
            Extra extra = Extra.values()[i];
            String text = extra.getInfo().getName();
            Button btn = new Button(text);
            btn.setOnAction(actionEvent -> txtExtraSelect.setText(text));
            vbxMenu.getChildren().add(btn);
        }

        Text txtOk = new Text("Validez votre choix et passez au mois suivant.");
        txtOk.setFont(Font.font("Arial", FontWeight.BOLD, 12));

        Text txtOkInfo = new Text();
        txtOkInfo.setFont(Font.font("Arial", FontWeight.BOLD, 9));

        Button btnOk = new Button("Valider");
        btnOk.setOnAction(actionEvent -> {
            if(
                    txtShoppingSelect.getText() != "-" &&
                    txtRelaxationSelect.getText() != "-" &&
                    txtWorkSelect.getText() != "-" &&
                    txtPurchaseSelect.getText() != "-" &&
                    txtHealthSelect.getText() != "-" &&
                    txtHomeSelect.getText() != "-" &&
                    txtExtraSelect.getText() != "-"
            ){
                txtOkInfo.setText("");

                int healthValue = barHealth.getValue();
                int happinessValue = barHappiness.getValue();
                int moneyValue = barMoney.getValue();

                ActivityInfo aciShopping = Shopping.getByName(txtShoppingSelect.getText()).getInfo();
                healthValue += aciShopping.getHealth();
                happinessValue += aciShopping.getHappiness();
                moneyValue += aciShopping.getMoney();

                ActivityInfo aciRelaxation = Relaxation.getByName(txtRelaxationSelect.getText()).getInfo();
                healthValue += aciRelaxation.getHealth();
                happinessValue += aciRelaxation.getHappiness();
                moneyValue += aciRelaxation.getMoney();

                ActivityInfo aciWork = Work.getByName(txtWorkSelect.getText()).getInfo();
                healthValue += aciWork.getHealth();
                happinessValue += aciWork.getHappiness();
                moneyValue += aciWork.getMoney();

                ActivityInfo aciPurchase = Purchase.getByName(txtPurchaseSelect.getText()).getInfo();
                healthValue += aciPurchase.getHealth();
                happinessValue += aciPurchase.getHappiness();
                moneyValue += aciPurchase.getMoney();

                ActivityInfo aciHealth = Health.getByName(txtHealthSelect.getText()).getInfo();
                healthValue += aciHealth.getHealth();
                happinessValue += aciHealth.getHappiness();
                moneyValue += aciHealth.getMoney();

                ActivityInfo aciHome = Home.getByName(txtHomeSelect.getText()).getInfo();
                healthValue += aciHome.getHealth();
                happinessValue += aciHome.getHappiness();
                moneyValue += aciHome.getMoney();

                ActivityInfo aciExtra = Extra.getByName(txtExtraSelect.getText()).getInfo();
                healthValue += aciExtra.getHealth();
                happinessValue += aciExtra.getHappiness();
                moneyValue += aciExtra.getMoney();

                Penalty penalty = Penalty.values()[new Random().nextInt(Penalty.values().length)];

                healthValue = barHealth.getValue() + healthValue + penalty.getInfo().getHealth();
                if(healthValue > 100)
                    healthValue = 100;

                happinessValue = barHappiness.getValue() + happinessValue + penalty.getInfo().getHappiness();
                if(happinessValue > 100)
                    happinessValue = 100;

                moneyValue = barMoney.getValue() + moneyValue + salary;
                if(moneyValue > 100)
                    moneyValue = 100;

                barHealth.setValue(healthValue);
                barHappiness.setValue(happinessValue);
                barMoney.setValue(moneyValue);

                ActivityInfo activityInfo = new ActivityInfo("", healthValue, happinessValue, moneyValue);

                if(month == monthNumber)
                    Main.setShowedPage(new PageResult(activityInfo));
                else{
                    month++;

                    txtShoppingSelect.setText("-");
                    txtRelaxationSelect.setText("-");
                    txtWorkSelect.setText("-");
                    txtPurchaseSelect.setText("-");
                    txtHealthSelect.setText("-");
                    txtHomeSelect.setText("-");
                    txtExtraSelect.setText("-");

                    txtInfoGame.setText(penalty.getInfo().getName());
                }

                updateTitle();
            }
            else
                txtOkInfo.setText("Veuillez sélectionner un élément par catégorie !");
        });
        vbxMenu.getChildren().addAll(txtOk, txtOkInfo, btnOk);

        pane.setLeft(vbxMenu);

        add(pane);
    }

    public void updateTitle(){
        txtTitle.setText("Mois numéro " + month + "/" + monthNumber);
    }
}
