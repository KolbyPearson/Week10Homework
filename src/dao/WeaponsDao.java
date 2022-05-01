package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Weapon;

public class WeaponsDao {

	private Connection connection;
	private final String GET_WEAPONS_QUERY = "SELECT * FROM weapons";
	private final String GET_WEAPON_BY_ID_QUERY = "SELECT * FROM weapons WHERE id = ?";
	private final String CREATE_NEW_WEAPON_QUERY = "INSERT INTO weapons(name, class) VALUES(?,?)";
	private final String DELETE_WEAPON_BY_ID_QUERY = "DELETE FROM weapons WHERE id = ?";
	
	public WeaponsDao() {
		connection = DBConnection.getConnection();
	}
	
	public List<Weapon> getWeapons() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_WEAPONS_QUERY).executeQuery();
		List<Weapon> weapons = new ArrayList<Weapon>();
		
		while (rs.next()) {
			weapons.add(populateWeapon(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		
		return weapons;
	}
	
	public Weapon getWeaponById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_WEAPON_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populateWeapon(rs.getInt(1), rs.getString(2), rs.getString(3));
	}
	
	public void createNewWeapon(String weaponName, String weaponClass) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_WEAPON_QUERY);
		ps.setString(1, weaponName);
		ps.setString(2, weaponClass);
		ps.executeUpdate();
	}
	
	public void deleteWeaponById(int id) throws SQLException { 
		PreparedStatement ps = connection.prepareStatement(DELETE_WEAPON_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	private Weapon populateWeapon(int weaponId, String name, String weaponClass) {
		
		return new Weapon(weaponId, name, weaponClass);
	}
	
}
