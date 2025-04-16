package LLD.loggingFramework.outputDest;

public class DB implements OutputDestinations{
    @Override
    public void output(String str) {
        System.out.println("Putting in DB " + str);
    }
}
