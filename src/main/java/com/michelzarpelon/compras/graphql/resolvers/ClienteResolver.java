package com.michelzarpelon.compras.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.michelzarpelon.compras.modal.Cliente;
import com.michelzarpelon.compras.modal.Compra;
import com.michelzarpelon.compras.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

    @Autowired
    private CompraService compraService;

    public List<Compra> compras(Cliente obj) { return compraService.findAllByCliente(obj); }

}
