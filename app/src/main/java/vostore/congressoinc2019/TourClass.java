package vostore.congressoinc2019;

public class TourClass {
    public String nome,valor,data,image;

    public TourClass() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TourClass(String nome, String valor, String data, String image) {
        this.nome = nome;
        this.valor = valor;
        this.data = data;
        this.image = image;
    }
}
