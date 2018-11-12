package natixis.drive.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MyType {
	
	private Long id;
	private String name;
	private Set<MyMessage> myMessages;
	
	public MyType() {
		super();
	}

	public MyType(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<MyMessage> getMyMessages() {
		return myMessages;
	}

	@JsonIgnore
	public void setMyMessages(Set<MyMessage> myMessages) {
		this.myMessages = myMessages;
	}

	@Override
	public String toString() {
		return "MyType [id=" + id + ", name=" + name + "]";
	}
	
	
}
