package com.dandlestone;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.settings.GameSettings;
import com.sun.scenario.Settings;
import javafx.scene.input.KeyCode;

public class TestDandleStone extends GameApplication{

    //Set the Scene
    @Override
    protected void initSettings(GameSettings Settings) {
        Settings.setHeight(10*70);
        Settings.setWidth(15*70);
    }

    //set player one
    private Entity playerOne;


    //Get the input from the contols on a-left w-jump d-right
    @Override
    protected void initInput() {
        getInput().addAction(new UserAction("aleft") {
            @Override
            protected void onAction() {
                playerOne.getControl(com.dandlestone.PlayerOneControls.class).aleft();
            }
        }, KeyCode.A);

        getInput().addAction(new UserAction("dright") {
            @Override
            protected void onAction() {
                playerOne.getControl(com.dandlestone.PlayerOneControls.class).dright();
            }
        }, KeyCode.D);

        getInput().addAction(new UserAction("wjump") {
            @Override
            protected void onAction() {
                playerOne.getControl(com.dandlestone.PlayerOneControls.class).wjump();
            }
        }, KeyCode.W);
    }




    //get the Gameworld (TiledMap.json
    @Override
    protected void initGame() {
        getGameWorld().setLevelFromMap("DebugMap.json");

        //spawn player one in his starting location
        playerOne = getGameWorld().spawn("player",50,180);
    }

    //Launch the app
    public static void main(String[] args) {
        launch(args);
    }
}