import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class PagamentoServiceImpl extends UnicastRemoteObject implements PagamentoService { 
    // Extende UnicastRemoteObject para criar um objeto RMI
    
    public PagamentoServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String processarPagamento(int pedidoId, double valor) throws RemoteException {
        // Simula aprovação ou rejeição do pagamento
        boolean aprovado = new Random().nextBoolean();
        if (aprovado) {
            return "Pagamento do pedido " + pedidoId + " APROVADO";
        } else {
            return "Pagamento do pedido " + pedidoId + " RECUSADO";
        }
    }
}
