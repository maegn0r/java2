package Server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class Server {
    private ServerSocket socket;
    private Socket clientSocket;


    public Server(){
        startServer();
        workAndClose();
        }

    private void startServer() {
        try {
            socket = new ServerSocket(8989);
            System.out.println("Ожидание подключений...");
            clientSocket = socket.accept();
            System.out.println("Клиент подключен");
            System.out.println(clientSocket);
            System.out.println("Начинаем работу...");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void workAndClose() {
        AtomicBoolean isAlive = new AtomicBoolean(true);
        Thread readMessages = new Thread(() -> {
            try {
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                while (isAlive.get()) {
                    if(in.available() > 0){
                        String incomingMessage = in.readUTF();
                        if (incomingMessage.equals("-end")) {
                            System.out.println("Завершение работы сервера по причине отключения единственного клиента.");
                            isAlive.set(false);
                            break;
                        }
                        System.out.println("Клиент пишет: " + incomingMessage);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread sendMessages = new Thread(() -> {
            try {
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while (isAlive.get()) {
                    if (reader.ready()){
                        String outgoingMessage = reader.readLine();
                        out.writeUTF(outgoingMessage);
                        if (outgoingMessage.equals("-end")) {
                            System.out.println("Завершение работы сервера.");
                            isAlive.set(false);
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        readMessages.start();
        sendMessages.start();

    }
}

