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

    public static final String HANDLER_TIME_1337 = "handler.time.1337";
    public static final String HANDLER_TIME_2337 = "handler.time.2337";
    public static final String HANDLER_TIME_0337 = "handler.time.0337";
    public static final String HANDLER_TIME_0314 = "handler.time.0314";

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        // Get system time
        LocalTime now = LocalTime.now();
        // Format it correctly
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        Map<LocalTime, String> alertMap = Map.ofEntries(Map.entry(LocalTime.of(13, 37), I18n.get(HANDLER_TIME_1337)),
                Map.entry(LocalTime.of(13, 38), I18n.get(HANDLER_TIME_1337)),
                Map.entry(LocalTime.of(13, 39), I18n.get(HANDLER_TIME_1337)),
                Map.entry(LocalTime.of(23, 37), I18n.get(HANDLER_TIME_2337)),
                Map.entry(LocalTime.of(23, 38), I18n.get(HANDLER_TIME_2337)),
                Map.entry(LocalTime.of(23, 39), I18n.get(HANDLER_TIME_2337)),
                Map.entry(LocalTime.of(3, 37), I18n.get(HANDLER_TIME_0337)),
                Map.entry(LocalTime.of(3, 38), I18n.get(HANDLER_TIME_0337)),
                Map.entry(LocalTime.of(3, 39), I18n.get(HANDLER_TIME_0337)),
                Map.entry(LocalTime.of(3, 14), I18n.get(HANDLER_TIME_0314)),
                Map.entry(LocalTime.of(3, 15), I18n.get(HANDLER_TIME_0314)),
                Map.entry(LocalTime.of(3, 16), I18n.get(HANDLER_TIME_0314)));

        Optional.ofNullable(alertMap.get(now.truncatedTo(ChronoUnit.MINUTES)))
                .ifPresentOrElse(s -> {
                            result.add(I18n.get("handler.time.current", now.format(formatter)));
                            result.add(I18n.get("handler.time.omg", s));
                        },
                        () -> result.add(I18n.get("handler.hax.haxen"))
                );
        return result;
    }
}
