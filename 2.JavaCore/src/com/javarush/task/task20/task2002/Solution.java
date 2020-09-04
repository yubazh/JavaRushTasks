package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("C:\\test.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user01 = new User();
            user01.setFirstName("Vanya");
            user01.setLastName("Petrov");
            user01.setMale(true);
            user01.setCountry(User.Country.RUSSIA);
            Date date = new Date();
            user01.setBirthDate(date);
            javaRush.users.add(user01);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject)) {
                System.out.println("равны");
            }
            else {
                System.out.println("не равны");
            }


            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            String isUsersEmpty = users.isEmpty() == true ? "yes" : "no";
            writer.println(isUsersEmpty);
            writer.flush();
            if (users.isEmpty() == false) {
                for (User user : users) {
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println(user.getBirthDate().getTime());
                    writer.println(user.isMale());
                    writer.println(user.getCountry());
                    writer.flush();
                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String isUsersEmpty = reader.readLine();
            if (isUsersEmpty.equals("no")) {
                String line;
                while ((line = reader.readLine()) != null) {
                    User user = new User();
                    String name = line;
                    user.setFirstName(name);
                    String lastName = reader.readLine();
                    user.setLastName(lastName);
                    String date = reader.readLine();
                    Long longdate = Long.parseLong(date);
                    Date birthDate = new Date(longdate);
                    user.setBirthDate(birthDate);
                    String male = reader.readLine();
                    if (male.equals("true")) {
                        user.setMale(true);
                    }
                    if (male.equals("false")) {
                        user.setMale(false);
                    }
                    String country = reader.readLine();
                    if (country.equals("UKRAINE")) {
                        user.setCountry(User.Country.UKRAINE);
                    }
                    if (country.equals("RUSSIA")) {
                        user.setCountry(User.Country.RUSSIA);
                    }
                    if (country.equals("OTHER")) {
                        user.setCountry(User.Country.OTHER);
                    }
                    users.add(user);
                }

            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
