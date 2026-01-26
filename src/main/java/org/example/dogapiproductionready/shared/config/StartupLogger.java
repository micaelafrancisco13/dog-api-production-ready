package org.example.dogapiproductionready.shared.config;

import org.slf4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartupLogger implements ApplicationRunner {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(StartupLogger.class);

    private final Environment env;

    public StartupLogger(Environment env) {
        this.env = env;
    }

    @Override
    public void run(ApplicationArguments args) {
        String[] active = env.getActiveProfiles();
        String[] defaults = env.getDefaultProfiles();

        log.info("Active profiles: {}", (active.length == 0 ? "<none>" : Arrays.toString(active)));
        log.info("Default profiles: {}", Arrays.toString(defaults));
        log.info("App environment property (app.environment): {}", env.getProperty("app.environment", "<not set>"));
    }
}
