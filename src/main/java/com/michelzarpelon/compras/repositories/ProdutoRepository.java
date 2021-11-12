package com.michelzarpelon.compras.repositories;

import com.michelzarpelon.compras.modal.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
