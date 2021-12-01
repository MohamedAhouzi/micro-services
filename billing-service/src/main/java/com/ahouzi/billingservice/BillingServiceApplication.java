package com.ahouzi.billingservice;

import com.ahouzi.billingservice.entities.Bill;
import com.ahouzi.billingservice.entities.Customer;
import com.ahouzi.billingservice.entities.Product;
import com.ahouzi.billingservice.entities.ProductItem;
import com.ahouzi.billingservice.feign.CustomerRestClient;
import com.ahouzi.billingservice.feign.ProductItemRestClient;
import com.ahouzi.billingservice.repositories.BillRepository;
import com.ahouzi.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            ProductItemRestClient productItemRestClient){
        return args -> {
            Customer customer= customerRestClient.findCustomerById(1l);
            Bill bill1=billRepository.save(new Bill(null,new Date(),null,customer.getId(),null));
            PagedModel<Product> productPagedModel =productItemRestClient.pageProducts(0,3);
            productPagedModel.forEach(product -> {
                ProductItem productItem=new ProductItem();
                productItem.setPrice(product.getPrice());
                productItem.setBill(bill1);
                productItem.setQuantity(1+new Random().nextInt(100));
                productItem.setProductID(product.getId());
                productItemRepository.save(productItem);
                 });
        };


    }

}
