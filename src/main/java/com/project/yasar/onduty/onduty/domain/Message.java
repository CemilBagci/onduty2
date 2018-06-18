package com.project.yasar.onduty.onduty.domain;
import javax.persistence.*;


@Entity
public class Message {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id; //messageid
	@Column
	private String messageContent;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	private MessageState messageState;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	private State state;  
	

	@JoinColumn(name = "conversation_id")
	@OneToOne(cascade = CascadeType.DETACH)
	private Conversation conversation;

	public Message(String messageContent, MessageState messageState, State state, Conversation conversation) {
		super();
		this.messageContent = messageContent;
		this.messageState = messageState;
		this.state = state;
		this.conversation = conversation;
	}

	public Message() {
		

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public MessageState getMessageState() {
		return messageState;
	}

	public void setMessageState(MessageState messageState) {
		this.messageState = messageState;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	
	
	
	
	
	
	

}