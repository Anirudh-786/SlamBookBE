import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Proxy {
    public static void main(String[] args) throws Exception {
        int localPort = 65432;
        String remoteHost = "db.ornfiystiyfrgtndzgdg.supabase.co";
        int remotePort = 5432;

        try (ServerSocket serverSocket = new ServerSocket(localPort)) {
            System.out.println("Proxy listening on port " + localPort);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());
                new Thread(() -> {
                    try (Socket server = new Socket(remoteHost, remotePort)) {
                        Thread t1 = new Thread(() -> forward(clientSocket, server));
                        Thread t2 = new Thread(() -> forward(server, clientSocket));
                        t1.start();
                        t2.start();
                        t1.join();
                        t2.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try { clientSocket.close(); } catch (Exception e) {}
                    }
                }).start();
            }
        }
    }

    private static void forward(Socket input, Socket output) {
        try {
            InputStream in = input.getInputStream();
            OutputStream out = output.getOutputStream();
            byte[] buffer = new byte[4096];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
                out.flush();
            }
        } catch (Exception e) {
            // Ignore socket closed exceptions
        }
    }
}
