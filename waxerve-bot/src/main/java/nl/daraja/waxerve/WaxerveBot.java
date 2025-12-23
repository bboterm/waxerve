package nl.daraja.waxerve;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WaxerveBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient = new OkHttpTelegramClient("8401355446:AAFsMSLoVT5d1cmf3cKmn8th2VES9Sl5FjA");

    @Override
    public void consume(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Create your send message object
            LocalTime now = LocalTime.now();
            String message = "The current time is " + now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            SendMessage sendMessage = new SendMessage(update.getMessage().getChatId().toString(), message);
            try {
                // Execute it
                telegramClient.execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}