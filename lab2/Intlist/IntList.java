import java.util.Formatter;
/**
 * @author P. N. Hilfinger, with some modifications by Josh Hug and melaniecebula
 */
public class IntList {
    public int first;
    public IntList rest;
    public IntList(int first0, IntList rest0) {
        first = first0;
        rest = rest0;
    }
    public IntList() {
    /* NOTE: public IntList () { }  would also work. */
        this(0, null);
    }
    public static void dSquareList(IntList L) {

        while (L != null) {
            L.first = L.first * L.first;
            L = L.rest;
        }
    }
    public static IntList squareListIterative(IntList L) {
        if (L == null) {
            return null;
        }
        IntList res = new IntList(L.first * L.first, null);
        IntList ptr = res;
        L = L.rest;
        while (L != null) {
            ptr.rest = new IntList(L.first * L.first, null);
            L = L.rest;
            ptr = ptr.rest;
        }
        return res;
    }
    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.first * L.first, squareListRecursive(L.rest));
    }
    public static IntList dcatenate(IntList A, IntList B) {
        //TODO:  fill in method
        IntList LAST_A_POINTER = A.rest;
        while (LAST_A_POINTER.rest != null){
            LAST_A_POINTER = LAST_A_POINTER.rest;
        }
        LAST_A_POINTER.rest = B;
        return A;
    }
    public static IntList catenate(IntList A, IntList B) {
        //TODO:  fill in method
        IntList combo = new IntList(A.first,null);
        IntList combo_POINTER = combo;
        IntList A_POINTER = A.rest;
        IntList B_POINTER = B;
        while (A_POINTER != null) {
            combo_POINTER.rest= new IntList(A_POINTER.first, null);
            combo_POINTER = combo_POINTER.rest;
            A_POINTER = A_POINTER.rest;
        }
        while (B_POINTER != null) {
            combo_POINTER.rest = new IntList(B_POINTER.first, null);
            combo_POINTER = combo_POINTER.rest;
            B_POINTER = B_POINTER.rest;
        }
        return combo;
    }
    @Override
    public int hashCode() {
        return first;
    }
    public static IntList of(Integer... args) {
        IntList result, p;

        if (args.length > 0) {
            result = new IntList(args[0], null);
        } else {
            return null;
        }

        int k;
        for (k = 1, p = result; k < args.length; k += 1, p = p.rest) {
            p.rest = new IntList(args[k], null);
        }
        return result;
    }
    public boolean equals(Object x) {
        if (!(x instanceof IntList)) {
            return false;
        }
        IntList L = (IntList) x;
        IntList p;

        for (p = this; p != null && L != null; p = p.rest, L = L.rest) {
            if (p.first != L.first) {
                return false;
            }
        }
        if (p != null || L != null) {
            return false;
        }
        return true;
    }
    private int detectCycles(IntList A) {
        IntList tortoise = A;
        IntList hare = A;

        if (A == null) {
            return 0;
        }

        int cnt = 0;


        while (true) {
            cnt++;
            if (hare.rest != null) {
                hare = hare.rest.rest;
            } else {
                return 0;
            }

            tortoise = tortoise.rest;

            if (tortoise == null || hare == null) {
                return 0;
            }

            if (hare == tortoise) {
                return cnt;
            }
        }
    }

    @Override
    /** Outputs the IntList as a String. You are not expected to read
     * or understand this method. */
    public String toString() {
        Formatter out = new Formatter();
        String sep;
        sep = "(";
        int cycleLocation = detectCycles(this);
        int cnt = 0;

        for (IntList p = this; p != null; p = p.rest) {
            out.format("%s%d", sep, p.first);
            sep = ", ";

            cnt++;
            if ((cnt > cycleLocation) && (cycleLocation > 0)) {
                out.format("... (cycle exists) ...");
                break;
            }
        }
        out.format(")");
        return out.toString();
    }

    public static void main(String[] args) {
        IntList a = new IntList(2,null);
        a.rest = new IntList(4,null);
        a.rest = new IntList(6,null);
        IntList c = new IntList(87,null);
        c.rest = new IntList(23,null);
        IntList d = catenate(a,c);
    }
}

