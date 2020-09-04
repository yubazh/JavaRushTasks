package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {

        out.defaultWriteObject();
        out.writeObject(fileName);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution("C:\\test.txt");
        solution.writeObject("stroka");
        solution.close();
        FileOutputStream fOS = new FileOutputStream("C:\\test1.txt");
        ObjectOutputStream oOS = new ObjectOutputStream(fOS);
        oOS.writeObject(solution);
        oOS.flush();
        oOS.close();

        FileInputStream fIS = new FileInputStream("C:\\test1.txt");
        ObjectInputStream oIS = new ObjectInputStream(fIS);
        Solution solution1 = (Solution) oIS.readObject();
        oIS.close();
        solution1.writeObject("stroka2");


    }
}
