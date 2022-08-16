import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    @Test
    public void testEqualChars() {
        OffByOne a = new OffByOne();
        assertTrue(a.equalChars('a','a'));
        assertTrue(a.equalChars('$','$'));
        assertTrue(a.equalChars('%','%'));
        assertFalse(a.equalChars('a','b'));
        assertFalse(a.equalChars('h','a'));
        assertFalse(a.equalChars(')','*'));
        assertFalse(a.equalChars('!','m'));
    }
}