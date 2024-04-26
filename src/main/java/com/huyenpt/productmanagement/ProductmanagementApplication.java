package com.huyenpt.productmanagement;

import com.huyenpt.productmanagement.service.impl.ProductImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.huyenpt"})
@EntityScan(basePackages = {"com.huyenpt.productio.entity"})
@EnableJpaRepositories(basePackages = "com.huyenpt.productio.repository")
public class ProductmanagementApplication {
    private static final Logger logger = LoggerFactory.getLogger(ProductImpl.class);
    public static void main(String[] args) {
        SpringApplication.run(ProductmanagementApplication.class, args);
        logger.info("\n----------------------------------------------------------\n\t" +
                "Product API is running! \n\t" +
                "----------------------------------------------------------");
    }
}
