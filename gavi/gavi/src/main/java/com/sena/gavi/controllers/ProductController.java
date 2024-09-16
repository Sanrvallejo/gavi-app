package com.sena.gavi.controllers;

import com.sena.gavi.enums.Category;
import com.sena.gavi.enums.Tax;
import com.sena.gavi.enums.Units;
import com.sena.gavi.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showProducts(Model model) {
        model.addAttribute("productslist", productService.getAllProducts());
        return "admin/show-products";
    }

    @GetMapping("/create-product")
    public String createProduct(Model model) {
        //pasar los enum como atributos para los select de la vista
        model.addAttribute("categories", Category.values());//categorias
        model.addAttribute("units", Units.values());//unidades
        // proveedores
        model.addAttribute("taxes", Tax.values());//impuestos
        return "admin/create-product";
    }
}
