package br.edu.ceub.navcrud.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//Classe DbHelper extende a classe SQLiteOpenHelper
//Essa classe só server para criar e atualizar o banco de dados
//Ela extende as funcionalidades da SQLiteOpenHelper nativas do Android
public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static  String NOME_DB="DB_SEUBANCO";
    public static String TABELA_CONTATO = "contato";

    public DbHelper(Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="CREATE TABLE IF NOT EXISTS "+TABELA_CONTATO
                    +" (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +" nomeContato TEXT NOT NULL, telContato TEXT);";
        try{
             db.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar a tabela");

        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela " + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       String sql = "DROP TABLE IF EXISTS "+ TABELA_CONTATO +";";
       try{
           db.execSQL(sql);
           onCreate(db);
           Log.i("INFO DB", "Sucesso ao atualizar a App ");
       }catch (Exception e){
           Log.i("INFO DB", "Erro ao atualizar a App " + e.getMessage());
       }

    }
}
