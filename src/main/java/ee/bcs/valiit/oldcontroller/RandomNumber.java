package ee.bcs.valiit.oldcontroller;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class RandomNumber {
    // generates random number
    Random random = new Random();
    int randomNumber = random.nextInt(100);

    int playerNumber = 0;
    int turnCounter = 0;

    @GetMapping("game/check/{nr}")
    public int game(@PathVariable("nr") int i){
        return randomNumber;
    };

    @PostMapping("game/{playerNumber}")
    public String playerNumber(@PathVariable("playerNumber") int playerNumber) {
        String result = "";
            while (playerNumber != randomNumber) {
                if (playerNumber == randomNumber && turnCounter == 0) {
                    result = "ÕIGE!! Ühe korraga?? nojah...";
                }

                if (playerNumber < randomNumber) {
                    System.out.println("... paku suuremat");
                    turnCounter++;
                } else if (playerNumber > randomNumber) {
                    System.out.println("... paku väiksemat");
                    turnCounter++;
                }
            }
            turnCounter++;
            result = ("Õige! Sul kulus " + turnCounter + " käiku!");

        return result;
    }

}
