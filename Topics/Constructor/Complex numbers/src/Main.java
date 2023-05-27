// write the class Complex here
class SuperClass {
    public void instanceMethod() {
        System.out.println("super");
    }
}

class SubClass extends SuperClass {
    // Static method instanceMethod() in SubClass cannot override instance method instanceMethod() in SuperClass
    public static void instanceMethod() {
        System.out.println("sub");
    }
}