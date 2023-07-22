package org.jsp.usefood.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String item;
	private int cost;
	private String address;
	@CreationTimestamp
	private LocalDateTime ordered_time;
	@UpdateTimestamp
	private LocalDateTime delivered_time;
	@ManyToOne
	@JoinColumn(name = "User_id")
	private User usr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getOrdered_time() {
		return ordered_time;
	}

	public void setOrdered_time(LocalDateTime ordered_time) {
		this.ordered_time = ordered_time;
	}

	public LocalDateTime getDelivered_time() {
		return delivered_time;
	}

	public void setDelivered_time(LocalDateTime delivered_time) {
		this.delivered_time = delivered_time;
	}

	public User getUsr() {
		return usr;
	}

	public void setUsr(User usr) {
		this.usr = usr;
	}
}
