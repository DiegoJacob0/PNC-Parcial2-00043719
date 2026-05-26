package org.example.parcial02.repository;

import org.example.parcial02.model.MagicArticle;
import org.example.parcial02.model.MagicProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MagicRepository extends JpaRepository<MagicArticle, Long> {
    List<MagicArticle> findByNameIgnoreCase(String name);
    List<MagicArticle> findByCategoryAndAvailable(MagicProvider magicProvider, Boolean available);
}