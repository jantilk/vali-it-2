package ee.bcs.valiit;

import java.util.Scanner;

public class Lesson1MathUtil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        //int o = scanner.nextInt();
        //int p = scanner.nextInt();

        //Küsib funktsiooni


        //küsi lõpus kas tahad uuesti proovida
        Boolean uuesti = true;

        while (uuesti) {
            System.out.println("Sisesta valik: min, max, abs, paaris, min3, max3");
            String rida = scanner.nextLine();

            //Küsib vajalikke arve
            if (rida.equals("min")) {
                System.out.println("Sisesta kaks täisarvu:");
                int n = scanner.nextInt();
                int o = scanner.nextInt();
                System.out.println("min = " + min(n, o));
            } else if (rida.equals("max")) {
                System.out.println("Sisesta kaks täisarvu:");
                int n = scanner.nextInt();
                int o = scanner.nextInt();
                System.out.println("max = " + max(n, o));
            } else if (rida.equals("abs")) {
                System.out.println("Sisesta üks täisarv:");
                int n = scanner.nextInt();
                System.out.println("abs = " + abs(n));
            } else if (rida.equals("paaris")) {
                System.out.println("Sisesta paaris või paaritu arv:");
                int n = scanner.nextInt();
                System.out.println("paaris = " + isEven(n));
            } else if (rida.equals("min3")) {
                System.out.println("Sisesta kolm täisarvu:");
                int n = scanner.nextInt();
                int o = scanner.nextInt();
                int p = scanner.nextInt();
                System.out.println("min3 = " + min(n, o, p));
            } else if (rida.equals("max3")) {
                System.out.println("Sisesta kolm täisarvu:");
                int n = scanner.nextInt();
                int o = scanner.nextInt();
                int p = scanner.nextInt();
                System.out.println("max3 = " + max(n, o, p));
            } else {
                System.out.println("proovi uuesti");
            }

            System.out.println("Kas tahad uuesti proovida: jah, ei");
            scanner.nextLine();
            String newTry = scanner.nextLine();
            if (newTry.equals("jah")) {
                uuesti = true;
            } else {
                uuesti = false;
            }

        }






        //System.out.println("isEven = " + isEven(n));
        //System.out.println("min3 = " + min(1,1,3));
        //System.out.println("max3 = " + max(1,3,3));



    }



    public static int min(int a, int b){


        // TODO tagasta a ja b väikseim väärtus
        int minValue;
        if (a<b) {
            minValue = a;
        } else {
            minValue = b;
        }
        return minValue;
    }

    public static int max(int a, int b){
        // TODO tagasta a ja b suurim väärtus
        int maxValue;
        if (a>b) {
            maxValue = a;
        } else {
            maxValue = b;
        }
        return maxValue;
    }

    public static int abs(int a){
        // TODO tagasta a absoluut arv
        int absoluutArv;
        if (a>0) {
            absoluutArv = a;
        } else {
            absoluutArv = a * -1;
        }
        return absoluutArv;
    }

    public static boolean isEven(int a){
        // TODO tagasta true, kui a on paaris arv
        if (a%2 == 0) {
            return true;
        } else {
            // tagasta false kui a on paaritu arv
            return false;
        }
    }

    public static int min(int a, int b, int c){
        // TODO tagasta a, b ja c väikseim väärtus
        int minValue;
        if (a<=b && a<=c) {
            minValue = a;
        } else if (b<=a && b<=c) {
            minValue = b;
        } else {
            minValue = c;
        }
        return minValue;
    }

    public static int max(int a, int b, int c){
        // TODO tagasta a, b ja c suurim väärtus
        int maxValue;
        if (a>=b && a>=c) {
            maxValue = a;
        } else if (b>=a && b>=c) {
            maxValue = b;
        } else {
            maxValue = c;
        }
        return maxValue;
    }

}
