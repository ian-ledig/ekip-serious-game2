package t4.component;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Bar extends Group {

    public static final String TEXTURE_BAR = "src/assets/textures/bar.png";

    private final String name;
    private final Color color;
    private final Rectangle fill = new Rectangle(0, 0, 40, 228);
    private final Text txtValue = new Text();

    public Bar(String name, int x, int y, Color color, Color textColor, int baseValue){
        setTranslateX(x);
        setTranslateY(y);

        this.name = name;
        this.color = color;

        txtValue.setY(245);
        txtValue.setX(7);
        txtValue.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        txtValue.setFill(textColor);
        setValue(baseValue);

        draw();
    }

    public void draw(){
        fill.setFill(color);

        Text txtName = new Text(this.name);
        txtName.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        txtName.setFill(Color.WHITE);

        getChildren().addAll(fill, txtName, txtValue);

        try {
            ImageView imgBar = new ImageView(new Image(new FileInputStream(TEXTURE_BAR)));
            getChildren().add(imgBar);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setValue(int value){
        int percent = value*228/100;
        fill.setY(228 - percent);
        fill.setHeight(percent);
        txtValue.setText(value + "%");
    }

    public int getValue(){
        return Integer.parseInt(txtValue.getText().replace("%", ""));
    }
}
