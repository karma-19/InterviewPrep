package LLD.loggingFramework.outputDest;

public class File implements OutputDestinations{
    @Override
    public void output(String str) {
        System.out.println("Printing in file + " + str);
    }
}
