package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.Screens.ScrMenu;
import com.mygdx.game.Screens.ScrPlay;
import com.mygdx.game.Screens.ScrGameover;

public class MenuMain extends Game {
    ScrMenu scrMenu;
    ScrPlay scrPlay;
    ScrGameover scrGameover;

    public enum GameState {
        MENU, PLAY, OVER
    }

    public GameState currentState;

    public void updateState() {
        if (currentState == GameState.MENU) {
            setScreen(scrMenu);
        } else if (currentState == GameState.PLAY) {
            setScreen(scrPlay);
        } else if (currentState == GameState.OVER) {
            setScreen(scrGameover);
        }
    }

    @Override
    public void create() {
        scrMenu = new ScrMenu(this);
        scrPlay = new ScrPlay(this);
        scrGameover = new ScrGameover(this);
        currentState = GameState.MENU;
        updateState();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}