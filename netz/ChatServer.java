package netz;

import java.util.List;

import linear.ListWithViewer;

public class ChatServer extends Server {

		private ListWithViewer<User> userListe;
		
	public ChatServer(int pPort) {
		super(pPort);
		System.out.println("Server ist gestartet");

		userListe = new ListWithViewer();
		initUserList();
	}
	
	public void initUserList() {
		userListe.append(new User("Mona", 1234));
		userListe.append(new User("Minh", 7890));
		userListe.append(new User("Lena", 6539));
	}

	@Override
	public void processNewConnection(String pClientIP, int pClientPort) {
		System.out.println("Client " +pClientIP + " ist verbunden.");
		send(pClientIP, pClientPort, "Hallo, du bist verbunden.");

	}

	@Override
	public void processMessage(String pClientIP, int pClientPort, String pMessage) {
		if(pMessage.equals("QUIT")) {
			closeConnection(pClientIP, pClientPort);
			return;
		}
		if(pMessage.startsWith("NEU"));
		String[] messageArray = pMessage.split(" ");
		System.out.println(messageArray[1]);
		
		return;

	}

	@Override
	public void processClosingConnection(String pClientIP, int pClientPort) {
		// TODO Auto-generated method stub

	}
	
	

	public static void main(String[] args) {
		ChatServer cs = new ChatServer(4242);

	}

}
