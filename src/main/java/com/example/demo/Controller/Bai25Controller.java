package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import com.example.demo.Repo.ProductDAO;
import com.example.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class Bai25Controller {
    @Autowired
    ProductDAO repo;

    @Autowired
    SessionService session;

    @RequestMapping("/bai2")
    public String searchAndPage(Model model, @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p) {
        String keywords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", keywords);
        Pageable pageable = PageRequest.of(p.orElse(0), 10);
        Page<Product> page = repo.findAllByNameLike("%" + keywords + "%", pageable);
        model.addAttribute("page", page);
        return "bai2";
    }
}