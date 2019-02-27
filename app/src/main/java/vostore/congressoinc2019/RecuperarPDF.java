package vostore.congressoinc2019;

public class RecuperarPDF {
    String dia28,dia29,dia30,diaEncontro,diaJoin,diaSimposio;

    public RecuperarPDF() {
    }

    public RecuperarPDF(String dia28, String dia29, String dia30, String diaEncontro, String diaJoin, String diaSimposio) {
        this.dia28 = dia28;
        this.dia29 = dia29;
        this.dia30 = dia30;
        this.diaEncontro = diaEncontro;
        this.diaJoin = diaJoin;
        this.diaSimposio = diaSimposio;
    }

    public String getDia28() {
        return dia28;
    }

    public void setDia28(String dia28) {
        this.dia28 = dia28;
    }

    public String getDia29() {
        return dia29;
    }

    public void setDia29(String dia29) {
        this.dia29 = dia29;
    }

    public String getDia30() {
        return dia30;
    }

    public void setDia30(String dia30) {
        this.dia30 = dia30;
    }

    public String getDiaEncontro() {
        return diaEncontro;
    }

    public void setDiaEncontro(String diaEncontro) {
        this.diaEncontro = diaEncontro;
    }

    public String getDiaJoin() {
        return diaJoin;
    }

    public void setDiaJoin(String diaJoin) {
        this.diaJoin = diaJoin;
    }

    public String getDiaSimposio() {
        return diaSimposio;
    }

    public void setDiaSimposio(String diaSimposio) {
        this.diaSimposio = diaSimposio;
    }
}
