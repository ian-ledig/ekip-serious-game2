package t4.page;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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

        Text txtSalarySelect = new Text("Moyen");
        txtSalarySelect.setFont(Font.font("Arial", FontWeight.LIGHT, 9));

        HBox hbxSalary = new HBox();
        hbxSalary.setAlignment(Pos.CENTER);
        hbxSalary.setSpacing(8);

        Button btnSalary1 = new Button("Petit");
        btnSalary1.setOnAction(actionEvent -> {
            txtSalarySelect.setText(btnSalary1.getText());
        });
        btnSalary1.setMaxWidth(100);

        Button btnSalary2 = new Button("Moyen");
        btnSalary2.setOnAction(actionEvent -> {
            txtSalarySelect.setText(btnSalary2.getText());
        });
        btnSalary1.setMaxWidth(100);

        Button btnSalary3 = new Button("Gros");
        btnSalary3.setOnAction(actionEvent -> {
            txtSalarySelect.setText(btnSalary3.getText());
        });
        btnSalary1.setMaxWidth(100);

        hbxSalary.getChildren().addAll(btnSalary1, btnSalary2, btnSalary3);

        vbxMenu.getChildren().addAll(txtSalary, txtSalarySelect, hbxSalary);

        // Play button
        Button btnPlay = new Button("Play");
        btnPlay.setPrefWidth(300);
        btnPlay.setOnMouseClicked(event -> {
            int monthNumber = Integer.parseInt(txfMonth.getText());
            int salary;
            switch (txtSalarySelect.getText()){
                case "Petit" -> salary = 4;
                case "Gros" -> salary = 6;
                default -> salary = 5;
            }
            if(txfMonth != null && monthNumber > 0)
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
