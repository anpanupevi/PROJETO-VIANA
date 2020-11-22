package appVianaCRUD.novocadastroAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroPessoaActivity extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;
    private EditText email;
    private EditText telefone;
    private EditText cep;
    private EditText logradouro;
    private EditText numero;
    private EditText bairro;
    private EditText cidade;
    private EditText estado;
    private PessoaDAO dao;
    private Pessoa pessoa = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.editTextNome);
        cpf = findViewById(R.id.editTextCPF);
        email = findViewById(R.id.editTextEmail);
        telefone = findViewById(R.id.editTextTelefone);
        cep = findViewById(R.id.editTextCEP);
        logradouro = findViewById(R.id.editTextLogradouro);
        numero = findViewById(R.id.editTextNumero);
        bairro = findViewById(R.id.editTextBairro);
        cidade = findViewById(R.id.editTextCidade);
        estado = findViewById(R.id.editTextEstado);
        dao = new PessoaDAO(this);

        Intent it = getIntent();
        if(it.hasExtra("pessoa")){
            pessoa = (Pessoa) it.getSerializableExtra("pessoa");
            nome.setText(pessoa.getNome());
            cpf.setText(pessoa.getCpf());
            email.setText(pessoa.setEmail());
            telefone.setText(pessoa.getTelefone());
            cep.setText(pessoa.getCep());
            logradouro.setText(pessoa.getLogradouro());
            numero.setText(pessoa.getNumero());
            bairro.setText(pessoa.getBairro());
            cidade.setText(pessoa.getCidade());
            estado.setText(pessoa.getEstado());
        }

    }
    public void salvar (View view){

        if (pessoa==null){
            pessoa = new Pessoa();
            pessoa.setNome(nome.getText().toString());
            pessoa.setCpf(cpf.getText().toString());
            pessoa.setEmail(email.getText().toString());
            pessoa.setTelefone(telefone.getText().toString());
            pessoa.setCep(cep.getText().toString());
            pessoa.setLogradouro(logradouro.getText().toString());
            pessoa.setNumero(numero.getText().toString());
            pessoa.setBairro(bairro.getText().toString());
            pessoa.setCidade(cidade.getText().toString());
            pessoa.setEstado(estado.getText().toString());
            long id = dao.inserir(pessoa);
            Toast.makeText(this, "Cadastro Inserido Com Sucesso no id: " + id, Toast.LENGTH_SHORT).show();
    }else{
            pessoa.setNome(nome.getText().toString());
            pessoa.setCpf(cpf.getText().toString());
            pessoa.setEmail(email.getText().toString());
            pessoa.setTelefone(telefone.getText().toString());
            pessoa.setCep(cep.getText().toString());
            pessoa.setLogradouro(logradouro.getText().toString());
            pessoa.setNumero(numero.getText().toString());
            pessoa.setBairro(bairro.getText().toString());
            pessoa.setCidade(cidade.getText().toString());
            pessoa.setEstado(estado.getText().toString());
            dao.atualizar(pessoa);
            Toast.makeText(this, "Cadastro Atualizado com Sucesso ", Toast.LENGTH_SHORT).show();
        }

        }
}