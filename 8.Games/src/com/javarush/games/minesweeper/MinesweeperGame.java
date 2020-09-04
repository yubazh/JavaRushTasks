package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField, countFlags, score;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;

    private void openTile(int x, int y) {
        if ((gameField[y][x].isOpen) || (gameField[y][x].isFlag) || (isGameStopped)) { return; }
        else {
            if (!gameField[y][x].isOpen) {
                gameField[y][x].isOpen = true;
                countClosedTiles--;
                setCellColor(x, y, Color.GREEN);
                if (gameField[y][x].isMine) {
                    setCellValueEx(x, y, Color.RED, MINE);
                    gameOver();
                } else {
                    if (countClosedTiles == countMinesOnField) { win(); }
                    score += 5;
                    setScore(score);
                    if (gameField[y][x].countMineNeighbors == 0) {
                        setCellValue(x, y, "");
                        for (GameObject gameObj : getNeighbors(gameField[y][x])) {
                            if (!gameField[gameObj.y][gameObj.x].isOpen) {
                                openTile(gameObj.x, gameObj.y);
                            }
                        }
                    } else {
                        setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                    }
                }
            }
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
        } else {
            openTile(x, y);
        }
    }

    private void markTile(int x, int y) {
        if (isGameStopped) { return; }
        GameObject gameObj = gameField[y][x];
        if (gameObj.isOpen) { return; }
        if ((countFlags == 0) & (gameObj.isFlag == false)) { return; }
        if (!gameObj.isFlag) {
            gameObj.isFlag = true;
            countFlags--;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        } else
        {
            gameObj.isFlag = false;
            countFlags++;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int x = 0; x < SIDE; x++) {
            for (int y = 0; y < SIDE; y++) {
                setCellValue(x, y, "");
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
        //isGameStopped = false;
    }

    private void countMineNeighbors() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (!gameField[j][i].isMine) {
                    List<GameObject> neighboors = getNeighbors(gameField[j][i]);
                    int count = 0;
                    for (GameObject iter : neighboors) {
                        if (iter.isMine) count++;
                    }
                    gameField[j][i].countMineNeighbors = count;
                }
            }
        }
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.CORAL, "Game Over", Color.RED, 40);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.GREENYELLOW, "CONGRATULATIONS", Color.AQUAMARINE, 40);
    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        setScore(score);
        countMinesOnField = 0;
        createGame();

    }
}