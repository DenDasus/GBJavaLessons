import java.util.Arrays;

import java.util.Scanner;
import java.util.Random;

public class HWLevel1Lesson3 {
    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("� ����� ���� �� ������ �������?");
        System.out.println("1 - ������ �����");
        System.out.println("2 - ������ �����");
        int choice = 0;
        do {
            choice = sc.nextInt();
        } while (!(choice == 1 || choice == 2));
        System.out.println("������ � " + (choice == 1 ? "\"������ �����\"" : "\"������ �����\""));
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
            System.out.println("�������� ����� �� 0 �� " + range + " ������������");
            System.out.println("� ��� ���� " + attempts + " �������.");
            
            while (attempts > 0) {
                int userNumber = sc.nextInt();
                sc.nextLine();
                
                if (userNumber < 0 || userNumber > range) {
                    System.out.println("�������� ����� �� ������������� �������.");
                }
                if (userNumber == number) {
                    System.out.println("�� �������!");
                    break;
                } else if (userNumber > number) {
                    System.out.println("���������� ����� ������ ����������");
                } else {
                    System.out.println("���������� ����� ������ ����������");
                }
                attempts--;
                System.out.println("� ��� �������� " + attempts + " �������.");
            }
            
            int choice = 0;
            do {
                System.out.println("��������� ���� ��� ���? 1 - �� / 0 - ���");
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
        System.out.println("������� �����");
        boolean isExit = false;
        while (!isExit) {
            String userWord = sc.nextLine();
            if (userWord.equals(words[guessedWordIndex])) {
                System.out.println("�� �������!");
                isExit = true;
            } else {
                for (int i = 0; i < 15; i++) {
                    if (words[guessedWordIndex].length() > i && userWord.length() > i)
                        System.out.print(words[guessedWordIndex].charAt(i) == userWord.charAt(i) ? userWord.charAt(i) : "#");
                    else
                        System.out.print("#");
                }
                System.out.println();
                System.out.println("���������� ��� ���");
            }
        }
        
    }
}
