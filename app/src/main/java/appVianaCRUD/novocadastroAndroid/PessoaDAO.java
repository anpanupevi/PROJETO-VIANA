package appVianaCRUD.novocadastroAndroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public PessoaDAO (Context context){
        conexao = new Conexao (context);
        banco = conexao.getWritableDatabase();
    }
    public long inserir (Pessoa pessoa){
        ContentValues values = new ContentValues();
        values.put("nome", pessoa.getNome());
        values.put("cpf", pessoa.getCpf());
        values.put("email", pessoa.getEmail());
        values.put("telefone", pessoa.getTelefone());
        values.put("cep", pessoa.getCep());
        values.put("logradouro", pessoa.getLogradouro());
        values.put("numero", pessoa.getNumero());
        values.put("bairro", pessoa.getBairro());
        values.put("cidade", pessoa.getCidade());
        values.put("estado", pessoa.getEstado());
        return banco.insert("pessoa", null,values);
    }
    public List<Pessoa> obterTodos(){
        List<Pessoa> pessoas = new ArrayList<>();
        Cursor cursor = banco.query("pessoa", new String[] { "id", "nome", "cpf", "email", "telefone", "cep", "logradouro", "numero",
                "bairro", "cidade", "estado"},null, null, null, null, null);
        while (cursor.moveToNext()){
            Pessoa a = new Pessoa();
            a.setId(cursor.getInt(0));
            a.setNome(cursor.getString(1));
            a.setCpf(cursor.getString(2));
            a.setEmail(cursor.getString(3));
            a.setTelefone(cursor.getString(4));
            a.setCep(cursor.getString(5));
            a.setLogradouro(cursor.getString(6));
            a.setNumero(cursor.getString(7));
            a.setBairro(cursor.getString(8));
            a.setCidade(cursor.getString(9));
            a.setEstado(cursor.getString(10));
            pessoas.add(a);
        }
        return pessoas;
    }
    public void excluir(Pessoa a){
        banco.delete("pessoa", "id = ?", new String[]{a.getId().toString()});
    }
    public void atualizar(Pessoa pessoa){
        ContentValues values = new ContentValues();
        values.put("nome", pessoa.getNome());
        values.put("cpf", pessoa.getCpf());
        values.put("email", pessoa.getEmail());
        values.put("telefone", pessoa.getTelefone());
        values.put("cep", pessoa.getCep());
        values.put("logradouro", pessoa.getLogradouro());
        values.put("numero", pessoa.getNumero());
        values.put("bairro", pessoa.getBairro());
        values.put("cidade", pessoa.getCidade());
        values.put("estado", pessoa.getEstado());
        banco.update("pessoa", values, "id = ?", new String[]{pessoa.getId().toString()});

    }
}
