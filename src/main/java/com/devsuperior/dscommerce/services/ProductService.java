package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.DTO.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
       Optional<Product> result = repository.findById(id);
       Product product = result.get();
       ProductDTO dto = new ProductDTO(product);
       return dto;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> result = repository.findAll();
        return result.stream().map(product -> new ProductDTO(product)).toList();
    }
}