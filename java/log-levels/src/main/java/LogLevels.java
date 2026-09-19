public class LogLevels {

    public static String message(String logLine) {

        int POSITION = logLine.indexOf(":");

        return logLine.substring(POSITION + 1).trim();
    }

    public static String logLevel(String logLine) {

        int STARTPOSITION = logLine.indexOf("[");
        int ENDPOSITION = logLine.indexOf("]");

        return logLine.substring(STARTPOSITION + 1, ENDPOSITION).toLowerCase();
    }

    public static String reformat(String logLine) {

        return message(logLine) + " " + "(" + (logLevel(logLine) + ")");
    }
}
