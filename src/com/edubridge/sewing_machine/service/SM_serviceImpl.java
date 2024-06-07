package com.edubridge.sewing_machine.service;

import java.util.List;

import com.edubridge.sewing_machine.dao.SMDao;
import com.edubridge.sewing_machine.dao.SMDaoImpl;
import com.edubridge.sewing_machine.model.Sewing_machine;

public class SM_serviceImpl implements SM_service {
	private SMDao dao = new SMDaoImpl();
	@Override
	public int addContact(Sewing_machine s) {
		
		return dao.addmachine(s);
	}

	@Override
	public List<Sewing_machine> findmachine() {
		
		return dao.findmachine();
	}

	@Override
	public Sewing_machine findmachineByBrand(String brand) {
		
		return dao.findmachineByBrand(brand);
	}

	@Override
	public int updatemachine(Sewing_machine s) {
		
		return dao.updatemachine(s);
	}

	@Override
	public int deletemachineByBrand(String brand) {
		
		return dao.deletemachineByBrand(brand);
	}

	@Override
	public void deletemachines() {
		
		dao.deletemachines();
	}

}
