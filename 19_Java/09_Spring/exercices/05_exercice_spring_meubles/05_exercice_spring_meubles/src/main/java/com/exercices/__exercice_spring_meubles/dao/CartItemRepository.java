package com.exercices.__exercice_spring_meubles.dao;

import com.exercices.__exercice_spring_meubles.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
