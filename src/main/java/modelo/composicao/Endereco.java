package modelo.composicao;

import jakarta.persistence.Embeddable;


@Embeddable // Essa informação será colocada automaticamente dentro de Fornecedor e Funcionario
public class Endereco {

    private String logradouro;
    private String complemento;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
