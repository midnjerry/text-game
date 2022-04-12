package jerry.codecamp;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private boolean shouldGameRun = false;
    private Dog dog;
    private int tickCounter;


    public void startGame() {
        dog = new Dog("Zoe", Gender.FEMALE);
        shouldGameRun = true;
        tickCounter = 0;
        System.out.println("Welcome to the Adventures of Zoe and Boo");
        System.out.println();
        runGameLoop();
    }

    private void runGameLoop() {
        while (shouldGameRun) {
            processTick();
            processMenu();
            checkForGameOver();
        }
        System.out.println("Thanks for playing!");
    }

    private void checkForGameOver() {
        if (!dog.isAlive()) {
            shouldGameRun = false;
            System.out.println(dog.getName() + " is dead. :(");
        }
        if (dog.getEmotion() == Emotion.RABID) {
            shouldGameRun = false;
            System.out.println(dog.getName() + " adorably tears you limb from limb!! Game over LOSER");

        }
    }
    private void processTick() {
        if (tickCounter == 3) {
            dog.timePassesForDog();
            tickCounter = 0;
        }
        tickCounter = tickCounter + 1;
    }

    public void processMenu() {
        dog.displayHealth();
        System.out.println("What would you like to do?");
        System.out.println("1. Pet " + dog.getName());
        System.out.println("2. Feed " + dog.getName());
        System.out.println("3. Give " + dog.getName() + " some water");
        System.out.println("4. Give " + dog.getName() + " a bath");
        System.out.println("5. have " + dog.getName() + " take a nap");
        //System.out.println("6. Call " + dog.getName());
        //System.out.println("7. Play fetch with " + dog.getName());
        //System.out.println("8. Take " + dog.getName() + " for a walk");
        System.out.println("9. Beat " + dog.getName());
        System.out.println("10. Give " + dog.getName() + " medicine");
        System.out.println("Q. Quit the game");

        String selection = scanner.nextLine();

        switch (selection) {
            case ("1"):
                System.out.println("You pet " + dog.getName() + ".");
                dog.petTheDog();
                break;
            case ("2"):
                System.out.println("You give " + dog.getName() + " a nice piece of beef jerky.");
                dog.giveTheDogASnack();
                break;
            case ("3"):
                dog.giveWater();
                break;
            case ("4"):
                dog.giveBath();
                break;
            case ("5"):
                System.out.println(dog.getName() + " is taking a nap");
                dog.takeNap();
                break;
           // case("6"):
               // System.out.println("You call " + dog.getName() + " and wait for her to come over.");
              //  dog.callTheDog();
               // break;
           // case ("7"):
            //   System.out.println(dog.getName() + " looks at the toy, looks at you, then goes back to sleep.");
              //  dog.playFetch();
              //  break;
           // case ("8"):
              //  System.out.println("You take " + dog.getName() + " for a walk");
               // dog.takeAWalk();
              //  break;
            case ("9"):
                System.out.println("you hit " + dog.getName());
                dog.beatDog();
                break;
            case ("10"):
                System.out.println("You give " + dog.getName() +  " medicine");
                dog.giveMedicine();
                break;
            case ("q"):
            case ("Q"):
                shouldGameRun = false;
                //...
                //...

                break;
            default:
                System.out.println(dog.getName() + " gives you an empty stare, and runs away.");
        }
    }
}
