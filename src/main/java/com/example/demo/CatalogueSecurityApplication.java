package com.example.demo;

import com.example.demo.dao.CategoryRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

@SpringBootApplication
public class CatalogueSecurityApplication implements CommandLineRunner {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(CatalogueSecurityApplication.class, args);
	}

	/*
	 * @Bean CommandLineRunner start(CategoryRepository categoryRepository,
	 * ProductRepository productRepository) { return args -> {
	 * categoryRepository.deleteAll();
	 * Stream.of("Ordinateurs","Imprimantes","Portables").forEach(c->{
	 * categoryRepository.save(new Category("C1",c,new ArrayList<>())); });
	 * categoryRepository.findAll().forEach(System.out::println);
	 * 
	 * productRepository.deleteAll(); Category
	 * c1=categoryRepository.findById("C1").get();
	 * System.out.println(c1.toString()); Stream.of("P1","P2","P3").forEach(name->{
	 * Product p= productRepository.save(new
	 * Product(null,name,Math.random()*1000,c1)); c1.getProducts().add(p);
	 * categoryRepository.save(c1); });
	 * productRepository.findAll().forEach(p->{System.out.println(p.toString());});
	 * 
	 * System.out.println("Hello"); }; }
	 */

	@Override
	public void run(String... args) throws Exception {
		
		categoryRepository.deleteAll();
		Category c1=categoryRepository.save(new Category("C1","Ordinateurs",new ArrayList<Product>()));
		Category c2=categoryRepository.save(new Category("C2","Imprimantes",new ArrayList<Product>()));
		Category c3=categoryRepository.save(new Category("C3","Portables",new ArrayList<Product>()));
		Category c4=categoryRepository.save(new Category("C4","Cables",new ArrayList<Product>()));
		Category c5=categoryRepository.save(new Category("C5","Accessoires",new ArrayList<Product>()));
		
		categoryRepository.findAll().forEach(System.out::println);
		
		productRepository.deleteAll();
		
		Product p1 = productRepository.save(new Product(null,"Hp leazer",Math.random()*1000,c1));
		Product p2 =productRepository.save(new Product(null,"Hp 233XP 55",Math.random()*1000,c1));
		Product p3 =productRepository.save(new Product(null,"Sony SSD KS",Math.random()*1000,c1));
		
		
		Product p4 =productRepository.save(new Product(null,"Lenovo T440",Math.random()*1000,c1));
		Product p5 =productRepository.save(new Product(null,"HP S433",Math.random()*1000,c1));
		Product p6 =productRepository.save(new Product(null,"Dell 453",Math.random()*1000,c1));
		Product p7 =productRepository.save(new Product(null,"Lenovo S55",Math.random()*1000,c1));
		Product p8 =productRepository.save(new Product(null,"HP SRE 654",Math.random()*1000,c1));
		
		Product p9 =productRepository.save(new Product(null,"Sumsung Edge",Math.random()*1000,c1));
		Product p10 =productRepository.save(new Product(null,"Oppoo 43E",Math.random()*1000,c1));
		
		Product p11 =productRepository.save(new Product(null,"Chargeur Lenovo 54",Math.random()*1000,c1));
		Product p12 =productRepository.save(new Product(null,"KeyBoard Hp 65",Math.random()*1000,c1));
		productRepository.findAll().forEach(System.out::println);
		
		c2.getProducts().add(p1);
		c2.getProducts().add(p2);
		c2.getProducts().add(p3);
		
		c1.getProducts().add(p4);
		c1.getProducts().add(p5);
		c1.getProducts().add(p6);
		c1.getProducts().add(p7);
		c1.getProducts().add(p8);
		
		c3.getProducts().add(p9);
		c3.getProducts().add(p10);
		
		c4.getProducts().add(p11);
		
		c5.getProducts().add(p12);
		
		categoryRepository.save(c1);
		categoryRepository.save(c2);
		categoryRepository.save(c3);
		categoryRepository.save(c4);
		categoryRepository.save(c5);
		
	
		
	}
}
