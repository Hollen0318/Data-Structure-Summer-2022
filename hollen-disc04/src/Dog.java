public class Dog {
    String name = "";
    int age = 0;
    public Dog(String n, int g) {
        this.name = n;
        this.age = g;
    }

    public void bark(Dog d) {
        System.out.println(this.name+" Aged " + this.age + " Barks at " + d.name + " Aged " + d.age);
    }

//    public static void main(String[] args) {
//        Dog Craw = new Dog("Craw", 10);
//        Dog Faor = new Dog("Faor", 2);
//        Craw.bark(Faor);
//    }
}
