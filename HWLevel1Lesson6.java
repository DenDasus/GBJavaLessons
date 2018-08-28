public class HWLevel1Lesson6 {
    public static void main(String[] args) {
        Animal[] animals = new Animal[10];
        
        for (int i = 0; i < animals.length; i++) {
            animals[i] = Math.random() < 0.5 ? new Cat() : new Dog();
        }
        
        int testJump = 10;
        int testRun = 500;
        int testSwim = 5;
        
        for (Animal animal : animals) {
            System.out.println(animal + ": \t" +
                    "run(" + testRun + ") -> " + animal.run(testRun) + ",\t" +
                    "jump(" + testJump + ") -> " + animal.jump(testJump) + ",\t" +
                    "swim(" + testSwim + ") -> " + animal.swim(testSwim));
        }
    }
    
}

abstract class Animal {
    int runMax = -1;
    int swimMax = -1;
    float jumpMax = -1;
    
    boolean run(int meters) {
        if (meters <= runMax) {
            return true;
        }
        return false;
    }
    
    boolean jump(float meters) {
        if (meters <= jumpMax) {
            return true;
        }
        return false;
    }
    
    boolean swim(int meters) {
        if (meters <= swimMax) {
            return true;
        }
        return false;
    }
}

class Cat extends Animal {
    Cat() {
        runMax = (int) (200 * (Math.random() + 0.5));
        swimMax = (int) (-1 * (Math.random() + 0.5));
        jumpMax = (float) (2f * (Math.random() + 0.5));
    }
    
    @Override
    public String toString() {
        return String.format("Cat (%d; %3.2f; %d)", runMax, jumpMax, swimMax);
    }
}

class Dog extends Animal {
    Dog() {
        runMax = (int) (500 * (Math.random() + 0.5));
        swimMax = (int) (10 * (Math.random() + 0.5));
        jumpMax = (float) (0.5f * (Math.random() + 0.5));
    }
    
    @Override
    public String toString() {
        return String.format("Dog (%d; %3.2f; %d)", runMax, jumpMax, swimMax);
    }
}