public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> palindrome = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            palindrome.addLast(word.charAt(i));
        }
        return palindrome;
    }

//    Found very elegant solutions online
    public boolean isPalindrome(String word) {
        return isPalindromeHelper(word, 0);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeHelper(word, 0, cc);
    }
    private boolean isPalindromeHelper(String word, int index) {
        int oppositeIndex = word.length() - index - 1;
        if (index >= oppositeIndex) {
            return true;
        }
        if (word.charAt(index) == word.charAt(oppositeIndex)) {
            return isPalindromeHelper(word, index + 1);
        } else {
            return false;
        }
    }

    public boolean isPalindromeHelper(String word, int index, CharacterComparator cc) {
        int oppositeIndex = word.length() - index - 1;
        if (index >= oppositeIndex) {
            return true;
        }
        if (cc.equalChars(word.charAt(index), word.charAt(oppositeIndex))) {
            return isPalindromeHelper(word, index + 1, cc);
        } else {
            return false;
        }
    }

}


//    public boolean isPalindrome(String word) {
//        Deque<Character> wordsDeque = wordToDeque(word);
//        if (wordsDeque.size() <= 1) {
//            return true;
//        } else {
//            for (int i = 0; i < wordsDeque.size()/2; i++) {
//                if (wordsDeque.removeFirst() != wordsDeque.removeLast()) {
//                    return false;
//                }
//            }
//            return true;
//        }
//    }

//    public boolean isPalindrome(String word, String word2) {
//        Deque<Character> wordsDeque = wordToDeque(word);
//        if (wordsDeque.size() <= 1) {
//            return true;
//        } else {
//            for (int i = 0; i < wordsDeque.size()/2; i++) {
//                if (wordsDeque.removeFirst() != wordsDeque.removeLast()) {
//                    return false;
//                }
//            }
//            return true;
//        }
//    }
