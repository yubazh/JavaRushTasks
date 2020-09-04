package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {

 /*   public static void main(String[] args) {
        recurse(132);
    } */

   /* public void recurse(int n) {
        int delitel = 2;
        int peredavaemoeChislo;
        while ((n % delitel) != 0) {
            delitel++;
        }
        peredavaemoeChislo = n / delitel;
        System.out.println(delitel);
        if (peredavaemoeChislo == 1) {
            return;
        } else {
            recurse(peredavaemoeChislo);
        }

    } */
   public void recurse(int n) {
       int a = 2;
       while (a <= n) {
           if ((n % a) == 0) {
               if (a != n) {
                   System.out.print(a + " ");
                   recurse(n / a);
               } else {
                   System.out.print(a);
               }
               return;
           }
           a++;
       }
   }


}
