package modelo.umParaMuitos;

import jakarta.persistence.*;
import modelo.basico.produto.Produto;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private Double preco;

    // Relação de 1 para muitos, sendo o Item muitos.
    @ManyToOne
    private Pedidos pedidos;
    @ManyToOne
    private Produto produto;

    public ItemPedido() {

    }

    public ItemPedido(Pedidos pedidos, Produto produto, int quantidade) {
        this.setPedidos(pedidos);
        this.setProduto(produto);
        this.setQuantidade(quantidade);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        if (produto != null && this.preco == null) {
            this.setPreco(produto.getPreco());
        }
    }
}
    
