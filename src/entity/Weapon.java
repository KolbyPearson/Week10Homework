package entity;

public class Weapon {
	
	private int weaponId;
	private String name;
	private String weaponClass;
	
	public Weapon(int weaponId, String name, String weaponClass) {
		this.setWeaponId(weaponId);
		this.setName(name);
		this.setWeaponClass(weaponClass);
		
		
	}

	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponid) {
		this.weaponId = weaponid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeaponClass() {
		return weaponClass;
	}

	public void setWeaponClass(String weaponClass) {
		this.weaponClass = weaponClass;
	}
}
