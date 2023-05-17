package Server;

import DB.CrudSql;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;


public class ServerMain {
    HashMap clients; //key, value

    public ServerMain() { //생성자함수 - 멤버변수 초기화 담당
        clients = new HashMap(); //HashMap 객체 생성
        Collections.synchronizedMap(clients); //동기화
    }

    public void start() {
        ServerSocket ss = null; // server socket 1
        Socket s = null; // client socket 1

        try {
            ss = new ServerSocket(8000);
            System.out.println("[서버 연결됨]");
            while(true) {
                s = ss.accept();
                System.out.println("[" + s.getInetAddress() + ":" + s.getPort()+"] 에서 접속하셨습니다.");
                ServerReceiver thread = new ServerReceiver(s);
                thread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ServerReceiver extends Thread{
        Socket s;
        BufferedReader br;
        BufferedWriter bw;
        DataInputStream dis; // readXXX() - XXX : 자료형
        DataOutputStream dos; //writeXXX()
        public ServerReceiver(Socket s) {
            this.s = s;
            try {
                dis = new DataInputStream(s.getInputStream()); //네트워크를 통해서 읽기
                dos = new DataOutputStream(s.getOutputStream());
                br = new BufferedReader(new InputStreamReader(s.getInputStream())); //네트워크를 통해서 읽기
                bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream())); //네트워크를 통해서 쓰기
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        @Override
        public void run() { //스레드 실행부(구현부)
            String name = String.valueOf(s.getInetAddress());
            try {
                System.out.println("name : " + name);
                String msg = br.readLine();
                System.out.println(msg);
                clients.put(name, dos);
                DataOutputStream dos = (DataOutputStream) clients.get(name);
                if(msg.split(" ")[1].equals("checkBtn")) {
                    if (new CrudSql().Idcheck(msg.split(" ")[2])) {
                        dos.writeUTF("Success");
                    } else {
                        dos.writeUTF("Fail");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                clients.remove(name);
                System.out.println("접속 종료했습니다.");
            }
            
        }

    }

    public static void main(String[] args) {
        new ServerMain().start();
    }
}
