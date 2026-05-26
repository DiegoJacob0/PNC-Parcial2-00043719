package org.example.parcial02.service;


import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.example.parcial02.exception.ResourceNotFoundException;
import org.example.parcial02.model.MagicArticle;
import org.example.parcial02.model.MagicProvider;
import org.example.parcial02.repository.MagicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor



public class MagicServiceImpl implements MagicService {

    private final MagicRepository repository;

    @Override
    public MagicArticle create(MagicArticle magicArticle) {

        repository.findByNameIgnoreCase(magicArticle.getName())
                .ifPresent(p -> {
                    throw new BadRequestException(
                            "article already exists"
                    );
                });


        return repository.save(magicArticle);
    }

    @Override
    public List<MagicArticle> getAll() {
        return repository.findAll();
    }

    @Override
    public MagicArticle getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "provider not found"
                        ));
    }

    @Override
    public MagicArticle update(Long id, MagicArticle magicArticle) {

        MagicArticle existing = getById(id);


        existing.setName(MagicArticle.getname());
        existing.setPrice(MagicArticle.getPrice());



        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {

        MagicArticle magicArticle = getById(id);

        if (magicArticle.getMagicProvider() == MagicProvider.NAME
                && Boolean.TRUE.equals(magicArticle.getId())) {

            throw new BadRequestException(
                    "Can not delete it"
            );
        }

        repository.delete(magicArticle);
    }

    @Override
    public List<MagicArticle> filterByPrice(String price) {
        return List.of();
    }

    @Override
    public List<MagicArticle> filterByProvider(String language) {
        return List.of();
    }

    @Override
    public List<MagicArticle> filterByProvider(String Type, String Name) {
        return List.of();
    }


    @Override
    public List<MagicArticle> filter(MagicProvider magicProvider,
                                Boolean available) {

        return repository.findByCategoryAndAvailable(
                magicProvider,
                available
        );
    }
}