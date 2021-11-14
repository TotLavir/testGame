package com.test.game.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
import com.test.game.model.Background;
import com.test.game.model.Player;

public class GameScreen implements Screen {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Background background;
    private Texture textureBackground;
    private Player player;
    private Texture texturePlayer;

    private ShapeRenderer debug = new ShapeRenderer();

    @Override
    public void show() {
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        textureBackground = new Texture("background.png");
        texturePlayer = new Texture("brush.png");
        background = new Background(textureBackground, -1f, -1f, 13f, 19f);
        player = new Player(texturePlayer, (background.getBounds().getWidth()-2) / 2, 0, 1f, 2f);
    }

    @Override
    public void render(float delta) {
        update();
        ScreenUtils.clear(0, 0, 0, 1);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        background.draw(batch);
        player.draw(batch);
        batch.end();
        drawDebug();
    }

    private void update() {
        if(player.getBounds().getY() > background.getBounds().getHeight() / 2) {
            camera.position.set((background.getBounds().getWidth()-2) / 2, player.getBounds().getY(), 0);
            camera.update();
        }
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
        for (float i = background.getBounds().getY(); i < background.getBounds().getHeight(); i++) {
            debug.rect(background.getBounds().getX(), i, background.getBounds().getWidth(), i);
        }
        debug.rect(background.getBounds().getX(), background.getBounds().getY(),
                background.getBounds().getWidth(), background.getBounds().getHeight());
        debug.rect(player.getBounds().getX(), player.getBounds().getY(),
                    player.getBounds().getWidth(), player.getBounds().getHeight());
        debug.end();
    }
}
