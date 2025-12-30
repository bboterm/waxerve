package nl.daraja.waxerve.bot.handlers;

import java.util.ArrayList;
import java.util.List;
import nl.daraja.waxerve.util.I18n;

public class SlapHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        // Determine slappee
        String slappee = instruction.length() > 6 ? instruction.substring(6) : "";
        result.add(I18n.get("handler.slap.slaps", slappee));

        return result;
    }
}
