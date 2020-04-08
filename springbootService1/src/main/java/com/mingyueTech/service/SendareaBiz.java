package com.mingyueTech.service;

import java.util.List;

import com.mingyueTech.entity.Sendarea;

public interface SendareaBiz {

	void insert(Sendarea sendarea);

	List<Sendarea> getsendareabyuser(int uid);

	void update(Sendarea sendarea);

	Sendarea getsendareabyid(int id);


}
