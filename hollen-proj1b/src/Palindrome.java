public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> palindrome = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            palindrome.addLast(word.charAt(i));
        }
        return palindrome;
    }

    public boolearn isPalindrome(String word) {

    }
}
