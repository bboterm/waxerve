package nl.daraja.waxerve.bot.handlers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeHandler implements InstructionHandler {

    @Override
    public String handle(String instruction) {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "The current time is " + now.format(formatter);
    }
}
