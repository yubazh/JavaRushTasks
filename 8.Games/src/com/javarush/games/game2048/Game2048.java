package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];



    @Override
    public void initialize() {

        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                setCellColor(j, i, Color.AQUA);
            }
        }
    }

    private void createNewNumber() {
        int x, y;
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        } while (gameField[x][y] != 0);
        int number =  (getRandomNumber(10) == 0) ? 4 : 2;
        gameField[x][y] = number;
    }
}
