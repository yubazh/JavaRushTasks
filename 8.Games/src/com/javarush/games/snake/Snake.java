package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.games.snake.SnakeGame.HEIGHT;
import static com.javarush.games.snake.SnakeGame.WIDTH;

public class Snake {
    public int x, y;
    public boolean isAlive = true;
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private Direction direction = Direction.LEFT;

    public void setDirection(Direction direction) {
        if ((this.direction == Direction.UP) && (direction == Direction.DOWN)) {
            return;
        } else {
            if ((this.direction == Direction.LEFT) && (direction == Direction.RIGHT)) {
                return;
            } else {
                if ((this.direction == Direction.RIGHT) && (direction == Direction.LEFT)) {
                    return;
                } else {
                    if ((this.direction == Direction.DOWN) && (direction == Direction.UP)) {
                        return;
                    } else {
                        if ((this.direction == Direction.LEFT) && (snakeParts.get(0).x == snakeParts.get(1).x)) {
                            return;
                        } else {
                            if ((this.direction == Direction.RIGHT) && (snakeParts.get(0).x == snakeParts.get(1).x)) {
                                return;
                            } else {
                                if ((this.direction == Direction.UP) && (snakeParts.get(0).y == snakeParts.get(1).y)) {
                                    return;
                                } else {
                                    if ((this.direction == Direction.DOWN) && (snakeParts.get(0).y == snakeParts.get(1).y)) {
                                        return;
                                    } else {
                                        this.direction = direction;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Snake(int x, int y) {
        this.x = x;
        this.y = y;
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void draw(Game game) {
        Color snakeColor;
        if (isAlive) {
            snakeColor = Color.BLACK;
        } else {
            snakeColor = Color.RED;
        }
        for (int i = 0; i < snakeParts.size(); i++) {
            GameObject gameObj = snakeParts.get(i);
            if (i == 0) {
                game.setCellValueEx(gameObj.x, gameObj.y, Color.NONE, HEAD_SIGN, snakeColor, 75);
            } else {
                game.setCellValueEx(gameObj.x, gameObj.y, Color.NONE, BODY_SIGN, snakeColor, 75);
            }
        }
    }

    public void move(Apple apple) {
        GameObject gameObj = createNewHead();
        if ((gameObj.x < 0) || (gameObj.y < 0) || (gameObj.x > (WIDTH - 1)) || (gameObj.y > (HEIGHT - 1))) {
            isAlive = false;
            return;
        } else {
            if ((apple.x == gameObj.x) && (apple.y == gameObj.y)) {
                apple.isAlive = false;
                snakeParts.add(gameObj);
            } else {
                if (checkCollision(gameObj)) {
                    isAlive = false;
                } else {
                    snakeParts.add(0, gameObj);
                    removeTail();
                }

            }
        }

    }

    public GameObject createNewHead() {
        int x = snakeParts.get(0).x;
        int y = snakeParts.get(0).y;
        switch (direction) {
            case UP: y--; break;
            case DOWN: y++; break;
            case LEFT: x--; break;
            case RIGHT: x++; break;
        }
        return new GameObject(x, y);
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject gameObject) {
        for (GameObject gameObj : snakeParts) {
            if ((gameObj.x == gameObject.x) && (gameObj.y == gameObject.y)) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return snakeParts.size();
    }

}
