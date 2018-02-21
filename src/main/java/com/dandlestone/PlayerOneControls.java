package com.dandlestone;

import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;

public class PlayerOneControls extends Control{

    private PhysicsComponent physics;
    private Entity entity;
    private AnimatedTexture texture;
    private AnimationChannel animIdle, animRun;
    private TestDandleStone com;

    public PlayerOneControls(){

        animIdle = new AnimationChannel("playerspriteidle.png", 3 , 141/3, 51, javafx.util.Duration.seconds(1), 0, 2);
        animRun = new AnimationChannel("playerspriterunning.png", 8 , (47+(7/10)), 56, javafx.util.Duration.seconds(1), 0, 7);

        texture = new AnimatedTexture(animIdle);

    }

    @Override
    public void onAdded(Entity entity) {
        entity.setView(texture);
    }

    @Override
    public void onUpdate(Entity entity, double v) {

        texture.setAnimationChannel(isMoving() ? animRun : animIdle);

    }

    private boolean isMoving() {
        return FXGLMath.abs(physics.getVelocityX()) > 0;
    }

    public void aleft() {
        getEntity().setScaleX(1);
        physics.setVelocityX(-150);
    }

    public void dright() {
        getEntity().setScaleX(-1);
        physics.setVelocityX(150);
    }

    //Jump, only from platform
    public void wjump() { if (physics.getVelocityY() == 0) physics.setVelocityY(-520);
    }

    //remove Entity from world
    public void die(){
        getEntity().removeFromWorld();

    }
}
