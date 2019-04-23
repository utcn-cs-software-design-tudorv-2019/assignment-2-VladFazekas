package model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "nume")
	private String name;
	@Column(name = "cnp")
	private String cnp;
	@Column(name = "icn")
	private int icn;
	@Column(name = "address")
	private String address;
	@Column(name = "materii")
	private String materii;
	@Column(name = "grupa")
	private int grupa;

	public Student() {
	}

	public Student(String name, String cnp, String address) {

		this.name = name;
		this.cnp = cnp;
		this.address = address;
	}



	public Student(int id, String name, String cnp, int icn, String address, String materii, int grupa) {
		this.id = id;
		this.name = name;
		this.cnp = cnp;
		this.icn = icn;
		this.address = address;
		this.materii = materii;
		this.grupa = grupa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public int getIcn() {
		return icn;
	}

	public void setIcn(int icn) {
		this.icn = icn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaterii() {
		return materii;
	}

	public void setMaterii(String materii) {
		this.materii = materii;
	}

	public int getGrupa() {
		return grupa;
	}

	public void setGrupa(int grupa) {
		this.grupa = grupa;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cnp=" + cnp + ", icn=" + icn + ", address=" + address
				+ ", materii=" + materii + ", grupa=" + grupa + "]";
	}

}
