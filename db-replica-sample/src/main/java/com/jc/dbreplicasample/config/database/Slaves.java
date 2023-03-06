package com.jc.dbreplicasample.config.database;

import java.util.List;

public class Slaves {
	private final List<String> slaves;
	private int size;
	private int counter = 0;

	public Slaves(List<String> slaves) {
		this.slaves = slaves;
		this.size = slaves.size();
	}

	public String getSlaveName() {
		if (counter >= size) {
			counter -= size;
		}
		return slaves.get(counter++);
	}
}
