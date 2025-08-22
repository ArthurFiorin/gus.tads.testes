package br.com.cadastroplantas;

public class Planta {

    private int id;
    private String ambienteIdeal;
    private String categoria;
    private String nomeCientifico;
    private String nomePopular;
    private String rega;       // padronizado para minúscula

    public Planta(int id, String ambienteIdeal, String categoria, String nomeCientifico, String nomePopular, String rega) {
        this.id = id;
        this.ambienteIdeal = ambienteIdeal;
        this.categoria = categoria;
        this.nomeCientifico = nomeCientifico;
        this.nomePopular = nomePopular;
        this.rega = rega;
    }

    // Getters
    public int getId() { return id; }
    public String getNomeCientifico() { return nomeCientifico; }
    public String getNomePopular() { return nomePopular; }
    public String getAmbienteIdeal() { return ambienteIdeal; }
    public String getRega() { return rega; }
    public String getCategoria() { return categoria; }

    @Override
    public String toString() {
        return "Planta{" +
                "id=" + id +
                ", nomeCientifico='" + nomeCientifico + '\'' +
                ", nomePopular='" + nomePopular + '\'' +
                ", ambienteIdeal='" + ambienteIdeal + '\'' +
                ", rega='" + rega + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
