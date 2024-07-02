package com.example.__exercice_meubles.dao;

import com.example.__exercice_meubles.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
