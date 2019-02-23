package vostore.congressoinc2019.Firebase;

public class Passeio {

    public String nome,image,telefone,endereco;
    public String id;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Passeio(){

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Passeio(String nome,String telefone, String id, String image, String endereco) {
        this.nome = nome;
        this.image = image;
        this.id = id;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
