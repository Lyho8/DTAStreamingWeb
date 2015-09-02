/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author ETY
 */
@Entity
//@Table(name = "movie")
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 64, nullable = false)
    private String titre;
    
    private String resume;
    
    private Integer annee;
    
    private Integer duree;
    
//    private Genre genre;
    
    @OneToMany(mappedBy = "film", cascade = {CascadeType.ALL})
    @CascadeOnDelete
    private Collection<Lien> liens = new ArrayList<Lien>();
    
    @OneToMany(mappedBy = "film", cascade = {CascadeType.ALL})
    @CascadeOnDelete
    private Collection<FilmCasting> filmcastings = new ArrayList<FilmCasting>();
    
    @ManyToMany
    @JoinTable(name = "film_genre", joinColumns = {@JoinColumn(name = "film_id")}, inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private Collection<Genre> genres = new ArrayList<Genre>();
    
    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    public Film() {
    }

    public Film(Long id, String titre, String resume, Integer annee, Integer duree) {
        this.id = id;
        this.titre = titre;
        this.resume = resume;
        this.annee = annee;
        this.duree = duree;
    }

    public Film(String titre, String resume, Integer annee, Integer duree) {
        this.titre = titre;
        this.resume = resume;
        this.annee = annee;
        this.duree = duree;
    }



    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }

    public Collection<FilmCasting> getFilmcastings() {
        return filmcastings;
    }

    public void setFilmcastings(Collection<FilmCasting> filmcastings) {
        this.filmcastings = filmcastings;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Collection<Lien> getLiens() {
        return liens;
    }

    public void setLiens(Collection<Lien> liens) {
        this.liens = liens;
    }
    
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

//    public Genre getGenre() {
//        return genre;
//    }
//
//    public void setGenre(Genre genre) {
//        this.genre = genre;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dtastreaming.entity.Film[ id=" + id + " ]";
    }
    
}
