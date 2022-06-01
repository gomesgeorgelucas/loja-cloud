package org.letscode.servicovenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class ServicoVendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicoVendaApplication.class, args);
    }

}
