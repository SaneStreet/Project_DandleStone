package com.dandlestone;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.input.UserAction;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.settings.GameSettings;
import javafx.scene.input.KeyCode;

public class TestDandleStone extends GameApplication{

    //Set the Scene
    @Override
    protected void initSettings(GameSettings Settings) {
        Settings.setHeight(11*70);
        Settings.setWidth(15*70);
        //Settings.setSingleStep(true);
    }

    //set player one
    private Entity playerOne;

    //set player two
    private Entity playertwo;

    //Get the input from the controls on a-left w-jump d-right
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
            protected void onActionBegin() { //onActionBegin() for at man skal trykke for hver gang.
                playerOne.getControl(com.dandlestone.PlayerOneControls.class).wjump(); }
        }, KeyCode.W);

        /*DSLKt.onKeyDown(KeyCode.I, "update", new Runnable() {
                    public void run() {
                        stepLoop();
                    }
                }
        );*/
        //-----------------------implementing conrols for player two

        getInput().addAction(new UserAction("arrowleft") {
            @Override
            protected void onAction() {
                playertwo.getControl(com.dandlestone.PlayerTwoControls.class).arrowleft();
            }
        }, KeyCode.LEFT);

        getInput().addAction(new UserAction("arrowright") {
            @Override
            protected void onAction() {
                playertwo.getControl(com.dandlestone.PlayerTwoControls.class).arrowright();
            }
        }, KeyCode.RIGHT);

        getInput().addAction(new UserAction("arrowjump") {
            @Override
            protected void onAction() {
                playertwo.getControl(com.dandlestone.PlayerTwoControls.class).arrowjump();
            }
        }, KeyCode.UP);
    }

    //get the Gameworld (TiledMap.json)
    @Override
    protected void initGame() {
        getGameWorld().setLevelFromMap("DebugMap.json");

        //spawn player one in his starting location
        playerOne = getGameWorld().spawn("playerOne",50,180);

        //spawn a player two in his starting location
        playertwo = getGameWorld().spawn("playerTwo",100, 180);
    }

    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(DandlesStoneType.PLAYER, DandlesStoneType.BOTTOM) {
            @Override
            protected void onCollisionBegin(Entity player, Entity bottom) {
                player.removeFromWorld();
            }
        });
    }

    //Launch the app
    public static void main(String[] args) {
        launch(args);
    }
}