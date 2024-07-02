package com.example.__exercice_meubles.service;

import com.example.__exercice_meubles.entity.CartItem;

import java.util.List;

public interface ICartItemService {
    List<CartItem> getAllCartItems();
    String addToCart(CartItem cartItem);
    void removeFromCart(Long id);
    void clearCart();
}
