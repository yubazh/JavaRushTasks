package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;
    private static final int GOAL = 28;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }



    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive) {
            createNewApple();
            score += 5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
        }
        if (!snake.isAlive) gameOver();
        if (snake.getLength() > GOAL) win();
        drawScene();

    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case RIGHT: {
                snake.setDirection(Direction.RIGHT);
                break;
            }
            case LEFT: {
                snake.setDirection(Direction.LEFT);
                break;
            }
            case DOWN: {
                snake.setDirection(Direction.DOWN);
                break;
            }
            case UP: {
                snake.setDirection(Direction.UP);
                break;
            }
            case SPACE: {
                if (isGameStopped) createGame();
                break;
            }
        }
    }

    private void createGame() {
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        //apple = new Apple(5, 5);
        createNewApple();
        isGameStopped = false;
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);
        //Apple apple = new Apple(7,7);
        //apple.draw(this);
        score = 0;
        setScore(score);
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    private void createNewApple() {
        apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        while (snake.checkCollision(apple)) apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));

    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.CORAL, "Game over!", Color.RED, 40);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.CORAL, "Congratulations!", Color.GREEN, 40);
    }
}
