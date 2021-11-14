package com.michelzarpelon.compras.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.michelzarpelon.compras.modal.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto> {

    public String valorReais(Produto obj){
        return "R$: "+ obj.getValor();
    }
}
