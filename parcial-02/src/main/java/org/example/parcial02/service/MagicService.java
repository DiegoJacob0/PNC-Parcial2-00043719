package org.example.parcial02.service;

import org.example.parcial02.model.MagicArticle;

import java.util.List;

public interface MagicService {

    MagicArticle create(MagicArticle magicArticle);

    List<MagicArticle> getAll();

    MagicArticle getById(Long id); //por ID

    MagicArticle update(Long id, MagicArticle magicArticle);

    void delete(Long id); //DELETE

    List<MagicArticle> filterByPrice(String price);

    List<MagicArticle> filterByProvider(String language);

    List<MagicArticle> filterByProvider(
            String Type,
            String Name
    );
}