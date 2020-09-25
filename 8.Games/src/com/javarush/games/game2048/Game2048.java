package com.javarush.games.game2048;
import com.javarush.engine.cell.*;

public class Game2048 extends Game{
    private static final int SIDE = 5;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score = 0;

    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }
    private void createGame(){
        gameField = new int[SIDE][SIDE];
        score = 0;
        setScore(score);
        createNewNumber();
        createNewNumber();
    }
    private void drawScene(){
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                int value = gameField[j][i];
                setCellColoredNumber(i, j, value);
            }
        }
    }
    private void createNewNumber(){
        if (getMaxTileValue()<2048) {
            int posX = getRandomNumber(SIDE);
            int posY = getRandomNumber(SIDE);
            int rnd = getRandomNumber(10);
            while (gameField[posX][posY] != 0) {
                posX = getRandomNumber(SIDE);
                posY = getRandomNumber(SIDE);
            }
            gameField[posX][posY] = rnd == 9 ? 4 : 2;
        } else {
            win();
        }
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK,"Сам в шоке, но таки да, ПОБЕДА", Color.YELLOW,16);
    }
    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.BLACK,"Старайся лучше!", Color.YELLOW,16);
    }
    private Color getColorByValue(int value){
        switch (value){
            case 2: return Color.DARKBLUE;
            case 4: return Color.BLUE;
            case 8: return Color.YELLOW;
            case 16: return Color.ALICEBLUE;
            case 32: return Color.BEIGE;
            case 64: return Color.BROWN;
            case 128: return Color.CORAL;
            case 256: return Color.CYAN;
            case 512: return Color.DARKGRAY;
            case 1024: return Color.DARKRED;
            case 2048: return Color.RED;
            default: return Color.AQUA;
        }
    }
    private void setCellColoredNumber(int x, int y, int value){
        Color color = getColorByValue(value);
        setCellColor(x, y, color);
        setCellValueEx(x, y, color ,value!=0?Integer.toString(value):"");
    }
    private boolean compressRow(int[] row){
        boolean rezult = false;
        for (int i = 0; i<row.length;i++){
            if(row[i]==0){
                for (int j = i+1; j < row.length; j++) {
                    if (row[j]!=0){
                        int temp = row[i];
                        row[i] = row[j];
                        row[j] = temp;
                        rezult = true;
                        break;
                    }
                }
            }
        }
        return rezult;
    }

    @Override
    public void onKeyPress(Key key) {
        super.onKeyPress(key);
        if (!canUserMove()) {
            gameOver();
        };

        if (isGameStopped){
            if (key==Key.SPACE){
                createGame();
                drawScene();
                isGameStopped = false;
                return;
            }
        } else if (key==Key.LEFT){
            moveLeft();
            drawScene();
        } else if (key==Key.RIGHT){
            moveRight();
            drawScene();
        }else if(key==Key.DOWN){
            moveDown();
            drawScene();
        }else if(key==Key.UP){
            moveUp();
            drawScene();
        }
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
     /*   rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise(); */
    }

    private void moveLeft(){
        /* boolean state = false;
        for (int i = 0; i < gameField.length; i++) {
            boolean b1 = compressRow(gameField[i]);
            boolean b2 = mergeRow(gameField[i]);
            boolean b3 = compressRow(gameField[i]);
            if (b1||b2||b3) {
                state = true;
            }
        }
        if (state) createNewNumber();  */
    }
    private void moveRight(){
      /*  rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise(); */
    }
    private boolean mergeRow(int[] row){
        boolean rezult = false;
        if(row.length==0) return rezult;
        int i=0;
        do{
            if(row[i]==row[i+1]&&row[i]!=0){
                row[i]*=2;
                row[i+1]=0;
                score+=row[i];
                setScore(score);
                rezult=true;
            }
        }while(++i<(row.length-1));
        return rezult;
    }
    private void rotateClockwise(){
        int [][] cloneGameField = new int[SIDE][SIDE];
        for (int i = 0; i < cloneGameField.length; i++) {
            for (int j = 0; j < cloneGameField.length; j++) {
                cloneGameField[i][j] = gameField[SIDE-1-j][i];
            }
        }
        for (int i = 0; i < cloneGameField.length; i++) {
            for (int j = 0; j < cloneGameField.length; j++) {
                gameField[i][j] = cloneGameField[i][j];
            }
        }
    }
    private int getMaxTileValue(){
        int max = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if(gameField[i][j]>max) max = gameField[i][j];
            }
        }
        return max;
    }
    private boolean canUserMove(){
        boolean rezult = false;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j]==0) return true;
            }
        }
        for (int i = 0; i < SIDE-1; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j]==gameField[i+1][j]) return true;
            }
        }

        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE-1; j++) {
                if (gameField[i][j]==gameField[i][j+1]) return true;
            }
        }
        return rezult;
    }
}