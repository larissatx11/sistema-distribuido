package com.meusistema.pedidos.service;

import org.springframework.stereotype.Service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.sistemapag.service.IPagamentoService;

@Service
public class PagamentoServiceRMI {
    private IPagamentoService pagamentoService;

    public PagamentoServiceRMI() {
        try {
            // Forçar o carregamento da classe
            Class.forName("com.sistemapag.service.IPagamentoService");

            // Conectar ao Registry RMI do Servidor de Pagamentos na porta 1099
            Registry registry = LocateRegistry.getRegistry("servidor_pagamentos", 1099);
            pagamentoService = (IPagamentoService) registry.lookup("PagamentoService");
            if(pagamentoService != null){
                System.out.println("✅ Conexão estabelecida com o Servidor de Pagamentos.");
            }
        } catch (ClassNotFoundException e) {
        System.err.println("❌ Interface IPagamentoService não encontrada! Verifique a dependência.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Erro ao conectar ao Servidor de Pagamentos.");
        }
    }

    public boolean processarPagamento(int pedidoId, double valor) {
        try {
            boolean resposta = pagamentoService.processarPagamento(pedidoId, valor);
            return resposta;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
