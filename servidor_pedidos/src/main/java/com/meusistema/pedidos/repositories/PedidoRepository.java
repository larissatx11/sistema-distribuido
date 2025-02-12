package com.meusistema.pedidos.repositories;

import com.meusistema.pedidos.model.Pedido;
import com.meusistema.pedidos.repositories.PedidoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
