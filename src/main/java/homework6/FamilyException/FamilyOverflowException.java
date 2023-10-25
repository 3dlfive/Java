package homework6.FamilyException;

public class FamilyOverflowException extends RuntimeException {
    private int famsize;

    public int getFamsize() {
        return famsize;
    }

    public FamilyOverflowException(String message, int fsize) {
        super(message);
        famsize = fsize;
    }
}
