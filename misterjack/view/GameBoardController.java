package misterjack.view;

import java.util.*;
import javafx.fxml.FXML;
import javafx.geometry.*;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import misterjack.GameEngine;
import misterjack.MainApp;
import misterjack.model.*;


public class GameBoardController {
    @FXML
    public ImageView quartier1;
    @FXML
    private ImageView quartier2;
    @FXML
    private ImageView quartier3;
    @FXML
    private ImageView quartier4;
    @FXML
    private ImageView quartier5;
    @FXML
    private ImageView quartier6;
    @FXML
    private ImageView quartier7;
    @FXML
    private ImageView quartier8;
    @FXML
    private ImageView quartier9;
    @FXML
    private ImageView Holmes;
    @FXML
    private ImageView Watson;
    @FXML
    private ImageView Toby;

    private final TreeMap<String,Image> imagesQuartiers = new TreeMap<>();
    private final Image[] imagesDetectives = new Image[9];
    MainApp mainApp;

    GameEngine game = new GameEngine();

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public GameBoardController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
    */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    public void initialize(){
        game.initDistrict();
        game.initDetectives();

        loadImages();

        loadDistrict();

        loadDetectives();
    }


    public void positionDetective(MouseEvent e) {
        ImageView event = (ImageView) e.getSource();
        String name = event.getId();

        Detective[] detectives = game.getDetectives();
        Detective tpDetective = null;


        for(int i=0; i<3; i++){
            if(name.equals(detectives[i].getName())){tpDetective = detectives[i];}
        }

        assert tpDetective != null;
        game.nextPosition(tpDetective);
        loadDetectives();
    }

    private void loadImages() {
        String[] tpQuartiers = {"blackStreet", "blueStreet", "greenStreet", "greyStreet",
                "magentaStreet", "orangeStreet", "pinkStreet", "whiteStreet", "yellowStreet"};

        Detective[] tpDetectives = game.getDetectives();

        String path;

        for(int i = 0; i<9; i++) {
            path  = "/ressources/images/Quartiers/" + tpQuartiers[i] + ".png";
            imagesQuartiers.put(tpQuartiers[i], new Image(getClass().getResourceAsStream(path)));//asStream
        }

        for(int j = 0; j<3; j++){
            path = "/ressources/images/Detectives/" + tpDetectives[j].getName() + ".png";
            imagesDetectives[j] = new Image(getClass().getResourceAsStream(path));
        }
    }

    private void loadDistrict(){
        ImageView[] tpQuartiers = {quartier1, quartier2, quartier3, quartier4,
                quartier5, quartier6, quartier7, quartier8, quartier9};
        List<ImageView> quartiers = Arrays.asList(tpQuartiers);
        Quartier[] tpDistrict = game.getDistrict();

        for(int i=0; i<9; i++){
            quartiers.get(i).setImage(imagesQuartiers.get(tpDistrict[i].getName()));
            quartiers.get(i).setRotate(tpDistrict[i].getRotation());
        }
    }

    private void loadDetectives(){
        ImageView[] tpImageViews = {Holmes, Watson, Toby};
        Detective[] tpDetectives = game.getDetectives();

        for(int i=0; i<3; i++){
            tpImageViews[i].setImage(imagesDetectives[i]);
            int[] tpPosition = getPosition(tpDetectives[i].getPosition());
            GridPane.setColumnIndex(tpImageViews[i],tpPosition[0]);
            GridPane.setRowIndex(tpImageViews[i],tpPosition[1]);
            tpImageViews[i].setId(tpDetectives[i].getName());
            tpImageViews[i].setOnMouseClicked(this::positionDetective);
        }
        checkPosition(tpDetectives,tpImageViews);

    }

    private int[] getPosition(int tpPosition){
        int[] coordinates = new int[2];
        switch (tpPosition){
            case 0:coordinates[0] = 1;break;
            case 1:coordinates[0] = 2;break;
            case 2:coordinates[0] = 3;break;
            case 3:coordinates[0] = 4;coordinates[1] = 1;break;
            case 4:coordinates[0] = 4;coordinates[1] = 2;break;
            case 5:coordinates[0] = 4;coordinates[1] = 3;break;
            case 6:coordinates[0] = 3;coordinates[1] = 4;break;
            case 7:coordinates[0] = 2;coordinates[1] = 4;break;
            case 8:coordinates[0] = 1;coordinates[1] = 4;break;
            case 9:coordinates[1] = 3;break;
            case 10:coordinates[1] = 2;break;
            case 11:coordinates[1] = 1;break;
        }
        return coordinates;
    }

    private void checkPosition(Detective[] tpDetectives, ImageView[] tpImageViews){

        List<Integer> positionsall = Arrays.asList(tpDetectives[0].getPosition(),tpDetectives[1].getPosition(),tpDetectives[2].getPosition());

        if(positionsall.get(0).equals(positionsall.get(1)) || positionsall.get(1).equals(positionsall.get(2))|| positionsall.get(0).equals(positionsall.get(2))){

            if(positionsall.get(0).equals(positionsall.get(1))){
                GridPane.setValignment(tpImageViews[0], VPos.TOP);
                GridPane.setValignment(tpImageViews[1], VPos.BOTTOM);
                GridPane.setHalignment(tpImageViews[0], HPos.LEFT);
                GridPane.setHalignment(tpImageViews[1], HPos.RIGHT);
                GridPane.setValignment(tpImageViews[2], VPos.CENTER);
                GridPane.setHalignment(tpImageViews[2], HPos.CENTER);
            }

            else if(positionsall.get(1).equals(positionsall.get(2))){
                GridPane.setValignment(tpImageViews[1], VPos.TOP);
                GridPane.setValignment(tpImageViews[2], VPos.BOTTOM);
                GridPane.setHalignment(tpImageViews[1], HPos.LEFT);
                GridPane.setHalignment(tpImageViews[2], HPos.RIGHT);
                GridPane.setValignment(tpImageViews[0], VPos.CENTER);
                GridPane.setHalignment(tpImageViews[0], HPos.CENTER);
            }

            else if(positionsall.get(0).equals(positionsall.get(2))){
                GridPane.setValignment(tpImageViews[0], VPos.TOP);
                GridPane.setValignment(tpImageViews[2], VPos.BOTTOM);
                GridPane.setHalignment(tpImageViews[0], HPos.LEFT);
                GridPane.setHalignment(tpImageViews[2], HPos.RIGHT);
                GridPane.setValignment(tpImageViews[1], VPos.CENTER);
                GridPane.setHalignment(tpImageViews[1], HPos.CENTER);
            }

            if(positionsall.get(0).equals(positionsall.get(1)) && positionsall.get(1).equals(positionsall.get(2))){
                GridPane.setValignment(tpImageViews[0], VPos.TOP);
                GridPane.setValignment(tpImageViews[1], VPos.BOTTOM);
                GridPane.setValignment(tpImageViews[2], VPos.CENTER);
                GridPane.setHalignment(tpImageViews[0], HPos.LEFT);
                GridPane.setHalignment(tpImageViews[1], HPos.RIGHT);
                GridPane.setHalignment(tpImageViews[2], HPos.CENTER);
            }
        }
        else{
            GridPane.setValignment(tpImageViews[0], VPos.CENTER);
            GridPane.setValignment(tpImageViews[1], VPos.CENTER);
            GridPane.setValignment(tpImageViews[2], VPos.CENTER);
            GridPane.setHalignment(tpImageViews[0], HPos.CENTER);
            GridPane.setHalignment(tpImageViews[1], HPos.CENTER);
            GridPane.setHalignment(tpImageViews[2], HPos.CENTER);
        }
    }

}
