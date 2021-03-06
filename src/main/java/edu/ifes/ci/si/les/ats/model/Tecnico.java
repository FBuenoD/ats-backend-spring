package edu.ifes.ci.si.les.ats.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@Entity
public class Tecnico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 200)
	@NotBlank(message = "O Campo deve ser preenchido")
	@Size(min = 10, max = 200, message = "O campo deve ter pelo menos 10 e no maximo 200 letras")
	private String nome;

	@Column(length = 14)
	@NotBlank(message = "O Campo deve ser preenchido")
	@Size(min = 14, max = 14, message = "O campo deve ter 14 digitos")
	private String cpf;

	@Column(length = 14)
	@NotBlank(message = "O Campo deve ser preenchido")
	@Size(min = 14, max = 14, message = "O campo deve ter pelo menos 14 digitos")
	private String telefone;

	@Column(length = 200)
	@NotBlank(message = "O Campo deve ser preenchido")
	@Size(min = 10, max = 200, message = "O campo deve ter pelo menos 10 e no maximo 200 letras")
	private String endereco;
	
	@Column(length = 50)
	@NotBlank(message = "O Campo deve ser preenchido")
	@Size(min = 5, max = 50, message = "O campo deve ter pelo menos 5 e no maximo 50 letras")
	private String login;
	
	@Column(length = 50)
	@NotBlank(message = "O Campo deve ser preenchido")
	@Size(min = 5, max = 50, message = "O campo deve ter pelo menos 3 e no maximo 50 letras")
	private String senha;

}
