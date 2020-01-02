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

import com.example.demo.dao.CategoryRepository;
import com.example.demo.entities.Category;

@CrossOrigin("*")
@RestController
public class CategorieRestAPI {
	@Autowired
    CategoryRepository categoryRepository;



    @GetMapping(value = "listCategories")
    public List<Category>  list_Categories()
    {
        return  categoryRepository.findAll();
    }

    @GetMapping(value = "Categories/{id}")
    public Category listsCategoris(@PathVariable(name = "id") String id)
    {
        return  categoryRepository.findById(id).get();
    }

    @PutMapping(value = "Categories/{id}")
    public Category update(@PathVariable(name = "id") String id,@RequestBody Category c)
    {
        c.setId(id);
        return  categoryRepository.save(c);
    }

    @DeleteMapping(value = "Categories/{id}")
    public void delete(@PathVariable(name = "id") String id)
    {
          categoryRepository.deleteById(id);
    }
}
