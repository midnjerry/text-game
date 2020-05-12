package jerry.codecamp;

public class Dog {
    private int hitPoints;
    private Emotion emotion; // sick, happy, sad, lonely, mad, nervous, excited, curious, jealous
    private int hungerLevel;
    private int thirstLevel;
    private int lonelyLevel;
    private int tiredLevel;
    private int boredLevel;
    private int dirtyLevel;
    private int age;
    private String name;
    private Gender gender;
    private boolean isNeutered;

    public Dog(String name, Gender gender){
        hitPoints = 100;
        emotion = Emotion.HAPPY;
        hungerLevel = 0;
        thirstLevel = 0;
        lonelyLevel = 0;
        tiredLevel = 0;
        boredLevel = 0;
        dirtyLevel = 0;
        age = 1;
        this.name = name;
        this.gender = gender;
        this.isNeutered = false;
    }

    public String getName(){
        return name;
    }

    public void giveBath(){
        dirtyLevel = 0;

    }

    public void timePassesForDog(){
        boredLevel += 5;
        lonelyLevel += 5;
        age += 1;
        dirtyLevel += 5;
        hungerLevel += 5;
        tiredLevel += 5;
        thirstLevel += 5;

    }

    public void takeAWalk(){
        System.out.println("You take " + name + " out on a walk.");
        tiredLevel += 10;
        dirtyLevel += 5;
        thirstLevel += 50;
        hungerLevel += 10;
        lonelyLevel = 0;
        boredLevel = 0;
    }

    public void petTheDog(){
        System.out.println("You pet " + name + ".");
    }

    public void giveTheDogASnack(){
        System.out.println("You give " + name + " a nice piece of beef jerky.");
        hungerLevel -= 10;
        lonelyLevel -= 10;
        dirtyLevel += 5;
        thirstLevel += 5;
        boredLevel -= 5;
    }

    /**
     * This method attempts to call a dog and determines if
     * it comes to you or not.
     *
     * @return true if the dog comes to you. false if not.
     */
    public boolean callTheDog(){
        System.out.println("You call " + name + " and wait for her to come over.");

        return false;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "hitPoints=" + hitPoints +
                ", emotion=" + emotion +
                ", hungerLevel=" + hungerLevel +
                ", thirstLevel=" + thirstLevel +
                ", lonelyLevel=" + lonelyLevel +
                ", tiredLevel=" + tiredLevel +
                ", boredLevel=" + boredLevel +
                ", dirtyLevel=" + dirtyLevel +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", isNeutered=" + isNeutered +
                '}';
    }
}


