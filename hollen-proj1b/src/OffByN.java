public class OffByN implements CharacterComparator{
    public boolean equalChars(char x, char y) {
        if (x - y == 1 || y - x == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        OffByOne a = new OffByOne();
        System.out.println(a.equalChars('c', 'b'));
    }
}
