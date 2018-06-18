package com.project.yasar.onduty.onduty.domain;

import javax.persistence.*;

@Entity
public class MessageInformation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//	@NotNull
	private long id;
	
	@JoinColumn(name = "sender_id")
	@OneToOne(cascade = CascadeType.DETACH)
	private User sender;
	
	@JoinColumn(name = "recevier_id")
	@OneToOne(cascade = CascadeType.DETACH)
	private User recevier;
	
	@JoinColumn(name = "message_id")
	@OneToOne(cascade = CascadeType.DETACH)
	private Message message;

	public MessageInformation(User sender, User recevier, Message message) {
		this.sender = sender;
		this.recevier = recevier;
		this.message = message;
	}

	public MessageInformation() {
		super();

	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getRecevier() {
		return recevier;
	}

	public void setRecevier(User recevier) {
		this.recevier = recevier;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return sender;
	}

	public void setUser(User user) {
		this.sender = sender;
	}

	public User getUser1() {
		return recevier;
	}

	public void setUser1(User user1) {
		this.recevier = recevier;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	



}
