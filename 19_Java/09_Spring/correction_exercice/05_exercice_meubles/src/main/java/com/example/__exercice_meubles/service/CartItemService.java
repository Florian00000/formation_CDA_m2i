package com.example.__exercice_meubles.service;

import com.example.__exercice_meubles.dao.CartItemRepository;
import com.example.__exercice_meubles.entity.CartItem;
import com.example.__exercice_meubles.entity.Furniture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService implements ICartItemService {
    private final CartItemRepository cartItemRepository;
    private final FurnitureService furnitureService;

    public CartItemService(CartItemRepository cartItemRepository, FurnitureService furnitureService) {
        this.cartItemRepository = cartItemRepository;
        this.furnitureService = furnitureService;
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public String addToCart(CartItem cartItem) {
        Furniture furnitureExist = furnitureService.getFurnitureById(cartItem.getFurnitureId());
        if (furnitureExist.getId() != null) {
            if (furnitureExist.getStock() >= cartItem.getQuantity()) {
                furnitureExist.setStock(furnitureExist.getStock() - cartItem.getQuantity());
                furnitureService.saveFurniture(furnitureExist);
                cartItemRepository.save(cartItem);
            } else {
                return "La quantitée en stock n'est pas suffisante !";
            }
        }
        return null;
    }

    @Override
    public void removeFromCart(Long id) {
        CartItem cartItem = cartItemRepository.findById(id).orElse(null);
        if (cartItem != null) {
            Furniture furnitureExist = furnitureService.getFurnitureById(cartItem.getFurnitureId());
            if (furnitureExist.getId() != null) {
                furnitureExist.setStock(furnitureExist.getStock() + cartItem.getQuantity());
                furnitureService.saveFurniture(furnitureExist);
                cartItemRepository.delete(cartItem);
            }
        }
    }

    @Override
    public void clearCart() {
        List<CartItem> cartItemList = cartItemRepository.findAll();
        for (CartItem cartItem : cartItemList) {
            Furniture furnitureExist = furnitureService.getFurnitureById(cartItem.getFurnitureId());
            if (furnitureExist.getId() != null) {
                furnitureExist.setStock(furnitureExist.getStock() + cartItem.getQuantity());
                furnitureService.saveFurniture(furnitureExist);
            }
        }
        cartItemRepository.deleteAll();
    }
}
