/**
 *	Java Level 1. Lesson 5. Homework.
 *
 *	@author Denis Kuzovin
 *	@version Aug 26, 2018
 */

public class HWLevel1Lesson5 {
    public static void main(String[] args) {
        Person[] array = new Person[5];
        array[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89231236578", 30000, 30);
        array[1] = new Person("Petrov Alexander", "Engineer", "qwertrty@mailbox.com", "89356785432", 35000, 41);
        array[2] = new Person("Yakovlev Gleb", "Designer", "asdfgh@mailbox.com", "89543478224", 32000, 23);
        array[3] = new Person("Nikolaev Andrew", "Chief", "zxcvbn@mailbox.com", "89231231267", 45000, 57);
        array[4] = new Person("Pavlov Sergey", "HR", "poiuyt@mailbox.com", "89276542378", 25000, 35);

        for(int i =0; i < array.length; i++)
        {
            if(array[i].getAge() > 40) {
                array[i].printData();
            }
        }
    }
}

class Person {
    private String name;
    private String position;
    private String mail;
    private String phone;
    private int money;
    private int age;

    public Person(String name, String position, String mail, String phone, int money, int age) {
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.phone = phone;
        this.money = money;
        setAge(age);
    }

    public String toString() {
        return "Name: " + name + ", Position: " + position + ", Mail: " + mail + ", Phone: "
                + phone + ", Money: " + money + ", Age: " + age;
    }

    public void printData(){
        System.out.println(this.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0)
            this.age = age;
    }
}
