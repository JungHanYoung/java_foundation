package thisisjava.network;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerChatExample extends Application {
    ExecutorService executorService;
    ServerSocket serverSocket;
    List<Client> connections = new Vector<Client>();

    TextArea txtDisplay;
    Button btnStartStop;

    void startServer() {    // 서버 시작 코드
        /**
         * ExecutoService 객체를 얻기 위해 다음 메소드를 호출
         * CPU코어의 수만큼 스레드를 만들도록한다.
         */
        executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        /**
         * ServerSocket 객체 생성
         *  - 서버 소켓을 로컬컴퓨터, 5001포트에 바인딩한다.
         *  - 예외가 발생할 경우 서버소켓이 안닫혀있음 stopServer()메소드를 호출
         */
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 5001));

            executorService.submit(() -> {
                Platform.runLater(() -> {
                    displayText("[서버 시작]");
                    btnStartStop.setText("stop");
                });
                while(true) {
                    try {
                        Socket socket = serverSocket.accept();
                        String message = "[연결 수락: " + socket.getRemoteSocketAddress() + ": "
                                + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));

                        Client client = new Client(socket);
                        connections.add(client);
                        Platform.runLater(() -> displayText("[연결 개수: " + connections.size() + "]"));
                    } catch(Exception e) {
                        if(!serverSocket.isClosed()) { stopServer(); }
                        break;
                    }
                }
            });
        } catch(Exception e) {
            if(!serverSocket.isClosed()) { stopServer(); }
            return;
        }
    }
    void stopServer() {
        try {
            Iterator<Client> iterator = connections.iterator();
            while(iterator.hasNext()) {
                Client client = iterator.next();
                client.socket.close();
                iterator.remove();
            }
            if(serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            if(executorService != null && !executorService.isShutdown()) {
                executorService.shutdown();
            }
            Platform.runLater(() -> {
                displayText("[서버 멈춤]");
                btnStartStop.setText("start");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Client {  // 데이터 통신 서버
        Socket socket;

        Client(Socket socket) {
            this.socket = socket;
            receive();
        }

        // 데이터 받기 코드
        void receive() {
            executorService.submit(() -> {
                try {
                    while(true) {
                        byte[] byteArr = new byte[100];
                        InputStream inputStream = socket.getInputStream();

                        //
                        int readByteCount = inputStream.read(byteArr);

                        //
                        if(readByteCount == -1) {
                            throw new IOException();
                        }

                        String message = "[요청 처리: " + socket.getRemoteSocketAddress()
                                + ": " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));

                        String data = new String(byteArr, 0, readByteCount, "UTF-8");

                        for(Client client : connections) {
                            client.send(data);
                        }
                    }
                } catch(Exception e) {
                    try {
                        connections.remove(Client.this);
                        String message = "[클라이언트 통신 안됨: " +
                                socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));
                        socket.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
        // 데이터 전송 코드
        void send(String data) {
            executorService.submit(() -> {
                try {
                    byte[] byteArr = data.getBytes("UTF-8");
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(byteArr);
                    outputStream.flush();
                } catch(Exception e1) {
                    try {
                        String message = "[클라이언트 통신 안됨: " + socket.getRemoteSocketAddress()
                                + ": " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));
                        connections.remove(Client.this);
                        socket.close();
                    } catch(Exception e2) {

                    }
                }
            });
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(500, 300);

        txtDisplay = new TextArea();
        txtDisplay.setEditable(false);
        BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
        root.setCenter(txtDisplay);

        btnStartStop = new Button("start");
        btnStartStop.setPrefHeight(30);
        btnStartStop.setMaxWidth(Double.MAX_VALUE);

        btnStartStop.setOnAction(e -> {
            if(btnStartStop.getText().equals("start")) {
                startServer();
            } else if(btnStartStop.getText().equals("stop")) {
                stopServer();
            }
        });
        root.setBottom(btnStartStop);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("app.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Server");
        primaryStage.setOnCloseRequest(event -> stopServer());
        primaryStage.show();
    }

    void displayText(String text) {
        txtDisplay.appendText(text + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}