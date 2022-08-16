import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("jkiuikj"));
        assertTrue(palindrome.isPalindrome("ooo"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("h"));
        assertFalse(palindrome.isPalindrome("uasdfnz"));
        assertFalse(palindrome.isPalindrome("Hh"));
        assertFalse(palindrome.isPalindrome("jJ"));
    }
}