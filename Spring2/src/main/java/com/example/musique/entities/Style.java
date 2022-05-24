package com.example.musique.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
public class Style {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idStyle;
private String nomStyle;
private String descriptionStyle;
@JsonIgnore
@OneToMany(mappedBy = "style")
private List<Musique> musiques;
public Style() {}
public Style(String nomStyle, String descriptionStyle, List<Musique> Musiques) 
{
super();
this.nomStyle = nomStyle;
this.descriptionStyle = descriptionStyle;
this.musiques = musiques;
}
public Long getIdStyle() {
return idStyle;
}
public void setIdStyle(Long idStyle) {
this.idStyle = idStyle;
}
public String getNomStyle() {
return nomStyle;
}
public void setNomStyle(String nomStyle) {
this.nomStyle = nomStyle;
}
public String getDescriptionStyle() {
return descriptionStyle;
}
public void setDescriptionStyle(String descriptionStyle) {
this.descriptionStyle = descriptionStyle;
}
public List<Musique> getMusique() {
return musiques;
}
public void setMusique(List<Musique> musiques) {
this.musiques = musiques;
}
@Override
public String toString() {
	return "Style [idStyle=" + idStyle + ", nomStyle=" + nomStyle + ", descriptionStyle=" + descriptionStyle + "]";
}
}