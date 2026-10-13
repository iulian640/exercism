public class LogLine {

    private String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {

        switch (logLine.substring(1, 4)) {
            case "TRC":
                return LogLevel.TRACE;
            case "DBG":
                return LogLevel.DEBUG;
            case "INF":
                return LogLevel.INFO;
            case "WRN":
                return LogLevel.WARNING;
            case "ERR":
                return LogLevel.ERROR;
            case "FTL":
                return LogLevel.FATAL;
            default:
                return LogLevel.UNKNOWN;
        }
    }

    public String getOutputForShortLog() {

        switch (logLine.substring(1, 4)) {
            case "TRC":
                return "1:" + logLine.substring(7);
            case "DBG":
                return "2:" + logLine.substring(7);
            case "INF":
                return "4:" + logLine.substring(7);
            case "WRN":
                return "5:" + logLine.substring(7);
            case "ERR":
                return "6:" + logLine.substring(7);
            case "FTL":
                return "42:" + logLine.substring(7);
            default:
                return "0:" + logLine.substring(7);
        }
    }
}
