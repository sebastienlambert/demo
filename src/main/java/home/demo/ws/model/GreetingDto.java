package home.demo.ws.model;


public class GreetingDto {

	private int id;
	private String text;

	
	public GreetingDto() {}
	
	public GreetingDto(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	
	@Override
	public String toString() {
		return "GreetingDto [id=" + id + ", text=" + text + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
