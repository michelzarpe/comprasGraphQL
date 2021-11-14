package com.michelzarpelon.compras.graphql;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.michelzarpelon.compras.modal.Compra;
import com.michelzarpelon.compras.modal.CompraInput;
import com.michelzarpelon.compras.service.ClienteService;
import com.michelzarpelon.compras.service.CompraService;
import com.michelzarpelon.compras.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
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

    public List<Compra> compras(int page, int size){
        return service.findAll(PageRequest.of(page,size, Sort.by("quantidade").descending()));
    }

    public Compra saveCompra(CompraInput input){
        ModelMapper m = new ModelMapper();
        Compra c = m.map(input,Compra.class);
        c.setData(new Date());
        c.setProduto(produtoService.findById(input.getProdutoId()));
        c.setCliente(clienteService.findById(input.getClienteId()));
        return service.save(c);
    }

    public Boolean deleteCompra(Long id) {
        return this.service.deleteById(id);
    }
}
