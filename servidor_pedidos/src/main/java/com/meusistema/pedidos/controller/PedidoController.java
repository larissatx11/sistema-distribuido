package com.meusistema.pedidos.controller;

import com.meusistema.pedidos.model.Pedido;
import com.meusistema.pedidos.repositories.PedidoRepository;
import com.meusistema.pedidos.service.PagamentoServiceRMI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final PagamentoServiceRMI pagamentoServiceRMI; // Injeção do serviço RMI

    public PedidoController(PedidoRepository pedidoRepository, PagamentoServiceRMI pagamentoServiceRMI) {
        this.pedidoRepository = pedidoRepository;
        this.pagamentoServiceRMI = pagamentoServiceRMI;
    }

    @PostMapping("/criarPedido")
    public ResponseEntity<String> criarPedido(@RequestBody Pedido pedido) {
        try {
            // Chama o serviço de pagamento antes de salvar o pedido
            boolean respostaPagamento = pagamentoServiceRMI.processarPagamento(pedido.getId(), pedido.getValor());

            if (respostaPagamento == true) {
                pedidoRepository.save(pedido); // Salva no banco apenas se for aprovado
                
                System.out.println("✅ Pedido criado e pagamento aprovado.");
                return ResponseEntity.ok("✅ Pedido criado e pagamento aprovado.");
            } else {
                return ResponseEntity.status(400).body("❌ Pedido não pode ser concluído. Pagamento recusado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("❌ Erro ao processar pagamento: " + e.getMessage());
        }
    }
}
