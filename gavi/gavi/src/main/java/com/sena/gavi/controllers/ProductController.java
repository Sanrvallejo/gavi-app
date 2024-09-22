package com.sena.gavi.controllers;

import com.sena.gavi.enums.Category;
import com.sena.gavi.enums.Tax;
import com.sena.gavi.enums.Units;
import com.sena.gavi.model.entities.Product;
import com.sena.gavi.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    String viewName = "Inventory";

    @GetMapping("")
    public String showProducts(Model model) {
        model.addAttribute("nameHeader", viewName);
        model.addAttribute("productslist", productService.getAllProducts());
        return "admin/show-products";
    }

    //vista para crear un producto
    @GetMapping("/create-product")
    public String createProduct(Model model) {
        //pasar los enum como atributos para los select de la vista
        model.addAttribute("categories", Category.values());//categorias
        model.addAttribute("units", Units.values());//unidades
        // proveedores
        model.addAttribute("taxes", Tax.values());//impuestos
        return "admin/create-product";
    }

    @PostMapping("/save-product")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        try {
            productService.save(product);
            redirectAttributes.addFlashAttribute("message", "Product created successfully");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error creating product");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }

        return "redirect:/products";
    }
}
