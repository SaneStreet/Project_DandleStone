package com.dandlestone;

import com.almasb.fxgl.entity.Control;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.physics.CollisionHandler;
import com.almasb.fxgl.physics.PhysicsComponent;

public class PlayerTwoControls extends Control{

    private PhysicsComponent physicstwo;
    private Entity entitytwo;

    @Override
    public void onUpdate(Entity entitytwo, double v) {

    }

    public void arrowleft() {
        physicstwo.setVelocityX(-150);
    }

    public void arrowright() {
        physicstwo.setVelocityX(150);
    }

    //Jump, only from platform
    public void arrowjump() { if (physicstwo.getVelocityY() == 0) physicstwo.setVelocityY(-520); }

}