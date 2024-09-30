package com.sena.gavi.controllers;

import com.sena.gavi.enums.Category;
import com.sena.gavi.enums.Tax;
import com.sena.gavi.enums.Units;
import com.sena.gavi.model.entities.Product;
import com.sena.gavi.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
import java.util.UUID;

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
        model.addAttribute("nameHeader", viewName);
        //pasar los enum como atributos para los select de la vista
        model.addAttribute("categories", Category.values());//categorias
        model.addAttribute("units", Units.values());//unidades
        // proveedores
        model.addAttribute("taxes", Tax.values());//impuestos
        return "admin/create-product";
    }

    //metodo para guardar un producto
    @PostMapping("/save-product")
    public String saveProduct(
            @ModelAttribute Product product,
            Model model,
            RedirectAttributes redirectAttributes) {
        model.addAttribute("nameHeader", viewName);
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

    //obtener producto por id
    @GetMapping("/{id}")
    public Optional<Product> getProduct(
            @PathVariable UUID id) {
        return productService.getProduct(id);
    }

    //obtener producto por codigo
    @GetMapping("/code/{code}")
    public Optional<Product> getProductByCode(
            @PathVariable String code) {
        return productService.getByCode(code);
    }

    //vista para editar un producto
    @GetMapping("/edit/{id}")
    public String editProduct(
            @PathVariable UUID id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Product> optionalProduct = productService.getProduct(id);
        Product product = optionalProduct.get();

        model.addAttribute("nameHeader", viewName);
        //pasar los enum como atributos para los select de la vista
        model.addAttribute("categories", Category.values());//categorias
        model.addAttribute("units", Units.values());//unidades
        // proveedores
        model.addAttribute("taxes", Tax.values());//impuestos

        //pasar el producto encontrado
        model.addAttribute("product", product);
        return "admin/edit-product";
    }

    @PostMapping("/update-product/{id}")
    public String updateProduct(
            @PathVariable UUID id,
            @ModelAttribute Product incomingProduct,
            RedirectAttributes redirectAttributes) {

        //aquí se verifica que el producto exista
        Optional<Product> optionalProduct = productService.getProduct(id);
        Product foundProduct = optionalProduct.get();

        //delegar la actualización al servicio
        try {
            productService.update(incomingProduct, foundProduct);
            redirectAttributes.addFlashAttribute("message", "Product updated successfully");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
            return "redirect:/products";
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error updating product");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/products";
        }
    }

}
