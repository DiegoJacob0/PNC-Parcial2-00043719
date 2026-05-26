package org.example.parcial02.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "magic_wand")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MagicArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "id must to be exist")
    @Pattern(
            regexp = ".*[a-zA-Z]+.*"
    )

    private String name;

    @NotBlank(message = "Name is requerired")

    private Enum type;


    @Enumerated(EnumType.STRING)
    private MagicProvider provider;


    @NotBlank(message = "")
    @Column(unique = true)
    private String isbn;


    @NotNull (message = "Price must to be greater than 0")
    private BigDecimal price;


}