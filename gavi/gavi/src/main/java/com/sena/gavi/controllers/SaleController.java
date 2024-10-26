package com.sena.gavi.controllers;

import com.sena.gavi.model.entities.Sale;
import com.sena.gavi.services.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private ISalesService saleService;

    @GetMapping("/sales")
    public String showSales(Model model) {
        model.addAttribute("salesList", saleService.findAll());
        return "intern/show-sales";
    }
}
