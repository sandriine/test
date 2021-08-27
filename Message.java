package main;

public class Message implements EmailNotifier{
	public String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Message(String content) {
		super();
		this.content = content;
	}
	
	public Message() {
		super();
	}

	@Override
	public String toString() {
		return "M:" + content;
	}
	
	@Override
	public void notifyMissingDrink(String drink) {
		this.setContent("Désolé il y a une pénurie de " + drink + ", un message a été envoyé au centre de service.");
	}
	
	

}
