package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;
import com.javarush.engine.cell.Color;

import java.awt.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private boolean isUpPressed, isLeftPressed, isRightPressed ;

    @Override
    public void onTurn(int step) {
        rocket.move(isUpPressed, isLeftPressed, isRightPressed);
        drawScene();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if(x >= 0 && x < (WIDTH-1) && y >= 0 && y < (HEIGHT-1)){
            super.setCellColor(x,y,color);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.UP) {
            isUpPressed = false;
        } else
        {
            if (key == Key.LEFT) {
                isLeftPressed = false;
            } else {
                if (key == Key.RIGHT) {
                    isRightPressed = false;
                }
            }
        }
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.UP) isUpPressed = true;
        else {
            if (key == Key.LEFT) {
                isLeftPressed = true;
                isRightPressed = false;
            } else
            {
                if (key == Key.RIGHT) {
                    isRightPressed = true;
                    isLeftPressed = false;
                }
            }
        }
    }

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
        showGrid(false);
    }

    private void createGame() {
        createGameObjects();
        drawScene();
        setTurnTimer(50);
        isLeftPressed = false;
        isRightPressed = false;
        isUpPressed = false;
    }

    private void drawScene() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                setCellColor(i, j, Color.BLACK);
            }
        }
        landscape.draw(this);
        rocket.draw(this);
    }

    private void createGameObjects() {
        rocket = new Rocket(WIDTH / 2, 0);
        landscape = new GameObject(0, 25, ShapeMatrix.LANDSCAPE);
    }
}
