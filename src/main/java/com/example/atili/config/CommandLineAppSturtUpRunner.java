package com.example.atili.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppSturtUpRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Flyway.configure().baselineOnMigrate(true).dataSource("jdbc:postgresql://localhost:5432/atili_db", "postgres", "root").load().migrate();
//        Flyway.configure().load().repair();
    }
}
