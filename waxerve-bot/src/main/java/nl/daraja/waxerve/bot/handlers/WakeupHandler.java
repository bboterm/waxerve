package nl.daraja.waxerve.bot.handlers;

import java.util.ArrayList;
import java.util.List;

public class WakeupHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        result.add("Huh? What? I'm awake!");

        return result;
    }
}
