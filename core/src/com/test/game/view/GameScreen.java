package com.test.game.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.test.game.Background;
import com.test.game.Player;

public class GameScreen implements Screen {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Background bg;
    private Player player;

    public static float deltaCff;

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 1024);

        batch = new SpriteBatch();
        bg = new Background();
        player = new Player(new Vector2(camera.viewportWidth/2, 0));
    }

    @Override
    public void render(float delta) {
        System.out.println("delta: " + delta);
        update();
        ScreenUtils.clear(0, 0, 0, 1);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        bg.render(batch);
        player.render(batch);
        batch.end();
    }

    private void update() {
        if (player.getPos().y > camera.viewportHeight/2) {
            camera.position.set(camera.viewportWidth/2, player.getPos().y, 0);
        }

        bg.setCurrentPlayerPosition(player.getPos());

        bg.update();
        player.update();
        camera.update();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
