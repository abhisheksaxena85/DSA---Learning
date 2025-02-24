/*
    Starting Object Oriented Programming Concepts
    Start Date - February 22nd, 2025 02:30 AM
 */

public class chapter_6 {

    public static void main(String args[]) {
        Name nameObj = new Name();
        nameObj.setName1("Abhishek Saxena");
        System.out.println(nameObj.getName1());
        nameObj.setName2("Saxena");
        System.out.println(nameObj.getName2());
        Car d = new Car();
        Vehical vh = new Vehical();

        Vehical vehicalCar = new Car();

        Car carVehical = new Vehical();
    }
}

// class Animal {
//     String name;
//     void eats() {
//     }
// }
class Vehical {

}

class Car extends Vehical {

}

class Dog extends Animal {

    Dog() {

        this.legs = "Abs";

        this.walk();
    }

    String legs;
    String ears;

    void walk() {
        System.out.println("Walks");
    }
}

class Name {

    private String firstName;
    private String secondName;

    void setName1(String name) {
        System.out.println("First Name called");
    }

    String getName1() {
        return this.firstName;
    }

    void setName2(String name) {
        System.err.println("Second name called");
    }

    String getName2() {
        return this.secondName;
    }
}
