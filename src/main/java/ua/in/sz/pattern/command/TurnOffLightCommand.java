package ua.in.sz.pattern.command;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TurnOffLightCommand implements Command {
    private final LightReceiver light;

    TurnOffLightCommand(LightReceiver light) {
        this.light = light;
    }

    @Override
    public void execute() {
       light.turnOff();
    }
}
