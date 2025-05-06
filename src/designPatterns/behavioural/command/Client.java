package src.designPatterns.behavioural.command;

public class Client {

    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();
//        remoteControl.setCommand(lightOffCommand);
//        remoteControl.pressButton();
        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton();
    }

}
