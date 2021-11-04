package com.michelzarpelon.compras;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello(){
        return "Ola pelo GraphQl";
    }

    public int soma(int a, int b){
        return a+b;
    }

}
