package com.michelzarpelon.compras.service;

import com.michelzarpelon.compras.modal.Cliente;
import com.michelzarpelon.compras.modal.Compra;
import com.michelzarpelon.compras.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    CompraRepository repository;

    public Compra findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Compra> findAll(Pageable of){
        return repository.findAll(of).getContent();
    }

    public List<Compra> findAllByCliente(Cliente obj) {return repository.findAllByCliente(obj);}

    @Transactional
    public Compra save(Compra obj){
        return repository.save(obj);
    }

    @Transactional
    public Boolean deleteById(Long id){
        Compra obj = this.findById(id);
        if(obj!=null) {
            this.repository.delete(obj);
            return true;
        }
        return false;
    }

}

