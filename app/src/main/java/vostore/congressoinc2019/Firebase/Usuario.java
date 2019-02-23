package vostore.congressoinc2019.Firebase;

public class Usuario {

    private String nome;
    private String tipoUsuario;
    private String email;
    private String situacaoCadastro;
    private String senha;
    private String contrasenha;
    private String fotoPerfilChat;

    public String getFotoPerfilChat() {
        return fotoPerfilChat;
    }

    public Usuario() {

    }

    public Usuario(String nome,String situacaoCadastro,String tipoUsuario, String email, String senha, String contrasenha, String fotoPerfilChat) {
        this.nome = nome;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
        this.senha = senha;
        this.situacaoCadastro = situacaoCadastro;
        this.contrasenha = contrasenha;
        this.fotoPerfilChat = fotoPerfilChat;
    }

    public String getSituacaoCadastro() {
        return situacaoCadastro;
    }

    public void setSituacaoCadastro(String situacaoCadastro) {
        this.situacaoCadastro = situacaoCadastro;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setFotoPerfilChat(String fotoPerfilChat) {
        this.fotoPerfilChat = fotoPerfilChat;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}