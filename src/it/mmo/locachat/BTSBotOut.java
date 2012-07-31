package it.mmo.locachat;

public interface BTSBotOut {

	public void sendText(String text);
	public void sendImage(String name, String content);
	public void dirUser(String user);
	public void sendFriendRequest(String user);
	public void aroundMe();
}
