package com.michelzarpelon.compras.graphql;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.michelzarpelon.compras.modal.Cliente;
import com.michelzarpelon.compras.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteRepository repository;

    public Cliente cliente(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Cliente> clientes(){
        return repository.findAll();
    }

    @Transactional
    public Cliente saveCliente(Long id, String nome, String email){
        return repository.save(Cliente.builder()
                        .id(id)
                        .nome(nome)
                        .email(email)
                        .build());
    }

}
