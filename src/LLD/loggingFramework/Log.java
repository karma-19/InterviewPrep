package LLD.loggingFramework;

import LLD.loggingFramework.outputDest.OutputDestinations;

import java.time.LocalDateTime;

public class Log {
    public static void info(String str, OutputDestinations outputDestinations) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(" Log Level Info").append(" ").append(LocalDateTime.now());
        outputDestinations.output(sb.toString());
    }

    public static void warn(String str, OutputDestinations outputDestinations) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(" Log Level Warn").append(" ").append(LocalDateTime.now());
        outputDestinations.output(sb.toString());
    }

    public static void debug(String str, OutputDestinations outputDestinations) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(" Log Level Debug").append(" ").append(LocalDateTime.now());
        outputDestinations.output(sb.toString());
    }

    public static void error(String str, OutputDestinations outputDestinations) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(" Log Level Error").append(" ").append(LocalDateTime.now());
        outputDestinations.output(sb.toString());
    }

    public static void fatal(String str, OutputDestinations outputDestinations) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(" Log Level Fatal").append(" ").append(LocalDateTime.now());
        outputDestinations.output(sb.toString());
    }
}
