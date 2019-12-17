package br.edu.ceub.navcrud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ceub.navcrud.R;
import br.edu.ceub.navcrud.model.Contato;
import br.edu.ceub.navcrud.persistencia.ContatoDAO;

public class addContatoActivity extends AppCompatActivity {

    private EditText editContato;
    private EditText editTelefone;
    private Contato contatoAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contato);

        editContato = findViewById(R.id.textNomeContato);
        editTelefone = findViewById(R.id.textTelContato);

        //Recuperar tarefa, caso seja edição
        contatoAtual = (Contato) getIntent().getSerializableExtra("contatoSelecionado");

        //Configurar tarefa na caixa de texto
        if ( contatoAtual != null ){
            editContato.setText( contatoAtual.getNomeContato() );
            editTelefone.setText(contatoAtual.getTelContato());
        }

        //Clique do botão
        Button btnSalvar = (Button) findViewById(R.id.cmdSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContatoDAO contatoDAO = new ContatoDAO( getApplicationContext() );

                if ( contatoAtual != null ){//edicao

                    String nomeContato = editContato.getText().toString();
                    if ( !nomeContato.isEmpty() ){

                        Contato contato = new Contato();
                        contato.setNomeContato( nomeContato );
                        contato.setId( contatoAtual.getId() );
                        editContato.setText(nomeContato);

                        //atualizar no banco de dados
                        if ( contatoDAO.atualizar( contato ) ){
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Sucesso ao atualizar tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao atualizar tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }

                }else {//salvar

                    String nomeTarefa = editContato.getText().toString();
                    if ( !nomeTarefa.isEmpty() ){
                        Contato contato = new Contato();
                        contato.setNomeContato( nomeTarefa );

                        if ( contatoDAO.salvar(contato) ){
                            finish();
                            Toast.makeText(getApplicationContext(),
                                    "Sucesso ao salvar tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(),
                                    "Erro ao salvar tarefa!",
                                    Toast.LENGTH_SHORT).show();
                        }


                    }

                }
            }
        });
    }
}