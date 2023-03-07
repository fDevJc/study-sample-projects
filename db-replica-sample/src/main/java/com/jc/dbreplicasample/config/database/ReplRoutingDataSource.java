package com.jc.dbreplicasample.config.database;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReplRoutingDataSource extends AbstractRoutingDataSource {
	private Slaves slaves;

	@Override
	protected Object determineCurrentLookupKey() {
		boolean isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
		if (isReadOnly) {
			String slaveName = slaves.getSlaveName();
			System.out.println("DataSource = " + slaveName);
			return slaveName;
		}
		System.out.println("DataSource = master");
		return "master";
	}

	@Override
	public void setTargetDataSources(Map<Object, Object> targetDataSources) {
		super.setTargetDataSources(targetDataSources);
		slaves = new Slaves(targetDataSources.keySet()
			.stream()
			.map(Object::toString)
			.filter(s -> s.contains("slave"))
			.collect(Collectors.toList()));
	}
}
