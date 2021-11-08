package com.michelzarpelon.compras.resolvers;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.michelzarpelon.compras.modal.Cliente;
import com.michelzarpelon.compras.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    @Autowired
    private ClienteRepository repository;

    public String hello(){
        return "Ola pelo GraphQl";
    }

    public int soma(int a, int b){
        return a+b;
    }

    public Cliente cliente(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Cliente> clientes(){
        return repository.findAll();
    }


}
