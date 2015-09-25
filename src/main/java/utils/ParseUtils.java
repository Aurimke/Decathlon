package utils;

import exceptions.MyException;

import java.text.DecimalFormat;

/**
 * Created by Aurimas on 24/09/15.
 * Utility class for parsing data
 */
public final class ParseUtils {

    public static final String TIME_SEPARATOR = "\\.";
    public static final int TIME_MIN = 3;
    public static final int TIME_SEC = 2;

    private ParseUtils() {
    }

    /**
     * Parsing number String to float
     * @param number
     * @return
     * @throws NumberFormatException
     */
    public static float getFloat(String number) throws NumberFormatException{
        if (number == null) {
            return 0.0f;
        }
        return Float.parseFloat(number);
    }

    /**
     * Parsing time String to float (seconds)
     * @param time
     * @return
     * @throws MyException
     * @throws NumberFormatException
     */
    public static float getSeconds(String time) throws MyException, NumberFormatException{
        if (time == null) {
            return 0.0f;
        }
        String[] splitTime = time.split(TIME_SEPARATOR);

        if (splitTime.length == TIME_MIN) {
            int min = Integer.parseInt(splitTime[0]);
            int seconds = min * 60;
            float timeInSeconds = Float.parseFloat(splitTime[1] + "." + splitTime[2]);
            return timeInSeconds + seconds;
        }

        if (splitTime.length == TIME_SEC) {
            return getFloat(time);
        } else {
            throw new MyException("Incorrect time format.");
        }

    }

    /**
     * Parsing Float time (seconds) to String with minutes
     * @param time
     * @return
     */
    public static String getMin(Float time) {
        if (time == null) {
            return "";
        }
        int min = time.intValue() / 60;
        String minutes = "";
        if (min > 0) {
            time = time - min * 60;
            minutes = min + ".";
        }
        DecimalFormat form = new DecimalFormat("0.00");
        return minutes + form.format(time);
    }
}
