package old.Lessons;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Lesson2 {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        //exercise1();
        //exercise2(4);
        //multiplication(2, 5);
        //fibonacci(6);
        //exercise5();
        //exercise6();
        //exercise7();
        //exercise8();
    }

    public static void exercise1() {
        // TODO loo 10 elemendile täisarvude massiv
        int[] arr = new int[10];
        // TODO loe sisse konsoolist 10 täisarvu
        for (int i = 0; i < 10; i++) {
            int n = scanner.nextInt();
            arr[i] = n;
        }
        // TODO trüki arvud välja vastupidises järiekorras
        int size = arr.length;
        for (int i = size-1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void exercise2(int x) {
        // TODO prindi välja x esimest paaris arvu
        int n = scanner.nextInt();
        for (int i = 2; i<=n*2; i = i + 2) {
           System.out.println(i);
        }
        // Näide:
        // Sisend 5
        // Väljund 2 4 6 8 10
    }

    public static String xyTable(int x, int y) {
        List<String> xyTable = new ArrayList<>();
        // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
        String result = "";
        for (int i = 1; i <=x; i++) {
            for (int j = 1; j <= y; j++) {
                xyTable.add(i*j + " ");
                result = result + (i*j) + " ";
            }
            System.out.println();
            result += "<br/>\n";
        }
        return result;
        // TODO näiteks x = 3 y = 3
        // TODO väljund
        // 1 2 3
        // 2 4 6
        // 3 6 9
    }

    public static int fibonacci(int n) {
        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;

        // TODO
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);

        if (n == 1) {
            System.out.println(fib[0]);
        } else if (n == 2) {
            System.out.println(fib[1]);
        } else {
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i-2] + fib[i-1];
            }
            System.out.println(fib[n-1]);
        }
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        // Tagasta fibonacci jada n element
        return fib[n-1];
    }

    public static String algorithm(int x, int y) {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36

        // Sisend kaks täisarvu
        // display input
        System.out.println(x + " " + y);

        // result array init
        int[] arr = new int[y - x + 1];
        // result array index init
        int arrIndex = 0;
        // clone of input i
        int iClone = x;
        // arrItemCorrector
        int corrector = 0;

        for (int k = x; k <= y; k++) {
            // add 1 to cycle length counter
            int cycleLengthCounter = 1;
            // algorithm itself
            while (x != 1) {
                if (x % 2 != 0) {
                    x = 3 * x + 1;
                } else {
                    x = x / 2;
                }
                cycleLengthCounter++;
            }
            // adding cycle length into the array
            arr[arrIndex] = cycleLengthCounter;
            arrIndex++;
            corrector++;
            // getting the next number to calculate
            x = iClone + corrector;
        }

        // calculating the length of the biggest cycle
        int arrSize = arr.length;
        int maxCycle = 0;
        for (x = 0; x < arrSize; x++) {
            if (arr[x] > maxCycle) {
                maxCycle = arr[x];
            }
        }

        // display output
        String result = (iClone + " " + y + " " + maxCycle);
        return result;
    }

    public static void exercise6() {
        /*
            Kirjutada Java programm, mis loeb failist visits.txt sisse looduspargi külastajad erinevatel jaanuari päevadel ning
            a) sorteerib külastuspäevad külastajate arvu järgi kasvavalt ning prindib tulemuse konsoolile;
            b) prindib konsoolile päeva, mil külastajaid oli kõige rohkem.
            Faili asukoht tuleb programmile ette anda käsurea parameetrina.
         */
        HashMap<String, Integer> visitMap = new HashMap<>();

        try {
            File visits = new File("C:\\Users\\Public\\visits.txt");
            Scanner fileScanner = new Scanner(visits);
            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine();
                visitMap.put(data.substring(0, 10), parseInt(data.substring(12, 15)));
                System.out.println(data);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        System.out.println(visitMap);
    }

    public static void exercise7() {
        // TODO arvuta kasutades BigDecimali 1.89 * ((394486820340 / 15 ) - 4 )
        BigDecimal a = new BigDecimal(1.89);
        BigDecimal b = new BigDecimal("394486820345");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");
        BigDecimal result = a.multiply((b.multiply(c)).subtract(d));

        System.out.println(result);

    }

    public static void exercise8() {
        /*
        Failis nums.txt on üksteise all 150 60-kohalist numbrit.

        Kirjuta programm, mis loeks antud numbrid failist sisse ja liidaks need arvud kokku ning kuvaks ekraanil summa.
        Faili nimi tuleb programmile ette anda käsurea parameetrina.

        VASTUS:
        Õige summa: 77378062799264987173249634924670947389130820063105651135266574
         */
    }

    public static void exercise9() {
        /* TODO
        Sama mis eelmises ülesandes aga ära kasuta BigInt ega BigDecimal klassi
         */
    }

}


