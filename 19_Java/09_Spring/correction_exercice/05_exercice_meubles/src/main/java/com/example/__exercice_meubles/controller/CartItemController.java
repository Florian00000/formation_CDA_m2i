package com.example.__exercice_meubles.controller;

import com.example.__exercice_meubles.entity.CartItem;
import com.example.__exercice_meubles.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
public class CartItemController {
    private final CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping()
    public String getCart(Model model) {
        model.addAttribute("cartItems", cartItemService.getAllCartItems());
        return "cart";
    }

    @PostMapping("/add/{furnitureId}")
    public String addToCart(@PathVariable Long furnitureId, @RequestParam int quantity, RedirectAttributes redirectAttributes) {
        CartItem cartItem = new CartItem();
        cartItem.setFurnitureId(furnitureId);
        cartItem.setQuantity(quantity);
        String errorMessage = cartItemService.addToCart(cartItem);
        if (errorMessage != null) {
            redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
            return "redirect:/";
        }
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartItemService.removeFromCart(id);
        return "redirect:/cart";
    }

    @GetMapping("/clear")
    public String clearCart(){
        cartItemService.clearCart();
        return "redirect:/cart";
    }
}
