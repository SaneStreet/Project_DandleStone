package com.dandlestone;

import com.almasb.fxgl.entity.Control;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.PhysicsComponent;

public class PlayerOneControls extends Control{

    private PhysicsComponent physics;
    private Entity entity;

    @Override
    public void onUpdate(Entity entity, double v) {

    }

    public void aleft() {
        physics.setVelocityX(-120);
    }

    public void dright() {
        physics.setVelocityX(120);
    }

    //Jump, only from platform
    public void wjump() { if (physics.getVelocityY() == 0) physics.setVelocityY(-520); }

}
