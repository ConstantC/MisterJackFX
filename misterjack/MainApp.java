package misterjack;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import misterjack.model.Quartier;
import misterjack.view.GameBoardController;
import java.util.concurrent.TimeUnit;


public class MainApp extends Application {

    private Stage primaryStage;
    //GameEngine Game = new GameEngine();

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MisterJack");

        showGameBoard();

    }

    /**
     * Show the game board Window
     */
    public void showGameBoard() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/GameBoard.fxml"));
            AnchorPane GameBoard = (AnchorPane) loader.load();

            GameBoard.setStyle("-fx-background-color: #373737;");

            GameBoardController controller = loader.getController();
            controller.setMainApp(this);

            Scene scene = new Scene(GameBoard);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (IOException e) {
            e.printStackTrace();
        }
        //double height = primaryStage.getHeight();
        //System.out.println(height);
    }

  /*  public void initDisplayGameBoard() {
        String[] quartiers = new String[9];
        int[] murs = new int[9];
        Quartier[] district = Game.getDistrict();

        for(int i=0; i<9; i++){
            quartiers[i] = district[i].getName();
            murs[i] = district[i].getRotation();
        }
    }*/

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}