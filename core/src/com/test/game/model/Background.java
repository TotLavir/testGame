package com.test.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.test.game.control.BackControl;

public class Background extends  GameObject{
    private BackControl backControl;
    private Rectangle playerBounds;

    public Background(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height * ((float)texture.getHeight() / (float)texture.getWidth()));
        backControl = new BackControl(bounds, playerBounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        backControl.handle();
    }

    public void setPlayerBounds(Rectangle playerBounds) {
        this.playerBounds = playerBounds;
    }
}
