import java.util.Arrays;

import java.util.Scanner;
import java.util.Random;

public class HWLevel1Lesson3 {
    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("В какую игру вы хотите сыграть?");
        System.out.println("1 - Угадай число");
        System.out.println("2 - Угадай слово");
        int choice = 0;
        do {
            choice = sc.nextInt();
        } while (!(choice == 1 || choice == 2));
        System.out.println("Играем в " + (choice == 1 ? "\"Угадай число\"" : "\"Угадай слово\""));
        switch (choice) {
            case 1:
                gameGuessNumber();
                break;
            case 2:
                gameGuessWord();
                break;
        }
    }
    
    public static void gameGuessNumber() {
        boolean isExit = false;
        while (!isExit) {
            int range = 9;
            int attempts = 3;
            int number = rand.nextInt(range + 1);
            System.out.println("Угадайте число от 0 до " + range + " включительно");
            System.out.println("У Вас есть " + attempts + " попытки.");
            
            while (attempts > 0) {
                int userNumber = sc.nextInt();
                sc.nextLine();
                
                if (userNumber < 0 || userNumber > range) {
                    System.out.println("Веденное число не удовлетворяет условию.");
                }
                if (userNumber == number) {
                    System.out.println("Вы угадали!");
                    break;
                } else if (userNumber > number) {
                    System.out.println("Загаданное число меньше введенного");
                } else {
                    System.out.println("Загаданное число больше введенного");
                }
                attempts--;
                System.out.println("У Вас осталось " + attempts + " попыток.");
            }
            
            int choice = 0;
            do {
                System.out.println("Повторить игру еще раз? 1 - да / 0 - нет");
                choice = sc.nextInt();
                sc.nextLine();
            } while (!(choice == 0 || choice == 1));
            isExit = choice == 0 ? true : false;
            
        }
        
    }
    
    public static void gameGuessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        
        int guessedWordIndex = rand.nextInt(words.length);
        Scanner sc = new Scanner(System.in);
        System.out.println(Arrays.toString(words));
        System.out.println("Введите слово");
        boolean isExit = false;
        while (!isExit) {
            String userWord = sc.nextLine();
            if (userWord.equals(words[guessedWordIndex])) {
                System.out.println("Вы угадали!");
                isExit = true;
            } else {
                for (int i = 0; i < 15; i++) {
                    if (words[guessedWordIndex].length() > i && userWord.length() > i)
                        System.out.print(words[guessedWordIndex].charAt(i) == userWord.charAt(i) ? userWord.charAt(i) : "#");
                    else
                        System.out.print("#");
                }
                System.out.println();
                System.out.println("Попробуйте еще раз");
            }
        }
        
    }
}
