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
    private int trustLevel;
    private int age;
    private String name;
    private Gender gender;
    private boolean isNeutered;
    private boolean isAlive;


    public Dog(String name, Gender gender) {
        hitPoints = 100;
        emotion = Emotion.HAPPY;
        hungerLevel = 0;
        thirstLevel = 0;
        lonelyLevel = 0;
        tiredLevel = 0;
        boredLevel = 0;
        dirtyLevel = 0;
        trustLevel = 25;
        age = 1;
        this.name = name;
        this.gender = gender;
        this.isNeutered = false;
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public String getName() {
        return name;
    }

    public void giveBath() {
        dirtyLevel = 0;
        tiredLevel = tiredLevel + 5;
        emotion = Emotion.MAD;
        trustLevel -= 5;
    }

    public void beatDog() {
        hitPoints -= 20;
        trustLevel -= 30;
        if (trustLevel > 50) {
            emotion = Emotion.SAD;
        } else {
            emotion = Emotion.MAD;
        }
        dirtyLevel += 5;
        lonelyLevel += 5;
    }

    public void timePassesForDog() {
        System.out.println("Time passes for " + name + "!");
        boredLevel += 5;
        lonelyLevel += 5;
        age += 1;
        dirtyLevel += 5;
        hungerLevel += 5;
        tiredLevel += 5;
        thirstLevel += 5;
        if (hitPoints <= 0) {
            killDog();
        }
    }

    public void killDog() {
        isAlive = false;

    }

    public void takeAWalk() {
        System.out.println("You take " + name + " out on a walk.");
        tiredLevel += 10;
        dirtyLevel += 5;
        thirstLevel += 50;
        hungerLevel += 10;
        lonelyLevel = 0;
        boredLevel = 0;
        trustLevel += 5;
    }

    public void petTheDog() {
        System.out.println("You pet " + name + ".");
    }

    public void giveTheDogASnack() {
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
    public boolean callTheDog() {
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

    public int getHitPoints() {
        return hitPoints;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public int getThirstLevel() {
        return thirstLevel;
    }

    public int getLonelyLevel() {
        return lonelyLevel;
    }

    public int getTiredLevel() {
        return tiredLevel;
    }

    public int getBoredLevel() {
        return boredLevel;
    }

    public int getDirtyLevel() {
        return dirtyLevel;
    }

    public void setDirtyLevel(int dirtyLevel) {
        this.dirtyLevel = dirtyLevel;
    }

    public void setBoredLevel(int level) {
        boredLevel = level;
    }

    public void setLonelyLevel(int level) {
        lonelyLevel = level;
    }

    public void setHungerLevel(int level) {
        hungerLevel = level;
    }

    public int getTrustLevel() {
        return trustLevel;
    }

    public int getAge() {
        return age;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isNeutered() {
        return isNeutered;
    }

    public void displayHealth() {
        System.out.println("Name: " + name);
        System.out.println("==================================================");
        System.out.println("HitPoints: " + hitPoints);
        System.out.print("Energy: " + (100-tiredLevel));
        System.out.print("\tLove: " + trustLevel);
        System.out.print("\tHydration: " + thirstLevel);
        System.out.println("\tEmotion: " + emotion);
        System.out.print("Filth: " + dirtyLevel);
        System.out.print("\tHunger: " + hungerLevel);
        System.out.print("\tBoredom: " + boredLevel);
        System.out.println("\tLoneliness: " + lonelyLevel);
        System.out.println("==================================================");
    }
}


