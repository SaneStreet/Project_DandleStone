package com.dandlestone;

import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;

@SetEntityFactory
public class AppDandleStoneFactory implements EntityFactory {


    @Spawns("project")
    public Entity newproject(SpawnData data){
        return Entities.builder()
                .build();
    }

    @Spawns("platform")
    public Entity newplatform(SpawnData data) {
        return Entities.builder()
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }



}
