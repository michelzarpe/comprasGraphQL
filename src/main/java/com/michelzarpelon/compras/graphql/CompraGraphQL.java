package com.michelzarpelon.compras.graphql;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.michelzarpelon.compras.modal.Cliente;
import com.michelzarpelon.compras.modal.ClienteInput;
import com.michelzarpelon.compras.modal.Compra;
import com.michelzarpelon.compras.modal.CompraInput;
import com.michelzarpelon.compras.service.ClienteService;
import com.michelzarpelon.compras.service.CompraService;
import com.michelzarpelon.compras.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {


    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CompraService service;

    public Compra compra(Long id){
        return service.findById(id);
    }

    public List<Compra> compras(){
        return service.findAll();
    }

    public Compra saveCompra(CompraInput input){
        ModelMapper m = new ModelMapper();
        Compra c = m.map(input,Compra.class);
        c.setProduto(produtoService.findById(input.getProdutoId()));
        c.setCliente(clienteService.findById(input.getClienteId()));
        return c;
    }

    public Boolean deleteCompra(Long id) {
        return this.service.deleteById(id);
    }
}