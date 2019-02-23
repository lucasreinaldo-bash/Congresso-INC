package vostore.congressoinc2019.Firebase;

public class Experts {

    public String nome,image,nacionalidade;
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Experts(){

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

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public Experts(String nome,String id, String image, String nacionalidade) {
        this.nome = nome;
        this.image = image;
        this.id = id;
        this.nacionalidade = nacionalidade;
    }
}
