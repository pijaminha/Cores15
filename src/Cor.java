import java.time.LocalDate;

public class Cor implements Comparable<Cor> {
    private int codigo;
    private String nome;
    private LocalDate dataCadastro;
    
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Cor(int codigo, String nome, LocalDate dataCadastro) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
    }
    
    public Cor(int cod, String nomeCor) {
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override //* serve para parar de usar a linguagem padrão, podendo ser personalizado //*
    public String toString() {
        return "Codigo = " + codigo + ", \nNome = " + nome + "Data = " + dataCadastro;
    }

    @Override
    public int compareTo(Cor c) {
        return getNome().compareTo(c.getNome());
    }
    
}