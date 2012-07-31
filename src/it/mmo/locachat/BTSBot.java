package it.mmo.locachat;

public class BTSBot implements BTSBotIn, BTSBotOut{

	JSIface iface;
	public BTSBot(String username, String password) {
		
		iface = JSIface.getInstance();
	}
	
	@Override
	public void sendText(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendImage(String name, String content) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dirUser(String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendFriendRequest(String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aroundMe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recvFriendRequest(String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recvImg(String image, String name, String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recvText(String text, String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getLocation() {
		// TODO Auto-generated method stub
		
	}

	

}
