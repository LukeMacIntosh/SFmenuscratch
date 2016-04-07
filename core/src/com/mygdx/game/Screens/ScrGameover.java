package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
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
public class ScrGameover implements Screen {
    MenuMain menuMain;
    Stage stage;
    TextButton button;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    TextureAtlas buttonAtlas;

    public ScrGameover(MenuMain menuMain) {  //Referencing the main class.
        this.menuMain = menuMain;
    }

    public void create() {
        stage = new Stage();
        font = new BitmapFont();
        Gdx.input.setInputProcessor(stage);
        btnSkin();
        button = new TextButton("SCREEN 1", textButtonStyle);
        button.setSize(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 4);
        button.setPosition(0, 0);
        stage.addActor(button);
    }

    //@Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1); //black background.
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        if (button.isPressed()) {
            menuMain.currentState = MenuMain.GameState.MENU;
            menuMain.updateState();
        }
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

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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
}