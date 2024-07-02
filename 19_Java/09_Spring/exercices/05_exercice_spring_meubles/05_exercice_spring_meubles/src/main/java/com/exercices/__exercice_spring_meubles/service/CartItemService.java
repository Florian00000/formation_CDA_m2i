package com.exercices.__exercice_spring_meubles.service;

import com.exercices.__exercice_spring_meubles.dao.CartItemRepository;
import com.exercices.__exercice_spring_meubles.dao.FurnitureRepository;
import com.exercices.__exercice_spring_meubles.entities.CartItem;
import com.exercices.__exercice_spring_meubles.entities.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final FurnitureRepository furnitureRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository, FurnitureRepository furnitureRepository) {
        this.cartItemRepository = cartItemRepository;
        this.furnitureRepository = furnitureRepository;
    }

    //TODO Finir  les méthodes du service

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public boolean addToCart(CartItem cartItem) {
        int quantity = cartItem.getQuantity();
        if (cartItem.getFurniture().getStock() - quantity < 0) {
            return false;
        }else {
            Furniture furnitureUpdated = cartItem.getFurniture();
            furnitureUpdated.setStock(furnitureUpdated.getStock() - quantity);
            furnitureRepository.save(furnitureUpdated);
            cartItemRepository.save(cartItem);
            return true;
        }

    }

    public void removeFromCart(CartItem cartItem){
        cartItemRepository.delete(cartItem);
    }

    public void clearCart(){
        cartItemRepository.deleteAll();
    }
}
