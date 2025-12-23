package nl.daraja.waxerve.bot.handlers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TimeHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        // Get system time
        LocalTime now = LocalTime.now();
        // Format it correctly
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // Add to result
        result.add("The current time is " + now.format(formatter));

        // Do 1337-checks
        if (now.equals(LocalTime.of(13, 37))) {
            result.add("OMG! It's 1337!");
        } else if (now.equals(LocalTime.of(23, 37))) {
            result.add("OMG! It's 2337!");
        } else if (now.equals(LocalTime.of(3, 37))) {
            result.add("OMG! It's 0337!");
        } else if (now.equals(LocalTime.of(3, 14))) {
            result.add("OMG! It's π o'clock!");
        }

        return result;
    }
}
