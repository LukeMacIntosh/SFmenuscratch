package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.MenuMain;

/**
 * Created by luke on 2016-04-05.
 */
public class ScrMenu implements Screen, InputProcessor {
    MenuMain menuMain;
    Stage stage;
    TextButton btnGameover, btnPlay;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;

    public ScrMenu(MenuMain menuMain) {  //Referencing the main class.
        this.menuMain = menuMain;
    }

    public void create() {
        stage = new Stage();
        font = new BitmapFont();
        Gdx.input.setInputProcessor(stage);
        btnSkin();
        btnPlay = new TextButton("PLAY", textButtonStyle);
        btnPlay.setSize(200, 80);
        btnPlay.setPosition(440, 0);
        btnGameover = new TextButton("GAMEOVER", textButtonStyle);
        btnGameover.setSize(200, 80);
        btnGameover.setPosition(0, 0);
        stage.addActor(btnPlay);
        stage.addActor(btnGameover);
        btnPlayListener();
        btnGameoverListener();
    }

    @Override
    public void show() { //This is called when you set the screen to this class.
        create();
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 0, 1); //Green background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    private void btnSkin() {
        skin = new Skin();
        buttonAtlas = new TextureAtlas(Gdx.files.internal("MenuButton.pack")); // stole Matt Beemer's pack file
        skin.addRegions(buttonAtlas);
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("MenuButtonUp");
        textButtonStyle.down = skin.getDrawable("MenuButtonDown");
        textButtonStyle.checked = skin.getDrawable("MenuButtonUp");
    }

    public void btnPlayListener() {
        btnPlay.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                menuMain.currentState = MenuMain.GameState.PLAY;
                menuMain.updateState();
            }
        });
    }

    public void btnGameoverListener() {
        btnGameover.addListener(new ChangeListener() {
            public void changed(ChangeListener.ChangeEvent event, Actor actor) {
                menuMain.currentState = MenuMain.GameState.OVER;
                menuMain.updateState();
            }
        });
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

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}