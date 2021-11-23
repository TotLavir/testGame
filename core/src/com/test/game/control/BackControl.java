package com.test.game.control;

import com.badlogic.gdx.math.Rectangle;
import com.test.game.view.GameScreen;

public class BackControl {
    private Rectangle backgroundBounds;

    public BackControl(Rectangle backgroundBounds) {
        this.backgroundBounds = backgroundBounds;
    }

    public void handle() {
        if (GameScreen.player.getBounds().getY() >= (backgroundBounds.getY() + (backgroundBounds.getHeight() + backgroundBounds.getHeight() / 2))) {
            backgroundBounds.y += backgroundBounds.getHeight() * 2;
        }
    }
}
