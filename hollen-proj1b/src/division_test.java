public class division_test {
    public static void main(String[] args) {
        Palindrome a = new Palindrome();
        Deque<Character> wordsDeque = a.wordToDeque("ava");
        System.out.println(wordsDeque.removeFirst() == wordsDeque.removeLast());
        System.out.println(a.isPalindrome("aba"));
        System.out.println(3/2);

    }
}
