package br.ufc.dc.sd4mp.todo.mytodolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 0322851 on 11/05/15.
 */
public class TarefaDAO extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Tarefas.db";
    public static final int DATABASE_VERSION = 1;

    public TarefaDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public TarefaDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuffer sql = new StringBuffer();
        sql.append("create table tarefas (");
        sql.append("id integer primary key autoincrement,");
        sql.append("titulo text,");
        sql.append("descricao text,");
        sql.append("dataDeCriacao timestamp,");
        sql.append("concluido boolean)");
        db.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists tarefas");
        onCreate(db);
    }

    public void create(Tarefa tarefa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", tarefa.getTitulo());
        contentValues.put("descricao", tarefa.getDescricao());
        contentValues.put("dataDeCriacao", tarefa.getDataDeCriacao().toString());
        contentValues.put("concluido", tarefa.estaConcluido());
        long id = db.insert("tarefas", null, contentValues);
        Log.v("SQLite", "create id = " + id);
    }

    public Tarefa retrieve(Integer id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from tarefas where id = ?", new String[]{Integer.toString(id)});
        Tarefa tarefa = null;
        if (result != null && result.getCount() > 0) {
            tarefa = new Tarefa();
            tarefa.setId(result.getInt(0));
            tarefa.setTitulo(result.getString(1));
            tarefa.setDescricao(result.getString(2));
            tarefa.setDataDeCriacao(Timestamp.valueOf(result.getString(3)));
            tarefa.setConcluido(Boolean.getBoolean(result.getString(4)));
        }
        return tarefa;
    }

    public void update(Tarefa tarefa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", tarefa.getTitulo());
        contentValues.put("descricao", tarefa.getDescricao());
        contentValues.put("dataDeCriacao", tarefa.getDataDeCriacao().toString());
        contentValues.put("concluido", String.valueOf(tarefa.estaConcluido()));
        db.update("tarefas", contentValues, " id = ? ", new String[]{Integer.toString(tarefa.getId())});
    }

    public void delete(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("tarefas", " id = ? ", new String[]{Integer.toString(id)});
    }

    public List<Tarefa> list() {
        List<Tarefa> tarefas = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from tarefas order by id", null);
        if (result != null && result.getCount() > 0) {
            tarefas = new ArrayList<Tarefa>();
            result.moveToFirst();
            while (result.isAfterLast() == false) {
                Tarefa tarefa = new Tarefa();
                tarefa.setId(result.getInt(0));
                tarefa.setTitulo(result.getString(1));
                tarefa.setDescricao(result.getString(2));
                tarefa.setDataDeCriacao(Timestamp.valueOf(result.getString(3)));
                tarefa.setConcluido(Boolean.valueOf(result.getString(4)));
                tarefas.add(tarefa);
                result.moveToNext();
            }
        }
        return tarefas;
    }
}
