package com.michelzarpelon.compras.service;

import com.michelzarpelon.compras.modal.Cliente;
import com.michelzarpelon.compras.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente findById(Long id){
        return repository.findById(id).orElse(null);
    }

    @Cacheable("clientes")
    public List<Cliente> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Cliente save(Cliente obj){
        return repository.save(obj);
    }

    @Transactional
    public Boolean deleteById(Long id){
        Cliente obj = this.findById(id);
        if(obj!=null) {
            this.repository.delete(obj);
            return true;
        }
        return false;
    }

}

