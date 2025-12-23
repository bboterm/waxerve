package nl.daraja.waxerve;

import nl.daraja.waxerve.bot.WaxerveBot;
import nl.daraja.waxerve.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    
    // Prevents accidental instantiation
    private Main() {}

    static void main() {
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            // Load config
            var config = new Config("config.properties");
            var botToken = config.get("api.key");
            // Register bot
            botsApplication.registerBot(botToken, new WaxerveBot(botToken));
        } catch (Exception e) {
            log.error("Registering waxerve-bot failed", e);
        }
    }
}
