package br.com.gestaorestauranteapi.gestaorestauranteapi.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;

@Getter
@Setter
@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column
    @NotBlank(message = "Nome é Obrigatório")
    private String nome;

    @Column
    @NotBlank(message = "Preço é Obrigatório")
    private Double preco;

    @Column
    @NotBlank(message = "Quantidade é Obrigatória")
    private Integer quantidade;

}
