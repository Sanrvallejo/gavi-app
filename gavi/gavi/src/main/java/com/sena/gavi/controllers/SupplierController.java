package com.sena.gavi.controllers;

import com.sena.gavi.model.entities.Supplier;
import com.sena.gavi.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/save-supplier")
    public String saveSupplier(
            @ModelAttribute Supplier supplier,
            RedirectAttributes redirectAttributes,
            Model model) {
        model.addAttribute("nameHeader", viewName);
        try {
            supplierService.create(supplier);
            redirectAttributes.addFlashAttribute("message", "Supplier created successfully");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error creating supplier");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }

        return "redirect:/suppliers";
    }


}
