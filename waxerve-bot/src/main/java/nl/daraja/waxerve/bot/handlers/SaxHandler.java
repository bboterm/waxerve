package nl.daraja.waxerve.bot.handlers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import nl.daraja.waxerve.util.I18n;

public class SaxHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        result.add("https://www.youtube.com/watch?v=2rCP4CRRO7E");
        result.add(I18n.get("handler.sax.gandolf"));

        return result;
    }
}
