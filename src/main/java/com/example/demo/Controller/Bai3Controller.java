package com.example.demo.Controller;




import com.example.demo.Entity.Report;
import com.example.demo.Repo.ProductDAO;
import com.example.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class Bai3Controller {
    @Autowired
    ProductDAO repo;

    @Autowired
    SessionService session;

    @RequestMapping("/bai3")
    public String inventory(Model model) {
        List<Report> items = repo.getInventoryByCategory();
        model.addAttribute("items", items);
        return "bai3";
    }
}
