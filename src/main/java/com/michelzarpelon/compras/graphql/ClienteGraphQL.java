package com.michelzarpelon.compras.graphql;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.michelzarpelon.compras.graphql.service.ClienteService;
import com.michelzarpelon.compras.modal.Cliente;

import com.michelzarpelon.compras.modal.ClienteInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService service;

    public Cliente cliente(Long id){
        return service.cliente(id);
    }

    public List<Cliente> clientes(){
        return service.clientes();
    }

    public Cliente saveCliente(ClienteInput clienteInput){
        return service.saveCliente(Cliente.builder()
                .id(clienteInput.getId())
                .nome(clienteInput.getNome())
                .email(clienteInput.getEmail())
                .build());

        //ModelMapper m = new ModelMapper();
        //Cliente c = m.map(clienteInput,Cliente.class);

    }

    public Boolean deleteCliente(Long id) {
        return this.service.deleteCliente(id);
    }
}
