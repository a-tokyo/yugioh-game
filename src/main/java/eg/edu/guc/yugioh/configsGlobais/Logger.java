package eg.edu.guc.yugioh.configsGlobais;

import org.slf4j.LoggerFactory;

public class Logger {

    private static final ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("");

    public static ch.qos.logback.classic.Logger logs() {

        return logger;

    }
}
