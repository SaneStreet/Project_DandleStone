package com.dandlestone;

import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.component.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
                .type(DandlesStoneType.PLATFORM)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

    @Spawns("wall")
    public Entity newwall(SpawnData data) {
        return Entities.builder()
                .type(DandlesStoneType.WALL)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

    @Spawns("ceiling")
    public Entity newceiling(SpawnData data) {
        return Entities.builder()
                .type(DandlesStoneType.CEILING)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

    @Spawns("bottom")
    public Entity newbottom(SpawnData data) {
        return Entities.builder()
                .type(DandlesStoneType.BOTTOM)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .with(new CollidableComponent(true))
                .build();
    }

    @Spawns("player")
    public Entity newPlayer1(SpawnData data){
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);

        return Entities.builder()
                .type(DandlesStoneType.PLAYER)
                .from(data)
                .viewFromNodeWithBBox(new Rectangle(30, 45, Color.BLUE))
                .with(physics)
                .with(new CollidableComponent(true))
                .with(new PlayerOneControls())
                .build();
    }

    @Spawns("playertwo")
    public Entity newPlayer2(SpawnData data){
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);

        return Entities.builder()
                .type(DandlesStoneType.PLAYER)
                .from(data)
                .viewFromNodeWithBBox(new Rectangle(30, 45, Color.BLUE))
                .with(physics)
                .with(new CollidableComponent(true))
                .with(new PlayerTwoControls())
                .build();
    }




}
