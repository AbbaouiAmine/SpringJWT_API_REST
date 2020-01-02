package com.example.demo.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entities.Product;

@CrossOrigin("*")
@RestController
public class ProductRestAPI {
	
	 	@Autowired
	    ProductRepository produitRepository;

	

	    @GetMapping(value = "listProducts")
	    public List<Product>  list_Produits()
	    {
	        return  produitRepository.findAll();
	    }

	    @GetMapping(value = "products/{id}")
	    public Product listsProduits(@PathVariable(name = "id") String id)
	    {
	        return  produitRepository.findById(id).get();
	    }

	    @PutMapping(value = "products/{id}")
	    public Product update(@PathVariable(name = "id") String id,@RequestBody Product p)
	    {
	        p.setId(id);
	        return  produitRepository.save(p);
	    }

	    @DeleteMapping(value = "products/{id}")
	    public void delete(@PathVariable(name = "id") String id)
	    {
	          produitRepository.deleteById(id);
	    }
}
