import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PedidoServiceClient {
    public static void main(String[] args) {
        try {
            // Localiza o serviço no RMI Registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            PagamentoService pagamentoService = (PagamentoService) registry.lookup("PagamentoService");

            // Simula um pedido de pagamento
            String resposta = pagamentoService.processarPagamento(101, 500.00);
            System.out.println("Resposta do servidor: " + resposta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
