package com.test.game.control;

import com.badlogic.gdx.math.Rectangle;

public class BackControl {
    private Rectangle backgroundBounds;
    private Rectangle playerBounds;

    public BackControl(Rectangle backgroundBounds, Rectangle playerBounds) {
        this.backgroundBounds = backgroundBounds;
        this.playerBounds = playerBounds;
    }

    public void handle() {
        System.out.println(playerBounds.getY());
        if (playerBounds.getY() >= (backgroundBounds.getHeight() + backgroundBounds.getHeight() / 2)) {
            backgroundBounds = new Rectangle(backgroundBounds.getX(),
                    backgroundBounds.getY() + backgroundBounds.getHeight() * 2, backgroundBounds.getWidth(),
                    backgroundBounds.getHeight());
        }
    }
}
