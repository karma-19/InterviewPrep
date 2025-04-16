package LLD.loggingFramework.outputDest;

public class Console implements OutputDestinations{
    @Override
    public void output(String str) {
        System.out.println("Printing on console " + str);
    }
}
