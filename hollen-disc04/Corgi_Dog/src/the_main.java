public class the_main {
    public static void main(String[] args) {
        Corgi c  = new Corgi();
        Dog d = new Corgi();
        Dog d2 = new Dog();
//    Corgi c2 = new Dog();
        Corgi c3 = (Corgi) new Dog();
//        d.play(d);
//        d.play(c);

        c.play(d);
    }
}
