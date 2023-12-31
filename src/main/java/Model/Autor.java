// default package
// Generated 22 nov 2023 13:07:53 by Hibernate Tools 5.2.13.Final
package Model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Autor generated by hbm2java
 */
@Entity
@Table(name = "Autor", catalog = "autors")
public class Autor implements java.io.Serializable {

	private Integer idAutor;
	private String nomAutor;
	private Set<Llibres> llibreses = new HashSet<Llibres>(0);
	private AutorDetalls autorDetalls;
	private Set<Llibres> llibreses_1 = new HashSet<Llibres>(0);

	public Autor() {
	}

	public Autor(String nomAutor) {
		this.nomAutor = nomAutor;
	}

	public Autor(String nomAutor, Set<Llibres> llibreses, AutorDetalls autorDetalls, Set<Llibres> llibreses_1) {
		this.nomAutor = nomAutor;
		this.llibreses = llibreses;
		this.autorDetalls = autorDetalls;
		this.llibreses_1 = llibreses_1;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idAutor", unique = true, nullable = false)
	public Integer getIdAutor() {
		return this.idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	@Column(name = "nomAutor", nullable = false)
	public String getNomAutor() {
		return this.nomAutor;
	}

	public void setNomAutor(String nomAutor) {
		this.nomAutor = nomAutor;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Autor_Llibres", catalog = "autors", joinColumns = {
			@JoinColumn(name = "autor", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "llibre", nullable = false, updatable = false) })
	public Set<Llibres> getLlibreses() {
		return this.llibreses;
	}

	public void setLlibreses(Set<Llibres> llibreses) {
		this.llibreses = llibreses;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "autor")
	public AutorDetalls getAutorDetalls() {
		return this.autorDetalls;
	}

	public void setAutorDetalls(AutorDetalls autorDetalls) {
		this.autorDetalls = autorDetalls;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autor")
	public Set<Llibres> getLlibreses_1() {
		return this.llibreses_1;
	}

	public void setLlibreses_1(Set<Llibres> llibreses_1) {
		this.llibreses_1 = llibreses_1;
	}

}
