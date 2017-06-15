package alexandra.example.com.exercicio1;

/**
 * Created by alexandra on 13/06/17.
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
    private String nome, sexo;
    private ArrayList<String> interesses;

    public Usuario(String nome, String sexo, ArrayList<String> interesses) {
        this.nome = nome;
        this.sexo = sexo;
        this.interesses = interesses;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public ArrayList<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(ArrayList<String> interesses) {
        this.interesses = interesses;
    }

    @Override
    public String toString() {
        return nome + ":" + sexo;
    }
}