public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> palindrome = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            palindrome.addLast(word.charAt(i));
        }
        return palindrome;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> wordsDeque = wordToDeque(word);
        if (wordsDeque.size() <= 1) {
            return true;
        } else {
            for (int i = 0; i < wordsDeque.size()/2; i++) {
                if (wordsDeque.removeFirst() != wordsDeque.removeLast()) {
                    return false;
                }
            }
            return true;
        }
    }
}
