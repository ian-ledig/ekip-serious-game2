package t4.page;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public abstract class Page extends VBox {

    public void add(Node node) {
        getChildren().add(node);
    }

    public void addAll(Node... nodes){
        getChildren().addAll(nodes);
    }

    public abstract void draw();
}
