package br.com.gestaorestauranteapi.gestaorestauranteapi.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column
    private String numeroPedido;

    @ManyToOne
    private Cliente cliente;

    @Column
    @NotBlank(message = "Informe o número da mesa")
    private Integer numeroMesa;

    @Column
    private String status;
    @Column
    @NotBlank(message = "Informe o motivo do cancelamento")
    private String motivoCancelamento;

    @Column
    private String observacao;

    @Column
    @Temporal(TemporalType.DATE)
    private Calendar dataInicio;

    @Column
    @Temporal(TemporalType.DATE)
    private Calendar dataFim;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedidos_produtos",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos;
}
