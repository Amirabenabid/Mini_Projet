package com.example.musique.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Musique {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idMusique;

@NotNull
@Size (min = 5,max = 50)
private String nomMusique;

public Style getStyle() {
	return style;
}
public void setStyle(Style style) {
	this.style = style;
}
@Min(value = 10)
@Max(value = 100000)
private Double prixMusique;

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateCreation;

@ManyToOne
private Style style;
public Musique() {
super();
}
public Musique(String nomMusique, Double prixMusique, Date dateCreation) {
super();
this.nomMusique = nomMusique;
this.prixMusique = prixMusique;
this.dateCreation = dateCreation;
}
public Long getIdMusique() {
return idMusique;
}
public void setIdMusique(Long idMusique) {
this.idMusique = idMusique;
}
public String getNomMusique() {
return nomMusique;
}
public void setNomMusique(String nomMusique) {
this.nomMusique = nomMusique;
}
public Double getPrixMusique() {
return prixMusique;
}

public void setPrixMusique(Double prixMusique) {
this.prixMusique = prixMusique;
}
public Date getDateCreation() {
return dateCreation;
}
public void setDateCreation(Date dateCreation) {
this.dateCreation = dateCreation;
}
@Override
public String toString() {
	return "Produit [idMusique=" + idMusique + ", nomMusique=" + nomMusique + ", prixMusique=" + prixMusique
			+ ", dateCreation=" + dateCreation + ", style=" + style + "]";
}
}
