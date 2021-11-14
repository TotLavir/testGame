package com.test.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.test.game.control.PlayerControl;

public class Player extends GameObject{
    private PlayerControl playerControl;

    public Player(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height * ((float)texture.getHeight() / (float)texture.getWidth()));
        playerControl = new PlayerControl(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        playerControl.handle();
    }
}
