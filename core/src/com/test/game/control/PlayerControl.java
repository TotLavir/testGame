package com.test.game.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.test.game.view.GameScreen;

public class PlayerControl {
    private enum State {
        CRUSH, IDLE, JUMP

    }

    private Rectangle playerBounds;
    private Vector2 position;
    private float vy;
    private float speed;
    private final float gravity;
    private final float jumpHeight;
    private State state;

    public PlayerControl(Rectangle playerBounds) {
        this.playerBounds = playerBounds;
        position = new Vector2((playerBounds.getX() + playerBounds.getWidth()) / 2, playerBounds.y);
        state = State.IDLE;
        jumpHeight = 5f;
        gravity = 9f;
        speed = 0.1f;
        vy = 0;
    }

    public void handle() {
        if ((Gdx.input.isKeyPressed(Input.Keys.SPACE) || Gdx.input.justTouched()) && state != State.JUMP) {
            state = State.JUMP;
        }
        if (state == State.CRUSH && GameScreen.yellowPlatform.onPlatform(playerBounds.getPosition(position)) || GameScreen.bluePlatform.onPlatform(playerBounds.getPosition(position)) || GameScreen.redPlatform.onPlatform(playerBounds.getPosition(position))) {
            state = State.IDLE;
        }

        vy -= gravity * Gdx.graphics.getDeltaTime();
        switch (state) {
            case IDLE:
                vy = 0;
                break;
            case CRUSH:
                if (vy <= -20F) {
                    vy = -20F;
                }
                break;
            case JUMP:
                vy = (float) Math.sqrt(2*jumpHeight*gravity);
                state = State.CRUSH;
                break;
            default:
                break;
        }

        playerBounds.y += vy * Gdx.graphics.getDeltaTime();
    }
}
