package ee.bcs.valiit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lesson3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //sum(1, 1);

        //int[] x = {1,2,3,4,5};
        //sum(x);

        //factorial(5);

        //int[] a = {2, 6, 8, 1};
        //sort(a);

        reverseString("Telefon");

        //int a = 7;
        //isPrime(a);

    }

    public static int sum(int x, int y) {
        // TODO liida kokku ja tagasta x ja y väärtus
        int total = x + y;
        System.out.println(total);

        return total;
    }

    public static int sum(int[] x) {
        // Todo liida kokku kõik numbrid massivis x
        int total = 0;
        for (int i = 0; i < x.length; i++) {
            total = total + x[i];
        }
        System.out.println(total);

        return total;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        int factSum = 1;
        int startPoint = x-1;
        int[] arrFact = new int[startPoint];

        for (int i = 0; i < arrFact.length; i++) {
            arrFact[i] = startPoint;
            factSum = factSum * startPoint;
            startPoint--;
        }
        System.out.println(factSum);
        // Näiteks
        // x = 5
        // return 4*3*2*1 = 24
        return factSum;
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi
        int temp = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j <a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        // Näiteks {2, 6, 8, 1}
        // Väljund {1, 2, 6, 8}
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        return a;
    }

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        String temp = "";
        int size = a.length();

        for (int i = size; i >= 1; i--) {
            temp = temp + a.substring(i-1,i);
        }

        // Näiteks:
        // a = "Test";
        // return tseT";
        System.out.println(temp);
        return temp;
    }

    public static boolean isPrime(Integer x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        boolean check;
        List<Integer> notPrime = new ArrayList<>();

        for (int i = 1; i < x; i++) {
            if (x/x != 1 && x%i == 0) {
                notPrime.add(i);
            }
        }

        for (int i = 0; i < x; i++) {
            if (x % notPrime.get(i) != 0 && x/x == 1) {
                check = true;
            }
        }
        check = false;

        System.out.println(check);
        return check;
    }

}
