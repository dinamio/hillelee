package borysov.utility;

public class Convertor {
    public static int convertBooleanToInteger(Boolean value) {
        int returnValue = 0;
        if (value == true) {
            returnValue = 1;
        }
        return returnValue;
    }
}
