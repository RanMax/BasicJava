package org.basicjava.test.iu4.smurigin.sea_war.game_classes;

import java.util.Random;

public class Player {

    public String name;

    public Player(String playerName, int shipsLive){
        name = playerName;
    }

    public static boolean Rand(){
        Random rand = new Random();
        boolean t = rand.nextBoolean();
        return t;
    }

}
