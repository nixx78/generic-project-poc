package lv.nixx.poc.second;

import lv.nixx.poc.common.config.db.AlphaDB;
import lv.nixx.poc.common.config.db.BetaDB;
import lv.nixx.poc.common.security.config.LoggedUserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static lv.nixx.poc.common.security.config.UserFields.NAME;
import static lv.nixx.poc.common.security.config.UserFields.ROLES;

@SpringBootApplication

@AlphaDB(packageToScan = "lv.nixx.poc.second.orm.alpha")
@BetaDB(packageToScan = "lv.nixx.poc.second.orm.beta")

@LoggedUserController(fields = {NAME, ROLES})
public class AppRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppRunner.class, args);
    }

}