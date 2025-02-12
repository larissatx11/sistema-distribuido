package com.meusistema.pedidos.controller;

import org.springframework.web.bind.annotation.*;
import com.meusistema.pedidos.service.PagamentoServiceRMI;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    private final PagamentoServiceRMI pagamentoService;

    public PagamentoController(PagamentoServiceRMI pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/testar")
    public String testarPagamento() {
        return "O servidor está respondendo corretamente!";
    }

    @PostMapping("/processar")
    public boolean processarPagamento(@RequestParam Long pedidoId, @RequestParam double valor) {
        return pagamentoService.processarPagamento(pedidoId, valor);
    }
}
