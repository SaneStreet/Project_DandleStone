package com.dandlestone;

import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.component.CollidableComponent;
import com.almasb.fxgl.entity.component.HealthComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;

@SetEntityFactory
public class AppDandleStoneFactory implements EntityFactory {

    @Spawns("project")
    public Entity newproject(SpawnData data){
        return Entities.builder()
                .build();
    }

    //spawn Platforms
    @Spawns("platform")
    public Entity newplatform(SpawnData data) {
        return Entities.builder()
                .type(DandlesStoneType.PLATFORM)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

    //spawns invisible walls
    @Spawns("wall")
    public Entity newwall(SpawnData data) {
        return Entities.builder()
                .type(DandlesStoneType.WALL)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .build();
    }

    //spawns invisible ceiling
    @Spawns("ceiling")
    public Entity newceiling(SpawnData data) {
        return Entities.builder()
                .type(DandlesStoneType.CEILING)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"),data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .with(new CollidableComponent(true))
                .build();
    }

    //spawns invisible bottom
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

    //spawns Player One
    @Spawns("playerOne")
    public Entity newPlayer1(SpawnData data){
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);

        return Entities.builder()
                .type(DandlesStoneType.PLAYER)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(137/3,49)))
                //.viewFromNodeWithBBox(new Rectangle(30, 45, Color.BLUE))
                .with(physics)
                .with(new CollidableComponent(true))
                .with(new PlayerOneControls())
                .with(new HealthComponent(3))
                .build();
    }

    //spawns Player Two
    @Spawns("playerTwo")
    public Entity newPlayer2(SpawnData data){
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);

        return Entities.builder()
                .type(DandlesStoneType.PLAYER)
                .from(data)
                .bbox(new HitBox(BoundingShape.box(137/3,49)))
                //.viewFromNodeWithBBox(new Rectangle(30, 45, Color.BLUE))
                .with(physics)
                .with(new CollidableComponent(true))
                .with(new PlayerTwoControls())
                .with(new HealthComponent(5))
                .build();
    }
}
