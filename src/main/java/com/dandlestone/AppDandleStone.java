package com.dandlestone;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.settings.GameSettings;
import com.sun.scenario.Settings;

public class AppDandleStone extends GameApplication{

    //Set the Scene
    @Override
    protected void initSettings(GameSettings Settings) {
        Settings.setHeight(10*70);
        Settings.setWidth(15*70);
    }

    //get the Gameworld (TiledMap.json
    @Override
    protected void initGame() {
        getGameWorld().setLevelFromMap("TestMap.json");
    }

    //Launch the app
    public static void main(String[] args) {
        launch(args);
    }
}