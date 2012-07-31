package it.mmo.locachat;


public interface BTSBotIn {

	public void dir();
	public void recvFriendRequest(String user);
	public void recvImg(String image, String name, String user);
	public void recvText(String text, String user);
	public void getLocation();
	
}
