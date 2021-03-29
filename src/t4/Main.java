package t4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import t4.page.Page;
import t4.page.PageGame;
import t4.page.PageMainMenu;

public class Main extends Application {

    public static final StackPane ROOT = new StackPane();
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 1000;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("T4");
        primaryStage.setScene(new Scene(ROOT, WIDTH, HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.show();

        setShowedPage(new PageMainMenu());
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void setShowedPage(Page showedPage) {
        Main.ROOT.getChildren().clear();
        Main.ROOT.getChildren().add(showedPage);
    }
}
