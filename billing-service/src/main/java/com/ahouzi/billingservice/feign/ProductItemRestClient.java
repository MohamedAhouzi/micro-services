package com.ahouzi.billingservice.feign;

import com.ahouzi.billingservice.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductItemRestClient {
    @GetMapping("/products/{id}")
    Product findProductById(@PathVariable("id") Long id);

    @GetMapping("/products")
    PagedModel<Product> pageProducts(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size);
}
