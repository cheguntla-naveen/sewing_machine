package com.edubridge.sewing_machine.dao;

import java.util.List;

import com.edubridge.sewing_machine.model.Sewing_machine;


public interface SMDao {
	int addmachine(Sewing_machine s);
	List <Sewing_machine> findmachine();
	Sewing_machine findmachineByBrand(String brand);
	int updatemachine(Sewing_machine s);
	int deletemachineByBrand(String brand);
	void deletemachines();
}
