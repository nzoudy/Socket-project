import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Create 13/09/2016
 * @author urbain
 *
 * by command line, execute : java Client User1 
 * Use anothe client by using other console with : java Client User2
 */
public class Client {

	private static final int PORT = 8888;
	private static String host ="localhost";
	public static void main(String[] args) throws Exception, IOException {
		String name = args[0];
		Socket socket = new Socket(host, PORT);
		
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),	true);
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(reader);
		while (true) {
			String readerInput = bufferedReader.readLine();
			printWriter.println(name + " : " + readerInput);
		}

	}

}
