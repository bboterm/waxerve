package nl.daraja.waxerve.bot.handlers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import nl.daraja.waxerve.util.I18n;

public class TimeHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        // Get system time
        LocalTime now = LocalTime.now();
        // Format it correctly
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        // Add to result
        result.add(I18n.get("handler.time.current", now.format(formatter)));

        Map<LocalTime, String> alertMap = Map.of(LocalTime.of(13, 37), I18n.get("handler.time.1337"),
                LocalTime.of(23, 37), I18n.get("handler.time.2337"),
                LocalTime.of(3, 37), I18n.get("handler.time.0337"),
                LocalTime.of(3, 14), I18n.get("handler.time.0314"));

        Optional.ofNullable(alertMap.get(now.truncatedTo(ChronoUnit.MINUTES)))
                .ifPresent(s -> result.add(I18n.get("handler.time.omg", s)));
        return result;
    }
}
