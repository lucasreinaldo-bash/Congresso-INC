package vostore.congressoinc2019.Firebase;

public class Palestrante {

    private String nomeProfissional;
    private String formacao;
    private String nacionalidade;
    private String informacoesComplementares;
    private String contrasenha;
    private String fotoPerfilChat;

    public String getFotoPerfilChat() {
        return fotoPerfilChat;
    }

    public Palestrante() {

    }

    public Palestrante(String nomeProfissional, String formacao, String nacionalidade, String informacoesComplementares, String contrasenha, String fotoPerfilChat) {
        this.nomeProfissional = nomeProfissional;
        this.nacionalidade = nacionalidade;
        this.formacao = formacao;
        this.informacoesComplementares = informacoesComplementares;
        this.contrasenha = contrasenha;
        this.fotoPerfilChat = fotoPerfilChat;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public void setFotoPerfilChat(String fotoPerfilChat) {
        this.fotoPerfilChat = fotoPerfilChat;
    }

    public String getInformacoesComplementares() {
        return informacoesComplementares;
    }

    public void setInformacoesComplementares(String informacoesComplementares) {
        this.informacoesComplementares = informacoesComplementares;
    }



    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
}