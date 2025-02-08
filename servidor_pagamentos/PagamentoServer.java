import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PagamentoServer {
    public static void main(String[] args) {
        try {
            // Criar instância do serviço de pagamento
            PagamentoService pagamentoService = new PagamentoServiceImpl();

            // Registrar o serviço no RMI Registry na porta 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("PagamentoService", pagamentoService);

            System.out.println("Servidor de Pagamentos pronto...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
