package LLD.loggingFramework;

import LLD.loggingFramework.outputDest.Console;

public class Client {
    public static void main(String[] args) {
        Log.info("Praveen", new Console());

    }
}
