package src.designPatterns.behavioural.command;

public abstract class LightCommand {
    Light light;

    public LightCommand(Light light) {
        this.light = light;
    }

    public abstract void execute();
}
