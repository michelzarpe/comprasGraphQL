package com.michelzarpelon.compras.repositories;

import com.michelzarpelon.compras.modal.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
