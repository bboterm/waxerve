package nl.daraja.waxerve.bot.handlers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import nl.daraja.waxerve.util.I18n;

public class HaxHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        // Get system time
        LocalTime now = LocalTime.now();
        // Format it correctly
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        Map<LocalTime, Integer> correctionMap = Map.ofEntries(Map.entry(LocalTime.of(13, 37), 0),
                Map.entry(LocalTime.of(13, 38), -1),
                Map.entry(LocalTime.of(13, 39), -2),
                Map.entry(LocalTime.of(23, 37), 0),
                Map.entry(LocalTime.of(23, 38), -1),
                Map.entry(LocalTime.of(23, 39), -2),
                Map.entry(LocalTime.of(3, 37), 0),
                Map.entry(LocalTime.of(3, 38), -1),
                Map.entry(LocalTime.of(3, 39), -2),
                Map.entry(LocalTime.of(3, 14), 0),
                Map.entry(LocalTime.of(3, 15), -1),
                Map.entry(LocalTime.of(3, 16), -2));

        Map<LocalTime, String> alertMap = Map.of(LocalTime.of(13, 37), I18n.get("handler.time.1337"),
                LocalTime.of(23, 37), I18n.get("handler.time.2337"),
                LocalTime.of(3, 37), I18n.get("handler.time.0337"),
                LocalTime.of(3, 14), I18n.get("handler.time.0314"));

        Optional.ofNullable(correctionMap.get(now.truncatedTo(ChronoUnit.MINUTES)))
                .ifPresentOrElse(i -> {
                            LocalTime correction = now.plusMinutes(i);
                            result.add(I18n.get("handler.time.current", correction.format(formatter)));
                            result.add(I18n.get("handler.time.omg", alertMap.get(correction.truncatedTo(ChronoUnit.MINUTES))));
                        },
                        () -> result.add(I18n.get("handler.hax.haxen"))
                );
        return result;
    }
}
