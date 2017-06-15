package alexandra.example.com.exercicio1;

/**
 * Created by alexandra on 13/06/17.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;

import java.util.ArrayList;

public class PrimeiraTela extends Activity {
    private EditText nome;
    private RadioGroup rgGenero;
    private RadioButton rbSexo;
    private CheckBox musica, filme;
    private Button btCadastrar, btEnviar;
    private ArrayList<Usuario> usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira_tela);

        this.InicializaComponentes();


        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeUsuario = nome.getText().toString();

                int rbSexoId = rgGenero.getCheckedRadioButtonId();
                rbSexo = (RadioButton) rgGenero.findViewById(rbSexoId);
                String sexo = rbSexo.getText().toString();

                ArrayList<String> interesses = new ArrayList<>();

                if(musica.isChecked() && filme.isChecked() ){
                    interesses.add("Música e filme");
                }

                if(musica.isChecked()){
                    interesses.add("Música");
                }
                if(filme.isChecked()){
                    interesses.add("Filme");
                }

                usuarios.add(new Usuario(nomeUsuario, sexo, interesses));
            }

        });

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irParaTela2 = new Intent(PrimeiraTela.this, SegundaTela.class);
                irParaTela2.putExtra("usuarios", usuarios);

                startActivity(irParaTela2);
            }
        });
    }

    public void InicializaComponentes(){
        nome = (EditText) findViewById(R.id.et_nome);
        rgGenero = (RadioGroup) findViewById(R.id.rg_sexo);
        musica = (CheckBox) findViewById(R.id.cb_musica);
        filme = (CheckBox) findViewById(R.id.cb_filme);
        btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btEnviar = (Button) findViewById(R.id.btEnviar);
        usuarios = new ArrayList<>();
    }
}