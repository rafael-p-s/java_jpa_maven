package modelo.muitosParaMuitos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private Double nota;
    // Forma mais detalhada
    // De  como eu quero montar a 3° tabela gerada pelo MuitosParaMuitos
    // OBS: só o DONO pode ter o @JoinTable
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "atores_filmes",
            joinColumns = @JoinColumn(name = "filme_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="ator_id",referencedColumnName = "id")
    )
    private List<Ator> atores;

    public Filme() {
    }

    public Filme(String titulo, Double nota) {
        this.titulo = titulo;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public List<Ator> getAtores() {
        if (atores == null) {
            atores = new ArrayList<>();
        }
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public void adicionarAtor(Ator ator) {
        if (ator != null && !getAtores().contains(ator)) {
            getAtores().add(ator);

            if (!ator.getFilmes().contains(this)) {
                ator.getFilmes().add(this);
            }
        }
    }
}
