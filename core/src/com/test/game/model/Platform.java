package com.test.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.test.game.control.PlatformControl;
import static com.badlogic.gdx.math.MathUtils.round;

public class Platform extends GameObject{
    private PlatformControl platformControl;

    public Platform(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        platformControl = new PlatformControl(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        platformControl.handle();
    }

    public boolean onPlatform(Vector2 pos) {
        System.out.println("PositionY platform: " + (bounds.getY() + bounds.getHeight()));
        System.out.println("PositionY player: " + round(pos.y));
        return ((bounds.getY() + bounds.getHeight()) == round(pos.y)) && ((bounds.getX() <= pos.x) && (pos.x <= (bounds.getX() + bounds.getWidth())));
    }
}
