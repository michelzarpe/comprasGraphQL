package com.michelzarpelon.compras.graphql;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.michelzarpelon.compras.modal.Cliente;
import com.michelzarpelon.compras.modal.ClienteInput;
import com.michelzarpelon.compras.modal.Produto;
import com.michelzarpelon.compras.modal.ProdutoInput;
import com.michelzarpelon.compras.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ProdutoService service;

    public Produto produto(Long id){
        return service.findById(id);
    }

    public List<Produto> produtos(){
        return service.findAll();
    }

    public Produto saveProduto(ProdutoInput produtoInput){
        return service.save(Produto.builder()
                .id(produtoInput.getId())
                .nome(produtoInput.getNome())
                .valor(produtoInput.getValor())
                .build());

    }

    public Boolean deleteProduto(Long id) {
        return this.service.deleteById(id);
    }

}
