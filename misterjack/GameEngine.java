package misterjack;

import misterjack.model.*;
import java.util.*;


public class GameEngine {
    Quartier[] district = new Quartier[9];
    Detective[] detectives = new Detective[3];
    Action[] actions = new Action[4];

    public void initDistrict(){
        int[] angles = {0, 90, 180, 270};
        Random random = new Random();
        int choice = 0;

        List<String> names = Arrays.asList("blackStreet","blueStreet","greenStreet","greyStreet","magentaStreet",
                "orangeStreet","pinkStreet","whiteStreet","yellowStreet");
        Collections.shuffle(names);

        for(int i=0; i<9; i++){

            if(i==0 || i==2 || i==7){
                switch(i){
                    case 0: choice = 1;break;
                    case 2: choice = 3;break;
                    case 7: choice = 0;break;
                }
            }
            else{
                choice = random.nextInt(4);
            }
            district[i] = new Quartier(names.get(i), angles[choice]);
        }

    }

    public void initDetectives(){
        String[] names = {"Holmes", "Watson", "Toby"};
        int[] positions = {11,3,7};

        for(int i=0; i<3; i++){
            detectives[i] = new Detective(names[i],positions[i]);
        }
    }

    public void initActions(){
        List<String> tpActions = Arrays.asList("","","","","","","","");
        Collections.shuffle(tpActions);

        for(int i = 0; i<4; i++){
            actions[i] = new Action(tpActions.get(i),tpActions.get(4+i),-1,true);
        }
    }

    public void nextPosition(Detective tpDetective){
        int actualPosition = tpDetective.getPosition();
        if(actualPosition == 11){
            tpDetective.setPosition(0);
        }
        else{tpDetective.setPosition(tpDetective.getPosition()+1);}
    }

    public Quartier[] getDistrict(){
        return district;
    }

    public Detective[] getDetectives(){
        return detectives;
    }
    public Action[] getActions(){
        return actions;
    }
}
