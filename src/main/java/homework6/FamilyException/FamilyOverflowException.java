package homework6.FamilyException;

import homework6.CustomLogger.CustomLogger;

public class FamilyOverflowException extends RuntimeException {
    CustomLogger logger = new CustomLogger();

    private int famsize;

    public int getFamsize() {
        return famsize;
    }

    public FamilyOverflowException(String message, int fsize) {

        super(message);
        logger.error(message);
        famsize = fsize;
    }
}
