package com.mingyueTech.service;

import com.mingyueTech.entity.Administrivia;

import java.util.List;

public interface AdministriviaBiz {

	void add(Administrivia item);

	List<Administrivia> getall();
	Administrivia selectByPrimaryKey(Integer id);

	void update(Administrivia item);

	void drop(Integer id);
}
