package com.michelzarpelon.compras.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.michelzarpelon.compras.modal.Cliente;
import com.michelzarpelon.compras.modal.Compra;
import com.michelzarpelon.compras.modal.Produto;
import com.michelzarpelon.compras.service.ClienteService;
import com.michelzarpelon.compras.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public String status(Compra obj){
        return "teste: "+ obj.getStatus();
    }

    public Cliente cliente (Compra obj) { return clienteService.findById(obj.getCliente().getId());};

    public Produto produto (Compra obj) { return produtoService.findById(obj.getProduto().getId());};

}
