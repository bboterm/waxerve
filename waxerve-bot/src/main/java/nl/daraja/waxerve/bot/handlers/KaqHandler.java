package nl.daraja.waxerve.bot.handlers;

import nl.daraja.waxerve.util.I18n;

import java.util.ArrayList;
import java.util.List;

public class KaqHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        result.add(I18n.get("handler.kaq.tried"));

        return result;
    }
}
