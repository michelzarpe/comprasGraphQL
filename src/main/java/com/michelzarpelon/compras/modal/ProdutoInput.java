package com.michelzarpelon.compras.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProdutoInput {
    private Long id;
    private String nome;
    private double valor;
}
