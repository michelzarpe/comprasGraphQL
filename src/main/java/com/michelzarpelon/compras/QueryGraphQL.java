package com.michelzarpelon.compras;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.michelzarpelon.compras.modal.Cliente;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello(){
        return "Ola pelo GraphQl";
    }

    public int soma(int a, int b){
        return a+b;
    }

    public Cliente cliente(){
        return Cliente.builder()
                .email("teste@email.com")
                .nome("nome sobrenome")
                .build();
    }

    public List<Cliente> clientes(){
        return Arrays.asList(this.cliente(),this.cliente());
    }


}
