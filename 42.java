import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            StringAnalyzer analyzer = new StringAnalyzerImpl();

            Naming.rebind("rmi://localhost/StringService", analyzer);

            System.out.println("RMI String Analyzer Server is running...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}