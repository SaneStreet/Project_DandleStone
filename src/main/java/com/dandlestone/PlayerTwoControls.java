package com.dandlestone;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.Control;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;

public class PlayerTwoControls extends Control{

    private PhysicsComponent physicstwo;
    private Entity entitytwo;
    private AnimatedTexture texture;
    private AnimationChannel animIdle, animRun;

    public PlayerTwoControls () {
        animIdle = new AnimationChannel("playertwospriteidle.png", 3 , 141/3, 51, javafx.util.Duration.seconds(1), 0, 2);
        animRun = new AnimationChannel("playertwospriterunning.png", 8 , (47+(7/10)), 56, javafx.util.Duration.seconds(1), 0, 7);

        texture = new AnimatedTexture(animIdle);
    }

    @Override
    public void onAdded(Entity entity) {
        entity.setView(texture);

    }

    private boolean isMoving() {
        return FXGLMath.abs(physicstwo.getVelocityX()) > 0;
    }

    @Override
    public void onUpdate(Entity entitytwo, double v) {
        texture.setAnimationChannel(isMoving() ? animRun : animIdle);
    }

    public void arrowleft() {
        getEntity().setScaleX(1);
        physicstwo.setVelocityX(-150);
    }

    public void arrowright() {
        getEntity().setScaleX(-1);
        physicstwo.setVelocityX(150);
    }

    //Jump, only from platform
    public void arrowjump() { if (physicstwo.getVelocityY() == 0) physicstwo.setVelocityY(-520); }

}