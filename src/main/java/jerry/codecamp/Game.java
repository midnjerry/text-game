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
            checkForDeath();
        }
        System.out.println("Thanks for playing!");
    }

    private void checkForDeath() {
        if (!dog.isAlive()){
            shouldGameRun  = false;
            System.out.println("Your dog is dead.  :(");
        }
    }

    private void processTick(){
        if (tickCounter == 3){
            dog.timePassesForDog();
            tickCounter = 0;
        }
        tickCounter = tickCounter + 1;
    }

    public void processMenu() {
        dog.displayHealth();
        System.out.println("What would you like to do?");
        System.out.println("1. Pet Zoe");
        System.out.println("2. Feed Zoe");
        System.out.println("3. Call Zoe");
        System.out.println("4. Play fetch with Zoe");
        System.out.println("5. Take Zoe for a walk");
        System.out.println("6. Beat the dog");
        System.out.println("Q. Quit the game");

        String selection = scanner.nextLine();

        switch (selection) {
            case ("1"):
                dog.petTheDog();
                break;
            case ("2"):
                dog.giveTheDogASnack();
                break;
            case ("3"):
                dog.callTheDog();
                break;
            case ("4"):
                System.out.println("Zoe looks at the toy, looks at you, then goes back to sleep.");
                break;
            case ("5"):
                dog.takeAWalk();
                System.out.println(dog);
                break;
            case ("6"):
                dog.beatDog();
                System.out.println("you hit the dog");
                break;
            case ("q"):
            case ("Q"):
                shouldGameRun = false;
                //...
                //...

                break;
            default:
                System.out.println("Zoe gives you an empty stare, and runs away.");
        }
    }
}
