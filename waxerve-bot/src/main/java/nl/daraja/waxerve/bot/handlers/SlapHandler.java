package nl.daraja.waxerve.bot.handlers;

import java.util.ArrayList;
import java.util.List;

public class SlapHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        String slappee = instruction.length() > 6 ? instruction.substring(6) : "";

        result.add("Slaps " + slappee + " around a bit with a large trout.");

        return result;
    }
}
