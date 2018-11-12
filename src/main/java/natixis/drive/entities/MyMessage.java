package natixis.drive.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MyMessage {
	
	private Long id;
	private String myText;
	private MyType myType;
	
	public MyMessage() {
		super();
	}

	public MyMessage(Long id, String myText) {
		super();
		this.id = id;
		this.myText = myText;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMyText() {
		return myText;
	}

	public void setMyText(String myText) {
		this.myText = myText;
	}
	
	public MyType getMyType() {
		return myType;
	}
	

	public void setMyType(MyType myType) {
		this.myType = myType;
	}

	@Override
	public String toString() {
		return "MyMessage [id=" + id + ", myText=" + myText + "]";
	}
	
	
	

}
