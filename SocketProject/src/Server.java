import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Create 13/09/2016
 * @author urbain
 * 
 * by command line, execute : java Server User1 
 *
 */
public class Server {

	private static final int PORT = 8888;

	public static void main(String[] args) throws IOException {

		new Server().runServer();
	}

	public void runServer() throws IOException {
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Server is UP & Ready for connections ...");
		while (true) {
			Socket socket = serverSocket.accept();
			new ServerThread(socket).start();
		}
	}

	/**
	 * By extends Thread class, takes advantage to overide run() method
	 * 
 	 * @author urbain
	 *
	 */
	private class ServerThread extends Thread {
		Socket socket;

		/*
		 * Constructor
		 * @param : socket
		 */
		public ServerThread(Socket socket) {
			this.socket = socket;
		}
		
		public void run() {
			try {
				String message = null;
				BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(socket.getInputStream()));
				while ((message = bufferedReader.readLine())!=null){
					System.out.println("Incoming Client message ..."+ message);
				}
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	// end -------------------------------------------------------------------------------------------------------------
}
