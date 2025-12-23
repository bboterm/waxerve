package nl.daraja.waxerve.bot.handlers;

import java.util.ArrayList;
import java.util.List;

public class SlapHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        result.add("Slaps around a bit with a large trout.");

        return result;
    }
}
