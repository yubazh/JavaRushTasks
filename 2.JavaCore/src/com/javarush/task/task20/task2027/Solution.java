package com.javarush.task.task20.task2027;

import java.util.*;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> listWord = detectAllWords(crossword, "home", "same");
        System.out.println(listWord);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> retur = new ArrayList<>();

        for (String word : words) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    if (crossword[i][j] == word.charAt(0)) {
                        if (proverka1(crossword, i, j, word)) {
                            Word wordObj = new Word(word);
                            wordObj.setStartPoint(j, i);
                            wordObj.setEndPoint(j - 3, i - 3);
                            retur.add(wordObj);
                            }
                        if (proverka2(crossword, i, j, word)) {
                            Word wordObj = new Word(word);
                            wordObj.setStartPoint(j, i);
                            wordObj.setEndPoint(j - 3, i);
                            retur.add(wordObj);
                        }
                        if (proverka3(crossword, i, j, word)) {
                            Word wordObj = new Word(word);
                            wordObj.setStartPoint(j, i);
                            wordObj.setEndPoint(j - 3, i + 3);
                            retur.add(wordObj);
                        }
                        if (proverka4(crossword, i, j, word)) {
                            Word wordObj = new Word(word);
                            wordObj.setStartPoint(j, i);
                            wordObj.setEndPoint(j, i + 3);
                            retur.add(wordObj);
                        }
                        if (proverka5(crossword, i, j, word)) {
                            Word wordObj = new Word(word);
                            wordObj.setStartPoint(j, i);
                            wordObj.setEndPoint(j + 3, i + 3);
                            retur.add(wordObj);
                        }
                        if (proverka6(crossword, i, j, word)) {
                            Word wordObj = new Word(word);
                            wordObj.setStartPoint(j, i);
                            wordObj.setEndPoint(j + 3, i);
                            retur.add(wordObj);
                        }
                        if (proverka7(crossword, i, j, word)) {
                            Word wordObj = new Word(word);
                            wordObj.setStartPoint(j, i);
                            wordObj.setEndPoint(j + 3, i - 3);
                            retur.add(wordObj);
                        }
                        if (proverka8(crossword, i, j, word)) {
                            Word wordObj = new Word(word);
                            wordObj.setStartPoint(j, i);
                            wordObj.setEndPoint(j, i - 3);
                            retur.add(wordObj);
                        }
                    }
                }
            }

        }

        return retur;
    }

    public static boolean proverka1(int[][] crossword, int x, int y, String word) {
        if ((x < 3) || (y < 3)) {
            return false;
        } else {
            String word1 = null;
            word1 = Character.toString((char) crossword[x][y]) + Character.toString((char) crossword[x - 1][y - 1]) + Character.toString((char) crossword[x - 2][y - 2]) + Character.toString((char) crossword[x - 3][y - 3]);
            if (word.equals(word1)) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static boolean proverka2(int[][] crossword, int x, int y, String word) {
        if ((x < 0) || (y < 3)) {
            return false;
        } else {
            String word1 = null;
            word1 = Character.toString((char) crossword[x][y]) + Character.toString((char) crossword[x - 1][y]) + Character.toString((char) crossword[x - 2][y]) + Character.toString((char) crossword[x - 3][y]);
            if (word.equals(word1)) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static boolean proverka3(int[][] crossword, int x, int y, String word) {
        if ((x < 3) || (y > 2)) {
            return false;
        } else {
            String word1 = null;
            word1 = Character.toString((char) crossword[x][y]) + Character.toString((char) crossword[x - 1][y + 1]) + Character.toString((char) crossword[x - 2][y + 2]) + Character.toString((char) crossword[x - 3][y + 3]);
            if (word.equals(word1)) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static boolean proverka4(int[][] crossword, int x, int y, String word) {
        if (y > 2) {
            return false;
        } else {
            String word1 = null;
            word1 = Character.toString((char) crossword[x][y]) + Character.toString((char) crossword[x][y + 1]) + Character.toString((char) crossword[x][y + 2]) + Character.toString((char) crossword[x][y + 3]);
            if (word.equals(word1)) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static boolean proverka5(int[][] crossword, int x, int y, String word) {
        if ((x > 1) || (y > 2)) {
            return false;
        } else {
            String word1 = null;
            word1 = Character.toString((char) crossword[x][y]) + Character.toString((char) crossword[x + 1][y + 1]) + Character.toString((char) crossword[x + 2][y + 2]) + Character.toString((char) crossword[x + 3][y + 3]);
            if (word.equals(word1)) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static boolean proverka6(int[][] crossword, int x, int y, String word) {
        if (x > 1) {
            return false;
        } else {
            String word1 = null;
            word1 = Character.toString((char) crossword[x][y]) + Character.toString((char) crossword[x + 1][y]) + Character.toString((char) crossword[x + 2][y]) + Character.toString((char) crossword[x + 3][y]);
            if (word.equals(word1)) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static boolean proverka7(int[][] crossword, int x, int y, String word) {
        if ((x > 1) || (y < 3)) {
            return false;
        } else {
            String word1 = null;
            word1 = Character.toString((char) crossword[x][y]) + Character.toString((char) crossword[x + 1][y - 1]) + Character.toString((char) crossword[x + 2][y - 2]) + Character.toString((char) crossword[x + 3][y - 3]);
            if (word.equals(word1)) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public static boolean proverka8(int[][] crossword, int x, int y, String word) {
        if (y < 3) {
            return false;
        } else {
            String word1 = null;
            word1 = Character.toString((char) crossword[x][y]) + Character.toString((char) crossword[x][y - 1]) + Character.toString((char) crossword[x][y - 2]) + Character.toString((char) crossword[x][y - 3]);
            if (word.equals(word1)) {
                return true;
            }
            else {
                return false;
            }
        }
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
