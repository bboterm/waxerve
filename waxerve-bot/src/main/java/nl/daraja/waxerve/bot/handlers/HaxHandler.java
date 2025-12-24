package nl.daraja.waxerve.bot.handlers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HaxHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        // Get system time
        LocalTime now = LocalTime.now();
        // Format it correctly
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // Add to result
        result.add("The current time is " + now.format(formatter));

        Map<LocalTime, String> alertMap = Map.ofEntries(Map.entry(LocalTime.of(13, 37), "OMG! It's 1337!"),
                Map.entry(LocalTime.of(13, 38), "OMG! It's 1337!"),
                Map.entry(LocalTime.of(13, 39), "OMG! It's 1337!"),
                Map.entry(LocalTime.of(23, 37), "OMG! It's 2337!"),
                Map.entry(LocalTime.of(23, 38), "OMG! It's 2337!"),
                Map.entry(LocalTime.of(23, 39), "OMG! It's 2337!"),
                Map.entry(LocalTime.of(3, 37), "OMG! It's 0337!"),
                Map.entry(LocalTime.of(3, 38), "OMG! It's 0337!"),
                Map.entry(LocalTime.of(3, 39), "OMG! It's 0337!"),
                Map.entry(LocalTime.of(3, 14), "OMG! It's π o'clock!"),
                Map.entry(LocalTime.of(3, 15), "OMG! It's π o'clock!"),
                Map.entry(LocalTime.of(3, 16), "OMG! It's π o'clock!"));

        Optional.ofNullable(alertMap.get(now.truncatedTo(ChronoUnit.MINUTES)))
                .ifPresentOrElse(s -> {
                            result.add("The current time is " + now.format(formatter));
                            result.add(s);
                        },
                        () -> result.add("Mama, ze haxen!!1 :(")
                );
        return result;
    }
}
