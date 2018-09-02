/**
 * Java Level 1. Lesson 7. Homework.
 *
 * @author Denis Kuzovin
 * @version Sep 2, 2018
 */

public class HWLevel1Lesson7 {
    public static void main(String[] args) {
        FeedTheCat feedTheCat = new FeedTheCat();

        Plate plate = new Plate(50);

        Cat[] cats = feedTheCat.callCats(5);
        System.out.println(plate);
        feedTheCat.feedCats(cats, plate);
        System.out.println(plate);

        for(int i = 0; i < cats.length; i++) {
            System.out.println("Cat " + i + " is hungry? " + cats[i].isHungry());
        }

        System.out.println("Add some food");
        plate.addFood(15);
        System.out.println(plate);
        feedTheCat.feedCats(cats, plate);
        System.out.println(plate);

        for(int i = 0; i < cats.length; i++) {
            System.out.println("Cat " + i + " is hungry? " + cats[i].isHungry());
        }
    }
}

class FeedTheCat {
    public Cat[] callCats(int count) {
        Cat[] cats = new Cat[count];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat((int) (Math.random() * 5 + 10));
        }
        return cats;
    }

    public void feedCats(Cat[] cats, Plate plate) {
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].isHungry()) {
                cats[i].eat(plate);
            }
        }
    }
}

class Cat {
    private int appetite;
    private boolean hungry = true;

    Cat(int appetite) {
        this.appetite = appetite;
    }

    void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) hungry = false;
    }

    public boolean isHungry() {
        return hungry;
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    boolean decreaseFood(int food) {
        if (this.food >= food) {
            this.food -= food;
            return true;
        }
        return false;
    }

    public void addFood(int food) {
        if (food > 0)
            this.food += food;
    }

    @Override
    public String toString() {
        return "Food: " + food;
    }
}