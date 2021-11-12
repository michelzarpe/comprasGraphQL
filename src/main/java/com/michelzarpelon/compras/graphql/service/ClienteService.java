package com.michelzarpelon.compras.graphql.service;

import com.michelzarpelon.compras.modal.Cliente;
import com.michelzarpelon.compras.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class ClienteService {


    @Autowired
    private ClienteRepository repository;

    public Cliente cliente(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Cliente> clientes(){
        return repository.findAll();
    }

    @Transactional
    public Cliente saveCliente(Cliente obj){
        return repository.save(obj);
    }
    @Transactional
    public Boolean deleteCliente(Long id){
        Cliente obj = this.cliente(id);
        if(obj!=null) {
            this.repository.delete(obj);
            return true;
        }
        return false;
    }

}
