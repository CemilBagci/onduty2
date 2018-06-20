package com.project.yasar.onduty.onduty.repository;

import com.project.yasar.onduty.onduty.domain.Task;

public class TaskRepositoryImpl implements TaskRepository {

	@Override
	public <S extends Task> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public <S extends Task> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Task> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Task> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Task entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Task> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Task findTaskByTaskName(String Task) {
		// TODO Auto-generated method stub
		return null;
	}

}
