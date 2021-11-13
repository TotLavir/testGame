package com.test.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {
    private boolean currentBackgroundFlag = false;
    private Vector2 currentPlayerPosition = new Vector2();
    private final InsideBackground[] backgrounds = new InsideBackground[2];

    public Background() {
        backgrounds[0] = new InsideBackground(new Vector2(0, 0));
        backgrounds[1] = new InsideBackground(new Vector2(0, 1024));
    }

    public void setCurrentPlayerPosition(Vector2 currentPlayerPosition) {
        this.currentPlayerPosition = currentPlayerPosition;
    }

    public void render(SpriteBatch batch) {
        for (InsideBackground background : backgrounds) {
            batch.draw(background.bg, background.pos.x, background.pos.y);
        }
    }

    public void update() {
        int currentBackground = currentBackgroundFlag ? 1 : 0;
        if (currentPlayerPosition.y != 0 && currentPlayerPosition.y % 512 == 0) {
            backgrounds[currentBackground].pos.y += 2048;
        }
    }

    class InsideBackground {
        private final Texture bg;
        private Vector2 pos;

        InsideBackground(Vector2 position) {
            this.bg = new Texture("background.png");
            this.pos = position;
        }
    }
}
