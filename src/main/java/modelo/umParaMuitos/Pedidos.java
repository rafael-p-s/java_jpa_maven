package modelo.umParaMuitos;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;

    @OneToMany(mappedBy = "pedidos", fetch= FetchType.EAGER)// Gera a relação Bi direcional
    private List<ItemPedido> itens;

    public Pedidos() {
        this(new Date()); // passa a data de hj, por padrão sem precisar informar.
    }

    public Pedidos(Date data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
}
