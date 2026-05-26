package org.example.parcial02.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.parcial02.model.MagicArticle;
import org.example.parcial02.model.MagicProvider;
import org.example.parcial02.service.MagicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/magic_wand")
    @RequiredArgsConstructor

    public class MagicController {

        private final MagicService service;

        @PostMapping
        public ResponseEntity<MagicArticle> create(
                @Valid @RequestBody MagicArticle magicArticle) {

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(service.create(magicArticle));
        }

        @GetMapping
        public ResponseEntity<List<MagicArticle>> getAll(
                @RequestParam(required = false)
                MagicProvider magicProvider,

                @RequestParam(required = false)
                Boolean available) {



            return ResponseEntity.ok(service.getAll());
        }

        @GetMapping("/provider/{id}")
        public ResponseEntity<MagicArticle> getById(
                @PathVariable Long id) {

            return ResponseEntity.ok(
                    service.getById(id)
            );
        }

        @PutMapping("/{id}")
        public ResponseEntity<MagicArticle> update(
                @PathVariable Long id,
                @Valid @RequestBody MagicArticle magicArticle) {

            return ResponseEntity.ok(
                    service.update(id, magicArticle)
            );
        }

        @DeleteMapping("/providers/{id}")
        public ResponseEntity<Void> delete(
                @PathVariable Long id) {

            service.delete(id);

            return ResponseEntity.noContent().build();
        }




}
