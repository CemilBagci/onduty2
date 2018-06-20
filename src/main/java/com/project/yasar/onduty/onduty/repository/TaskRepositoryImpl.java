package com.project.yasar.onduty.onduty.repository;

import com.project.yasar.onduty.onduty.domain.Task;

public class TaskRepositoryImpl implements TaskRepository {


	@Override
	public Task findTaskByNameEquals(String name) {
		return null;
	}

	@Override
	public Task getAssignerpersonal(String assignerpersonal) {
		return null;
	}

	@Override
	public <S extends Task> S save(S s) {
		return null;
	}


	@Override
	public <S extends Task> Iterable<S> save(Iterable<S> ıterable) {
		return null;
	}

	@Override
	public Task findOne(Long aLong) {
		return null;
	}

	@Override
	public boolean exists(Long aLong) {
		return false;
	}

	@Override
	public Iterable<Task> findAll() {
		return null;
	}

	@Override
	public Iterable<Task> findAll(Iterable<Long> ıterable) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void delete(Long aLong) {

	}

	@Override
	public void delete(Task task) {

	}

	@Override
	public void delete(Iterable<? extends Task> ıterable) {

	}

	@Override
	public void deleteAll() {

	}
}
