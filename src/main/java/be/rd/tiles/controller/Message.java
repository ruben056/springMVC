package be.rd.tiles.controller;

public class Message {

	public String type;
	public String message;
	
	public Message(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}
}
