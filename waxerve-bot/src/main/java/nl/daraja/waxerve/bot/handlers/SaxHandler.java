package nl.daraja.waxerve.bot.handlers;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SaxHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        result.add("https://www.youtube.com/watch?v=2rCP4CRRO7E");
        result.add("\"Gandolf\"...");

        return result;
    }
}
