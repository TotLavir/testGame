package com.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import static com.test.game.view.GameScreen.deltaCff;

public class Player {
    private final Texture skin;
    private final Vector2 pos;
    private float prePosY;
    private float vy;
    private final float gravity;
    private final float jumpHeight;
    private enum State{
        IDLE, JUMP, CRUSH
    }
    private State state;

    public Player(Vector2 position) {
        skin = new Texture("brush.png");
        pos = position;
        state = State.IDLE;
        vy = 0;
        gravity = -0.7F;
        jumpHeight = 100F;
    }

    public void render(SpriteBatch batch) {
        batch.draw(skin, pos.x, pos.y);
    }

    public Vector2 getPos() {
        return pos;
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.justTouched()) {
            state = State.JUMP;
            prePosY = pos.y;
            vy = 0;
        }

        switch (state) {
            case CRUSH:
                if (vy >= -15F) {
                    vy += gravity;
                }
                pos.y += vy;
                break;
            case JUMP:
                pos.y += 5F;
                //System.out.println("prePos: "+ prePosY + " Pos: "+pos.y);
                if (pos.y > prePosY+jumpHeight) {
                    state = State.CRUSH;
                }
                break;
            default:
                break;
        }
    }
}
