/**
 * Java Level 1. Lesson 6. Homework.
 *
 * @author Denis Kuzovin
 * @version Aug 29, 2018
 */

public class HWLevel1Lesson6 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[10];
        
        for (int i = 0; i < animals.length; i++) {
            animals[i] = Math.random() < 0.5 ? new Cat() : new Dog();
        }
        
        float testJump = 0.55f;
        int testRun = 500;
        int testSwim = 5;
        
        for (Animal animal : animals) {
            System.out.println(animal + ": \t" +
                    "run(" + testRun + ") -> " + animal.run(testRun) + ", \t" +
                    "jump(" + testJump + ") -> " + animal.jump(testJump) + ", \t" +
                    "swim(" + testSwim + ") -> " + animal.swim(testSwim));
        }
    }
    
}

abstract class Animal {
    abstract int getMaxRunDistance();
    abstract int getMaxSwimDistance();
    abstract float getMaxJumpHeight();
    
    boolean run(int meters) {
        if (meters >= 0 && meters <= getMaxRunDistance()) {
            return true;
        }
        return false;
    }
    
    boolean jump(float meters) {
        if (meters >= 0 && meters <= getMaxJumpHeight()) {
            return true;
        }
        return false;
    }
    
    boolean swim(int meters) {
        if (meters >= 0 && meters <= getMaxSwimDistance()) {
            return true;
        }
        return false;
    }
}

class Cat extends Animal {
    private int runMax;
    private int swimMax;
    private float jumpMax;
    
    Cat() {
        runMax = (int) (200 * (Math.random() + 0.5));
        swimMax = -1;
        jumpMax = (float) (2f * (Math.random() + 0.5));
    }
    
    @Override
    public String toString() {
        return String.format("Cat (%d; %3.2f; %d)", runMax, jumpMax, swimMax);
    }
    
    @Override
    int getMaxRunDistance() {
        return runMax;
    }
    
    @Override
    int getMaxSwimDistance() {
        return swimMax;
    }
    
    @Override
    float getMaxJumpHeight() {
        return jumpMax;
    }
}

class Dog extends Animal {
    private int runMax;
    private int swimMax;
    private float jumpMax;
    
    Dog() {
        runMax = (int) (500 * (Math.random() + 0.5));
        swimMax = (int) (10 * (Math.random() + 0.5));
        jumpMax = (float) (0.5f * (Math.random() + 0.5));
    }
    
    @Override
    public String toString() {
        return String.format("Dog (%d; %3.2f; %d)", runMax, jumpMax, swimMax);
    }
    
    @Override
    int getMaxRunDistance() {
        return runMax;
    }
    
    @Override
    int getMaxSwimDistance() {
        return swimMax;
    }
    
    @Override
    float getMaxJumpHeight() {
        return jumpMax;
    }
}