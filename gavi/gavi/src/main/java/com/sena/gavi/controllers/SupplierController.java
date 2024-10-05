package com.sena.gavi.controllers;

import com.sena.gavi.model.entities.Supplier;
import com.sena.gavi.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    String viewName = "Supplier";

    @Autowired
    private ISupplierService supplierService;

    @GetMapping("")
    public String showSuppliers(Model model) {
        model.addAttribute("nameHeader", viewName);
        model.addAttribute("suppliersList", supplierService.findAll());
        return "admin/show-suppliers";
    }
    @GetMapping("/create-supplier")
    public String createSupplier(Model model) {
        model.addAttribute("nameHeader", viewName);
        return "admin/create-supplier";
    }


}
