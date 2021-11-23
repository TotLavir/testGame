package com.test.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.test.game.control.PlatformControl;

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
}
