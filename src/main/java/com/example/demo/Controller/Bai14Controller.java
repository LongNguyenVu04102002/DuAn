package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import com.example.demo.Repo.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class Bai14Controller {
    @Autowired
    ProductDAO repo;

    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/bai1")
    public String search(Model model, @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> items = repo.findByPriceBetween(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "bai1";
    }
}
