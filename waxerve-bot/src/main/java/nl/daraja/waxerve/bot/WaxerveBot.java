package nl.daraja.waxerve.bot;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import nl.daraja.waxerve.bot.handlers.InstructionHandler;
import nl.daraja.waxerve.bot.handlers.SaxHandler;
import nl.daraja.waxerve.bot.handlers.TimeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class WaxerveBot implements LongPollingSingleThreadUpdateConsumer {
    private static final Logger log = LoggerFactory.getLogger(WaxerveBot.class);
    private final TelegramClient telegramClient;

    Map<String, Supplier<InstructionHandler>> handlers = Map.of(
            "/hax", TimeHandler::new,
            "/sax", SaxHandler::new,
            "/slap", TimeHandler::new,
            "/time", TimeHandler::new,
            "/wakeup", TimeHandler::new,
            "/wax", TimeHandler::new
    );

    public WaxerveBot(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
    }

    @Override
    public void consume(Update update) {
        // We check if the update has a message and the message has entities
        if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().hasEntities()) {
            // Filter the bot_command
            Optional<String> command = update.getMessage().getEntities().stream()
                    .filter(e -> "bot_command".equals(e.getType()))
                    .findFirst()
                    .map(e -> e.getText().split("@")[0]);

            // If the bot_command was found
            if (command.isEmpty()) {
                log.info("No bot command found.");
                return;
            }

            // Find the appropriate handler
            Supplier<InstructionHandler> factory = handlers.get(command.get());
            if (factory == null) {
                log.warn("Unknown instruction type: {}", command.get());
                return;
            }

            // Handle message
            log.debug("Handling instruction: {}", command.get());
            List<String> response = factory.get().handle(update.getMessage().getText());

            // Create your send message object
            response.stream().map(s -> new SendMessage(update.getMessage().getChatId().toString(), s))
                    .forEach(s -> {
                        try {
                            telegramClient.execute(s);
                        } catch (TelegramApiException tae) {
                            log.error("Failed to send message", tae);
                        }
                    });
        }
    }
}
