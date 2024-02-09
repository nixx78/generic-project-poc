package lv.nixx.poc.second;

import lv.nixx.poc.common.config.db.AlphaDB;
import lv.nixx.poc.common.config.db.BetaDB;
import lv.nixx.poc.common.security.LoggedUserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@AlphaDB(packageToScan = "lv.nixx.poc.second.orm.alpha")
@BetaDB(packageToScan = "lv.nixx.poc.second.orm.beta")

@LoggedUserController
public class AppRunner {

    public static void main(String[] args) {
        SpringApplication.run(AppRunner.class, args);
    }

}