package src.designPatterns.behavioural.command;

public class LightOffCommand extends LightCommand{

    LightOffCommand(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        light.lightOff();
    }
}
