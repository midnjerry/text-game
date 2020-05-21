package jerry.codecamp;

import javax.swing.*;

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

    public void timePassesForDog() {
        System.out.println("Time passes for " + name + "!");
        boredLevel = addValue(boredLevel, +5);
        lonelyLevel = addValue(lonelyLevel, +5);
        age += 1;
        dirtyLevel = addValue(dirtyLevel, +5);
        hungerLevel = addValue(hungerLevel, +5);
        tiredLevel = addValue(tiredLevel, +5);
        thirstLevel = addValue(thirstLevel, +5);
        if (hitPoints <= 0) {
            killDog();
        }
    }

    public void petTheDog() {
        dirtyLevel = addValue(dirtyLevel, +1);
        lonelyLevel = addValue(lonelyLevel, -5);
        boredLevel = addValue(boredLevel, -5);
        trustLevel = addValue(trustLevel, +10);
        emotion = Emotion.HAPPY;
    }

    public void giveTheDogASnack() {
        hungerLevel = addValue(hungerLevel, -10);
        lonelyLevel = addValue(lonelyLevel, -10);
        dirtyLevel = addValue(dirtyLevel, +5);
        thirstLevel = addValue(thirstLevel, +5);
        boredLevel = addValue(boredLevel, -5);
        trustLevel = addValue(trustLevel, +5);
    }


    public void giveWater() {
        trustLevel = addValue(trustLevel, +5);
        thirstLevel = 0;
    }

    public void giveBath() {
        dirtyLevel = 0;
        tiredLevel = addValue(tiredLevel, +5);
        emotion = Emotion.MAD;
        trustLevel = addValue(trustLevel, -5);
        thirstLevel = addValue(thirstLevel, -2);
    }

    public void callTheDog() {
        trustLevel = addValue(trustLevel, +5);
        emotion = Emotion.EXCITED;
        boredLevel = addValue(boredLevel, -5);
        lonelyLevel = addValue(lonelyLevel, -5);
    }

    public void playFetch() {
        boredLevel = addValue(boredLevel, +5);
        emotion = Emotion.BORED;
    }

    public void takeAWalk() {
        tiredLevel = addValue(tiredLevel, -5);
        dirtyLevel = addValue(dirtyLevel, +5);
        thirstLevel = addValue(thirstLevel, +25);
        hungerLevel = addValue(hungerLevel, +20);
        lonelyLevel = 0;
        boredLevel = 0;
        trustLevel = addValue(trustLevel, +5);
    }

    public void beatDog() {
        hitPoints = addValue(hitPoints, -20);
        dirtyLevel = addValue(dirtyLevel, +5);
        lonelyLevel = addValue(lonelyLevel, +5);
        if(emotion == Emotion.MAD && trustLevel < 10) {
            emotion= Emotion.RABID;
            return;
        }

        trustLevel = addValue(trustLevel, -30);
        if (trustLevel > 50) {
            emotion = Emotion.SAD;
        } else {
            emotion = Emotion.MAD;
        }
    }

    private int addValue(int base, int value) {
        int sum = base + value;
        if (sum < 0) {
            return 0;
        }
        if (sum > 100) {
            return 100;
        }
        return sum;
    }

    public boolean isAlive() {
        return isAlive;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isNeutered() {
        return isNeutered;
    }

    public void killDog() {
        isAlive = false;

    }

    public int getHitPoints() {
        return hitPoints;
    }

    public Emotion getEmotion() {
        return emotion;
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

    public void displayHealth() {
        System.out.println("Name: " + name);
        System.out.println("======================================================");
        System.out.println("HitPoints: " + hitPoints);
        System.out.print("Energy: " + (100 - tiredLevel));
        System.out.print("\tLove: " + trustLevel);
        System.out.print("\tHydration: " + thirstLevel);
        System.out.println("\tEmotion: " + emotion);
        System.out.print("Filth: " + dirtyLevel);
        System.out.print("\tHunger: " + hungerLevel);
        System.out.print("\tBoredom: " + boredLevel);
        System.out.println("\tLoneliness: " + lonelyLevel);
        System.out.println("======================================================");
    }

}


