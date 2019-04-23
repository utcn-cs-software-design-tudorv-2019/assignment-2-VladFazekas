package model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="materie")
public class Materie {

	@Id
	@Column(name="id")
    int id;
	@Column(name="nume")
    String nume;
	
	public Materie() {}

    public Materie(int id, String nume) {
        this.id = id;
        this.nume = nume;
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

	@Override
	public String toString() {
		return "Materie [id=" + id + ", nume=" + nume + "]";
	}
    
    
}
