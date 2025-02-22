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

    }
}

class Name {

    private String firstName;
    private String secondName;

    void setName1(String name) {
        this.firstName = name;
    }

    String getName1() {
        return this.firstName;
    }

    void setName2(String name) {
        this.secondName = name;
    }

    String getName2() {
        return this.secondName;
    }
}
