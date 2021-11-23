package com.test.game.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
import com.test.game.control.BackControl;
import com.test.game.model.Background;
import com.test.game.model.Player;

public class GameScreen implements Screen {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    public static Background[] background = new Background[2];
    private Texture textureBackground;
    public static Player player;
    private Texture texturePlayer;

    private ShapeRenderer debug = new ShapeRenderer();

    @Override
    public void show() {
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        textureBackground = new Texture("background.png");
        texturePlayer = new Texture("brush.png");
        background[0] = new Background(textureBackground, -1f, -1f, 13f, 19f);
        background[1] = new Background(textureBackground, -1f, -1f + background[0].getBounds().getHeight(),
                13f, 19f);
        player = new Player(texturePlayer, (background[0].getBounds().getWidth()-2) / 2, 0, 1f, 2f);
    }

    @Override
    public void render(float delta) {
        update();
        ScreenUtils.clear(0, 0, 0, 1);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        background[0].draw(batch);
        background[1].draw(batch);
        player.draw(batch);
        batch.end();
        //drawDebug();
    }

    private void update() {
        if(player.getBounds().getY() >= background[0].getBounds().getHeight() / 2) {
            camera.position.set((background[0].getBounds().getWidth()-2) / 2, player.getBounds().getY(), 0);
        }
        camera.update();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height/width;
        camera.setToOrtho(false, 11f, 17f * aspectRatio);
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

    private void drawDebug() {
        debug.setProjectionMatrix(camera.combined);
        debug.begin(ShapeType.Line);
        debug.setColor(1f,0,0,0);
        for (float i = background[0].getBounds().getY(); i < background[0].getBounds().getHeight(); i++) {
            debug.rect(background[0].getBounds().getX(), i, background[0].getBounds().getWidth(), i);
        }
        debug.rect(background[0].getBounds().getX(), background[0].getBounds().getY(),
                background[0].getBounds().getWidth(), background[0].getBounds().getHeight());
        debug.rect(player.getBounds().getX(), player.getBounds().getY(),
                    player.getBounds().getWidth(), player.getBounds().getHeight());
        debug.end();
    }
}
