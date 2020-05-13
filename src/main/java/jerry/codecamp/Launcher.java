package jerry.codecamp;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean shouldGameRun = true;
        Dog dog = new Dog("Zoe", Gender.FEMALE);

        System.out.println("Welcome to the Adventures of Zoe and Boo");
        System.out.println();

        while (shouldGameRun) {
            System.out.println("What would you like to do?");
            System.out.println("1. Pet Zoe");
            System.out.println("2. Feed Zoe");
            System.out.println("3. Call Zoe");
            System.out.println("4. Play fetch with Zoe");
            System.out.println("5. Take Zoe for a walk");
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
                case ("q"):
                case ("Q"):
                    System.out.println("Thanks for playing!");
                    shouldGameRun = false;
                    //...
                    //...

                    break;
                default:
                    System.out.println("Zoe gives you an empty stare, and runs away.");
            }
        }
    }
}
