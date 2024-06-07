package com.edubridge.sewing_machine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.edubridge.sewing_machine.model.Sewing_machine;
import com.edubridge.sewing_machine.utils.DBUtils;

public class SMDaoImpl implements SMDao {
	static Connection con = DBUtils.getConnection();
	@Override
	public int addmachine(Sewing_machine s) {
		
		String INSERT_QUERY = "insert into sewing_machine(brand,colour,price,rating)values(?,?,?,?)";
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);
			ps.setString(1, s.getBrand());
			ps.setString(2, s.getColour());
			ps.setFloat(3, s.getPrice());
			ps.setFloat(4, s.getRating());

			status = ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public List<Sewing_machine> findmachine() {
		String SELECT_QUERY = "select * from sewing_machine";
		List<Sewing_machine> machinesList = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Sewing_machine s = new Sewing_machine();
				s.setId(rs.getInt("id"));
				s.setBrand(rs.getString("brand"));
				s.setColour(rs.getString("colour"));
				s.setPrice(rs.getFloat("price"));
				s.setRating(rs.getFloat("rating"));
				machinesList.add(s);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return machinesList;
	}

	@Override
	public Sewing_machine findmachineByBrand(String brand) {
		String SELECT_QUERY = "select * from sewing_machine where brand=?";
		// PreparedStatement;
		Sewing_machine smachine = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(SELECT_QUERY);
			ps.setString(1, brand);
			ResultSet rs = ps.executeQuery();
			smachine = new Sewing_machine();
			if (rs.next()) {
				smachine.setId(rs.getInt("id"));
				smachine.setBrand(rs.getString("brand"));
				smachine.setColour(rs.getString("Colour"));
				smachine.setPrice(rs.getFloat("Price"));
				smachine.setRating(rs.getFloat("rating"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return smachine;
	}

	@Override
	public int updatemachine(Sewing_machine s) {
		String UPDATE_QUERY = "UPDATE sewing_machine SET brand= ?,colour=?,price=?,rating=? where id=?";

		int status = 0;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(UPDATE_QUERY);
			ps.setString(1, s.getBrand());
			ps.setString(2, s.getColour());
			ps.setFloat(3, s.getPrice());
			ps.setFloat(4, s.getRating());
			ps.setInt(5, s.getId());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deletemachineByBrand(String brand) {
		String DELETE_QUERY = "DELETE  from sewing_machine where brand=?";
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.setString(1, brand);
			status = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public void deletemachines() {
		String DELETE_QUERY = "delete from sewing_machine";

		try {
			PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
