package edu.ifes.ci.si.les.ats.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class Garantia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 150)
	@NotBlank(message = "O Campo deve ser preenchido")
	@Size(min = 5, max = 150, message = "O campo deve ter pelo menos 10 e no maximo 150 letras")
	private String motivo;

	@Column(length = 10)
	@NotBlank(message = "O Campo deve ser preenchido")
	@Size(min = 10, max = 10, message = "O campo deve ter 8 digitos")
	private String dataEntrada;

	@OneToOne
	@JoinColumn(name = "ordemdeservico_id")
	private OrdemDeServico ordemDeServico;

	@ManyToOne
	@JoinColumn(name = "statusgarantia_id")
	private StatusGarantia statusGarantia;

}
