package com.exercices.__exercice_spring_meubles.controller;

import com.exercices.__exercice_spring_meubles.entities.CartItem;
import com.exercices.__exercice_spring_meubles.service.CartItemService;
import com.exercices.__exercice_spring_meubles.service.FurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartItemController {

    private final CartItemService cartItemService;
    private final FurnitureService furnitureService;

    @Autowired
    public CartItemController(CartItemService cartItemService, FurnitureService furnitureService) {
        this.cartItemService = cartItemService;
        this.furnitureService = furnitureService;
    }

    @GetMapping("/cartItem")
    public String cartItems(Model model) {
        model.addAttribute("cartItems", cartItemService.getAllCartItems());

        return "cartItems/cartItemList";
    }

    @GetMapping("/panier/add/{id_furniture}")
    public String panierAdd(@PathVariable("id_furniture") int idFurniture, Model model) {
        model.addAttribute("cartItem",
                CartItem.builder().furniture(furnitureService.getFurnitureById(idFurniture)).build());
        return "cartItems/cartItemForm";
    }

    @PostMapping("/panier/add")
    public String panierAdd(@ModelAttribute("cartItem") CartItem cartItem) {
        cartItemService.addToCart(cartItem);
        return "redirect:/cartItem";
    }
}
