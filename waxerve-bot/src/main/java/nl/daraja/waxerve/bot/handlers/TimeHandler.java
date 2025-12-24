package nl.daraja.waxerve.bot.handlers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

        Map<LocalTime, String> alertMap = Map.of(LocalTime.of(13, 37), "OMG! It's 1337!",
                LocalTime.of(23, 37), "OMG! It's 2337!",
                LocalTime.of(3, 37), "OMG! It's 0337!",
                LocalTime.of(3, 14), "OMG! It's π o'clock!");

        Optional.ofNullable(alertMap.get(now.truncatedTo(ChronoUnit.MINUTES))).ifPresent(result::add);
        return result;
    }
}
