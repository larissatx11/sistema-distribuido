package com.sistemapag.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class PagamentoServiceImpl extends UnicastRemoteObject implements IPagamentoService { 
    // Extende UnicastRemoteObject para criar um objeto RMI
    
    public PagamentoServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean processarPagamento(int pedidoId, double valor) throws RemoteException {
        // Simula aprovação ou rejeição do pagamento
        boolean aprovado = new Random().nextBoolean();
        return aprovado;
    }
}
