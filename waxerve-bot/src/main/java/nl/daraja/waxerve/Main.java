package nl.daraja.waxerve;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main {
    static void main(String[] args)  {
        try {
            String botToken = "8525892988:AAGLrrktqIUlG8sr3kV7BInHKHa-85XtMVM";
            TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication();
            botsApplication.registerBot(botToken, new WaxerveBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
