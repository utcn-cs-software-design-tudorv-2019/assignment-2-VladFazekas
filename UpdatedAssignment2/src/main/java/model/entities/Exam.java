package model.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exam")
public class Exam {

	@Id
	@Column(name="numematerie")
    private String numematerie;
	@Column(name="numestudent")
    private String numestudent;
	@Column(name="nota")
    private int nota;
	@Column(name="dataexamen")
    private Date dataexamen;
	
	public Exam() {}

    public Exam(String numematerie, String numestudent, int nota, Date dataexamen) {
        this.numematerie = numematerie;
        this.numestudent =numestudent;
        this.nota = nota;
        this.dataexamen = dataexamen;
    }

    public String getNumematerie() {
        return numematerie;
    }

    public void setNumematerie(String numematerie) {
        this.numematerie = numematerie;
    }

    public String getNumestudent() {
        return numestudent;
    }

    public void setNumestudent(String numestudent) {
        this.numestudent=numestudent;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Date getDataexamen() {
        return dataexamen;
    }

    public void setDataexamen(Date dataexamen) {
        this.dataexamen = dataexamen;
    }

	@Override
	public String toString() {
		return "Exam [numematerie=" + numematerie + ", numestudent=" + numestudent + ", nota=" + nota + ", dataexamen="
				+ dataexamen + "]";
	}
    
    
}
