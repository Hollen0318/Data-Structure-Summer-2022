public class Cat extends Animal {
//    Given the Animal class, fill in the
//    definition of the Cat class so that
//    when greet() is called, “Cat says: Meow!”
//    is printed (instead of “Animal says: Huh?”).
//    Cats less than the ages of 5 can say
//    “MEOW!” instead of “Meow!”
    public Cat(String name, int age ) {
        super(name, age);
        this.noise = "Meow!";
    }
    @Override
    public void greet() {
        System.out.println("Cat " + name + " says: " + makeNoise());
    }

    public static void main(String[] args) {
        Cat paws = new Cat("Paws", 2);
        paws.greet();
    }
}
