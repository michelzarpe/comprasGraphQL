package com.michelzarpelon.compras.service;

import com.michelzarpelon.compras.modal.Produto;
import com.michelzarpelon.compras.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

    @Transactional
    public Produto save(Produto obj){
        return repository.save(obj);
    }

    @Transactional
    public Boolean deleteById(Long id){
        Produto obj = this.findById(id);
        if(obj!=null) {
            this.repository.delete(obj);
            return true;
        }
        return false;
    }

}
