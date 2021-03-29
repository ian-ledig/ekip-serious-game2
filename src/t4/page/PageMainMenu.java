package t4.page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import t4.Main;

public class PageMainMenu extends Page {

    public PageMainMenu(){
        draw();
    }

    @Override
    public void draw() {

        VBox vbxMenu = new VBox();
        vbxMenu.setAlignment(Pos.CENTER);
        vbxMenu.setPadding(new Insets(300));
        vbxMenu.setSpacing(10);

        Text txtGoal = new Text("Objectif : rendre les jauges de santé, bonheur et budget médiane.\n\n\n");
        txtGoal.setFont(Font.font("Arial", FontWeight.LIGHT, 20));

        // Month selector
        Text txtMonth = new Text("Nombre de mois de jeu");
        txtMonth.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        TextField txfMonth = new TextField("5");
        txfMonth.setMaxWidth(100);
        txfMonth.textProperty().addListener((observable, oldValue, newValue) -> setTextFieldNumberOnly(txfMonth, newValue));
        vbxMenu.getChildren().addAll(txtGoal, txtMonth, txfMonth);

        // Salary selector
        Text txtSalary = new Text("Salaire hebdomadaire");
        txtSalary.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        TextField txfSalary = new TextField("1000");
        txfSalary.setMaxWidth(100);
        txfSalary.textProperty().addListener((observable, oldValue, newValue) -> setTextFieldNumberOnly(txfSalary, newValue));
        vbxMenu.getChildren().addAll(txtSalary, txfSalary);

        // Play button
        Button btnPlay = new Button("Play");
        btnPlay.setOnMouseClicked(event -> {
            int monthNumber = Integer.parseInt(txfMonth.getText());
            int salary = Integer.parseInt(txfSalary.getText());
            if(
                    txfMonth != null && monthNumber > 0 &&
                    txfSalary != null && salary > 0
            )
                Main.setShowedPage(new PageGame(monthNumber, salary));
        });
        vbxMenu.getChildren().add(btnPlay);

        add(vbxMenu);
    }

    public void setTextFieldNumberOnly(TextField txf, String newValue){
        if (!newValue.matches("\\d*")) {
            txf.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }
}
