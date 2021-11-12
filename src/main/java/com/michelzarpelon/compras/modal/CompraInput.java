package com.michelzarpelon.compras.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompraInput {

    private Long id;
    private Integer quantidade;
    private String status;
    private Long clienteId;
    private Long produtoId;
}
