package com.thumbay.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_table")
public class Item {

	@Id
	private int id;
	private String name;
	private String type;
	private long price;
	private String idleFor;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(int id, String name, String type, long price, String idleFor) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.idleFor = idleFor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getIdleFor() {
		return idleFor;
	}

	public void setIdleFor(String idleFor) {
		this.idleFor = idleFor;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", idleFor=" + idleFor
				+ "]";
	}

}
