package nl.daraja.waxerve.bot.handlers;

import java.util.ArrayList;
import java.util.List;
import nl.daraja.waxerve.util.I18n;

public class WakeupHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        result.add(I18n.get("handler.wakeup.awake"));

        return result;
    }
}
