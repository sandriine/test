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
		this.setContent("D�sol� il y a une p�nurie de " + drink + ", un message a �t� envoy� au centre de service.");
	}
	
	

}
