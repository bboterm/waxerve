package nl.daraja.waxerve.bot.handlers;

import java.util.ArrayList;
import java.util.List;

public class HaxHandler implements InstructionHandler {

    @Override
    public List<String> handle(String instruction) {
        List<String> result = new ArrayList<>();

        result.add("Mama, ze haxen!!1 :(");

        return result;
    }
}
