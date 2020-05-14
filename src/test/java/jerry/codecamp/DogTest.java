package jerry.codecamp;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.*;

public class DogTest {

    private Dog dog;

    @Before
    public void setUp() throws Exception {
        dog = new Dog("TestDog", Gender.MALE);
    }

    @Test
    public void getName_returnsCorrectName() {
        assertEquals("TestDog", dog.getName());
    }

    //RED
    //GREEN
    //REFACTOR

    @Test
    public void checkInitialValues() {
        assertEquals(100, dog.getHitPoints());
        assertEquals(0, dog.getHungerLevel());
        assertEquals(0, dog.getThirstLevel());
        assertEquals(0, dog.getLonelyLevel());
        assertEquals(0, dog.getTiredLevel());
        assertEquals(0, dog.getBoredLevel());
        assertEquals(0, dog.getDirtyLevel());
        assertEquals(25, dog.getTrustLevel());
        assertEquals(Emotion.HAPPY, dog.getEmotion());
        assertEquals(1, dog.getAge());
        assertEquals(false, dog.isNeutered());
        assertEquals(Gender.MALE, dog.getGender());
    }

    @Test
    public void giveBath_setDirtyLevelToZero() {
        dog.setDirtyLevel(10);
        dog.giveBath();
        assertEquals(0, dog.getDirtyLevel());
    }

    @Test
    public void giveBath_increasesTiredLevel() {
        dog.giveBath();
        assertEquals(5, dog.getTiredLevel());

        dog.giveBath();
        assertEquals(10, dog.getTiredLevel());
    }

    @Test
    public void giveBath_dogIsMad() {
        dog.giveBath();
        assertEquals(Emotion.MAD, dog.getEmotion());
    }

    @Test
    public void giveBath_decreasesTrustLevel() {
        dog.giveBath();
        assertEquals(20, dog.getTrustLevel());

        dog.giveBath();
        assertEquals(15, dog.getTrustLevel());
    }

    @Test
    public void timePassesForDog_increasesBoredLevel() {
        dog.timePassesForDog();
        assertEquals(5, dog.getBoredLevel());

        dog.timePassesForDog();
        assertEquals(10, dog.getBoredLevel());
    }

    @Test
    public void timePassesForDog_increasedLonelyLevel() {
        dog.timePassesForDog();
        assertEquals(5, dog.getLonelyLevel());

        dog.timePassesForDog();
        assertEquals(10, dog.getLonelyLevel());
    }

    @Test
    public void timePassesForDog_increasesAge() {
        dog.timePassesForDog();
        assertEquals(2, dog.getAge());

        dog.timePassesForDog();
        assertEquals(3, dog.getAge());
    }

    @Test
    public void timePassesForDog_increasesDirtyLevel() {
        dog.timePassesForDog();
        assertEquals(5, dog.getDirtyLevel());

        dog.timePassesForDog();
        assertEquals(10, dog.getDirtyLevel());
    }

    @Test
    public void timePassesForDog_decreasesHungerLevel() {
        dog.timePassesForDog();
        assertEquals(5, dog.getHungerLevel());

        dog.timePassesForDog();
        assertEquals(10, dog.getHungerLevel());
    }

    @Test
    public void timePassesForDog_increasesTiredLevel() {
        dog.timePassesForDog();
        assertEquals(5, dog.getTiredLevel());

        dog.timePassesForDog();
        assertEquals(10, dog.getTiredLevel());
    }

    @Test
    public void timePassesForDog_increasesThirstLevel() {
        dog.timePassesForDog();
        assertEquals(5, dog.getThirstLevel());

        dog.timePassesForDog();
        assertEquals(10, dog.getThirstLevel());
    }

    @Test
    public void giveTheDogASnack_increasesHungerLevel() {
        dog.setHungerLevel(20);
        dog.giveTheDogASnack();
        assertEquals(10, dog.getHungerLevel());

        dog.giveTheDogASnack();
        assertEquals(0, dog.getHungerLevel());
    }

    @Test
    public void giveTheDogASnack_decreasesLonelyLevel() {
        dog.setLonelyLevel(20);
        dog.giveTheDogASnack();
        assertEquals(10, dog.getLonelyLevel());

        dog.giveTheDogASnack();
        assertEquals(0, dog.getLonelyLevel());
    }

    @Test
    public void giveTheDogASnack_increasesDirtyLevel() {
        dog.giveTheDogASnack();
        assertEquals(5, dog.getDirtyLevel());

        dog.giveTheDogASnack();
        assertEquals(10, dog.getDirtyLevel());
    }

    @Test
    public void giveTheDogASnack_increasesThirstLevel() {
        dog.giveTheDogASnack();
        assertEquals(5, dog.getThirstLevel());

        dog.giveTheDogASnack();
        assertEquals(10, dog.getThirstLevel());
    }

    @Test
    public void giveTheDogASnack_decreasesBoredLevel() {
        dog.setBoredLevel(20);
        dog.giveTheDogASnack();
        assertEquals(15, dog.getBoredLevel());

        dog.giveTheDogASnack();
        assertEquals(10, dog.getBoredLevel());
    }
}