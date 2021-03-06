package edu.ifes.ci.si.les.ats.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class Orcamento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "dispositivo_id")
	private Dispositivo dispositivo;

	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;

	@NotNull(message = "O Campo deve ser preenchida")
	@OneToMany(mappedBy = "id.orcamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<OrcamentoServicoItem> orcamentoServicoItem = new ArrayList<>();

	@NotNull(message = "O Campo deve ser preenchida")
	@Column(length = 150)
	@NotBlank(message = "O Campo deve ser preenchido")
	@Size(min = 10, max = 150, message = "O campo deve ter pelo menos 10 e no maximo 150 letras")
	private String descricaoProblema;

	@Column(length = 100)
	@NotBlank(message = "O Campo deve ser preenchido")
	@Size(min = 2, max = 100, message = "O campo deve ter pelo menos 2 e no maximo 100 digitos")
	private float valorTotal;

	@Builder
	public Orcamento(Integer id, Dispositivo dispositivo, Tecnico tecnico, String descricaoProblema,
			float valorTotal) {
		this.id = id;
		this.dispositivo = dispositivo;
		this.tecnico = tecnico;
		this.descricaoProblema = descricaoProblema;
		this.valorTotal = valorTotal;
	}
	
	

}
