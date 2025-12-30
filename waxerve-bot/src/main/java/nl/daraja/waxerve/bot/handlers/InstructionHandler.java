package nl.daraja.waxerve.bot.handlers;

import java.util.List;

public interface InstructionHandler {
    List<String> handle(String instruction);
}
