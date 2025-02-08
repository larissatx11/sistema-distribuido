import java.rmi.Remote;
import java.rmi.RemoteException;

// processarPagamento retorna uma string indicando se o pagamento foi aprovado ou recusado.
public interface PagamentoService extends Remote { // Extende Remote para indicar que os métodos serão chamados remotamente
    String processarPagamento(int pedidoId, double valor) throws RemoteException;
}


