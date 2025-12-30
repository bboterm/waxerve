package nl.daraja.waxerve;

import nl.daraja.waxerve.bot.WaxerveBot;
import nl.daraja.waxerve.config.SecretLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    
    // Prevents accidental instantiation
    private Main() {}

    static void main() {
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            // Load API key
            var botToken = SecretLoader.loadApiKey();
            log.info("API-key loaded");
            // Register bot
            botsApplication.registerBot(botToken, new WaxerveBot(botToken));
            log.info("waxerve-bot started");
            // Join current thread
            Thread.currentThread().join();
        } catch (InterruptedException _) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            log.error("Registering waxerve-bot failed", e);
        }
        log.info("waxerve-bot shutting down");
    }
}
