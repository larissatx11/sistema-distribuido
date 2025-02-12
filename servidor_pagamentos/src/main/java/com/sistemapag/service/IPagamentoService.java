package com.sistemapag.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

// processarPagamento retorna uma string indicando se o pagamento foi aprovado ou recusado.
public interface IPagamentoService extends Remote { // Extende Remote para indicar que os métodos serão chamados remotamente
    boolean processarPagamento(Long pedidoId, double valor) throws RemoteException;
}
