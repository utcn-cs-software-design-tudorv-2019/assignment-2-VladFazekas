package entity;

import javax.persistence.Column;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profesor")
public class Profesor {

	@Id
	@Column(name = "id")
    int id;
	@Column(name = "nume")
    String nume;
	@Column(name = "cnp")
    String cnp;

    public Profesor(int id, String nume, String cnp) {
        this.id = id;
        this.nume = nume;
        this.cnp = cnp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
}
