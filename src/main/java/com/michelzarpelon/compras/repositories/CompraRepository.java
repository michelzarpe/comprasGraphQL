package com.michelzarpelon.compras.repositories;

import com.michelzarpelon.compras.modal.Cliente;
import com.michelzarpelon.compras.modal.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAllByCliente(Cliente obj);
}
