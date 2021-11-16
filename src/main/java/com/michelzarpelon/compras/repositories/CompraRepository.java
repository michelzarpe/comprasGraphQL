package com.michelzarpelon.compras.repositories;

import com.michelzarpelon.compras.modal.Cliente;
import com.michelzarpelon.compras.modal.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    // caso desabilite (simpar da classe serviço os cash) os cash do spring para a jpa tem que mapear no repositorio as
    // query que precisam de cache conforme abaixo
    // @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    List<Compra> findAllByCliente(Cliente obj);
}
