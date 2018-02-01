package com.dandlestone;

import com.almasb.fxgl.entity.Control;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.PhysicsComponent;

public class PlayerOneControls extends Control{

    private PhysicsComponent physics;

    @Override
    public void onUpdate(Entity entity, double v) {

    }

    public void aleft() {
        physics.setVelocityX(-150);
    }

    public void dright() {
        physics.setVelocityX(150);
    }

    public void wjump() {
        physics.setVelocityY(-400);
    }





}
