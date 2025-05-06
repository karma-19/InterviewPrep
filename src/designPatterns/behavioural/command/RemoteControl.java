package src.designPatterns.behavioural.command;

public class RemoteControl {
    LightCommand lightCommand;

    public void setCommand(LightCommand lightCommand) {
        this.lightCommand = lightCommand;
    }

    public void pressButton() {
        if(lightCommand != null)
            lightCommand.execute();
    }
}
