public class Corgi extends Dog{
    String name = "";
    int age = 0;
    public Corgi(String n, int g) {
        super(n, g);
    }
    @Override
    public void bark(Dog d) {
        System.out.println(this.name+" Aged " + this.age + " BARKS at " + d.name + " Aged " + d.age);
    }

    public void play(Dog d) {
        System.out.println(this.name + " is playing with the dog " + d.name + "!");
    }

    public void play(Corgi c) {
        System.out.println(this.name + " is playing with the Corgi " + c.name + "!");
    }
}
