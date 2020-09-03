package ee.bcs.valiit.Lessons;

import java.util.Random;
import java.util.Scanner;

// Enne kui seda tegema hakkad tee ära Lesson 2 (välja arvatud ülesanded 6, 8, 9)
public class Lesson3Hard {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //evenFibonacci(10);
        //randomGame();
        morseCode("wow do you do");
    }

    public static int evenFibonacci(int x) {
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21 ...

        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        int xSum = 0;
        int[] fib = new int[x];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < x; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            if (fib[i] % 2 == 0) {
                xSum = xSum + fib[i];
            }
        }

        System.out.println(xSum);
        return xSum;
    }

    public static void randomGame() {
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks

        // random number
        Random random = new Random();
        int i = random.nextInt(100);
        //System.out.println(i);

        int n = 0;
        int j = 0;
        while (n != i) {
            // küsi sisend
            System.out.println("Paku täisarv 1-100");
            n = scanner.nextInt();

            if (n == i && j == 0) {
                System.out.println("ÕIGE!! Ühe korraga?? nojah...");
                return;
            }

            if (n < i) {
                System.out.println("... paku suuremat");
                j++;
            } else if (n > i) {
                System.out.println("... paku väiksemat");
                j++;
            }
        }
        j++;
        System.out.println("Õige! Sul kulus " + j + " käiku!");
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        String[][] morseDB = {
                {"a", ".-"},
                {"b", "-..."},
                {"c", "-.-."},
                {"d", "-.."},
                {"e", "."},
                {"f", "..-."},
                {"g", "--."},
                {"h", "...."},
                {"i", ".."},
                {"j", ".---"},
                {"k", "-.-"},
                {"l", ".-.."},
                {"m", "--"},
                {"n", "-."},
                {"o", "---"},
                {"p", ".--."},
                {"q", "--.-"},
                {"r", ".-."},
                {"s", "..."},
                {"t", "-"},
                {"u", "..-"},
                {"v", "...-"},
                {"w", ".--"},
                {"x", "-..-"},
                {"y", "-.--"},
                {"z", "--.."},
                {" ", " & "}
        };
        String letter = "";
        String[] inMorseCode = new String[text.length()];
        String outputMorseCode = "";

        // võta teksti tähed ...
        for (int i = 0; i < text.length(); i++) {
            letter = text.substring(i, i + 1);

            // ... ja pane need inMorseCode massiivi + tagasta
            for (int j = 0; j < morseDB.length; j++) {
                if (letter.equals(morseDB[j][0])) {
                    inMorseCode[i] = morseDB[j][1];
                    outputMorseCode = outputMorseCode + "|" + inMorseCode[i];
                }
            }
        }

        System.out.println(outputMorseCode);
        return outputMorseCode;
    }
}
