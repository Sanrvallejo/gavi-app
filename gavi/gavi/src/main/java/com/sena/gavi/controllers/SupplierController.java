package com.sena.gavi.controllers;

import com.sena.gavi.model.entities.Supplier;
import com.sena.gavi.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/edit-supplier/{id}")
    public String editSupplier(
            @PathVariable UUID id,
            Model model) {
        model.addAttribute("nameHeader", viewName);
        Optional<Supplier> foundSupplier = supplierService.findById(id);
        Supplier supplier = foundSupplier.get();

        model.addAttribute("supplier", supplier);

        return "admin/edit-supplier";
    }

    @PostMapping("/update-supplier/{id}")
    public String updateSupplier(
            @PathVariable UUID id,
            @ModelAttribute Supplier incomingSupplier,
            RedirectAttributes redirectAttributes) {
        Optional<Supplier> optionalSupplier = supplierService.findById(id);
        Supplier foundSupplier = optionalSupplier.get();

        try {
            supplierService.update(incomingSupplier, foundSupplier);
            redirectAttributes.addFlashAttribute("message", "Supplier updated successfully");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error updating supplier");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }

        return "redirect:/suppliers";
    }


}
