package br.edu.ceub.navcrud.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.ceub.navcrud.R;
import br.edu.ceub.navcrud.adapter.AdapterContato;
import br.edu.ceub.navcrud.model.Contato;
import br.edu.ceub.navcrud.persistencia.ContatoDAO;

public class lstContatosActivity extends AppCompatActivity {
    private RecyclerView rv;
    private AdapterContato contatoAdapter;
    private List<Contato> listaContato = new ArrayList<>();
    private Contato contatoSelecionado;

    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_contatos);
        getSupportActionBar().setTitle("Contato");

        rv = findViewById(R.id.rvListaContatos);
        //Adicionar evento Clique
         rv.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                 rv, new RecyclerItemClickListener.OnItemClickListener() {
             @Override
             public void onItemClick(View view, int position) {
                 //Recuperar contato para edição
                 Contato contatoSelecionado = listaContato.get(position);
                 //Enviar contato para tela adicionar contato
                 Intent intent = new Intent(lstContatosActivity.this,addContatoActivity.class);
                 //Envio da classe Contato que foi instanciada como objeto contatoSelecionado
                 intent.putExtra("contatoSelecionado",(Serializable)contatoSelecionado);
                 startActivity(intent);
             }

                     @Override
                     public void onLongItemClick(View view, int position) {

                         //Recupera tarefa para deletar
                         contatoSelecionado = listaContato.get( position );

                         AlertDialog.Builder dialog = new AlertDialog.Builder(lstContatosActivity.this);

                         //Configura título e mensagem
                         dialog.setTitle("Confirmar exclusão");
                         dialog.setMessage("Deseja excluir a tarefa: " + contatoSelecionado.getNomeContato() + " ?" );

                         dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener(){
                             @Override
                             public void onClick(DialogInterface dialog, int which) {

                                 ContatoDAO contatoDAO = new ContatoDAO(getApplicationContext());
                                 if ( contatoDAO.deletar(contatoSelecionado) ){

                                     carregarListaTarefas();
                                     Toast.makeText(getApplicationContext(),
                                             "Sucesso ao excluir tarefa!",
                                             Toast.LENGTH_SHORT).show();

                                 }else {
                                     Toast.makeText(getApplicationContext(),
                                             "Erro ao excluir tarefa!",
                                             Toast.LENGTH_SHORT).show();
                                 }

                             }
                         });

                         dialog.setNegativeButton("Não", null );

                         //Exibir dialog
                         dialog.create();
                         dialog.show();

                     }

                     @Override
                     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                     }
                 }
                 )
         );


        //Clique do botão

        //Clique do botão
        Button btnNovo = (Button) findViewById(R.id.cmdNovo);
        btnNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Envia tarefa para tela adicionar tarefa
                Intent intent = new Intent(lstContatosActivity.this, addContatoActivity.class);
                startActivity( intent );
            }
        });

    }





    public void carregarListaTarefas(){

        //Listar tarefas
        ContatoDAO contatoDAO = new ContatoDAO( getApplicationContext() );
        listaContato = contatoDAO.listar();

        /*
            Exibe lista de tarefas no Recyclerview
        */

        //Configurar um adapter
        contatoAdapter = new AdapterContato( listaContato );

        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getApplicationContext() );
        rv.setLayoutManager( layoutManager );
        rv.setHasFixedSize(true);
        rv.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        rv.setAdapter( contatoAdapter );

    }

    @Override
    protected void onStart() {
        carregarListaTarefas();
        super.onStart();
    }


}