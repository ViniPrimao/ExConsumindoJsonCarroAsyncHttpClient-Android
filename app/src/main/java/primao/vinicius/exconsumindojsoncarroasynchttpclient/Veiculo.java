package primao.vinicius.exconsumindojsoncarroasynchttpclient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by QI on 21/12/2017.
 */

public class Veiculo {

    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("url_foto")
    @Expose
    private String urlFoto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "nome='" + nome + '\'' +
                ", desc='" + desc + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }
}