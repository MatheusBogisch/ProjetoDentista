package br.edu.qi.appdentista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarActivity extends AppCompatActivity {
    private EditText edtNomePaciente;
    private EditText edtData;
    private EditText edtIdade;
    private EditText edtNomeDoutor;
    private EditText edtProcedimento;
    private PacienteDAO objPacienteDAO;
    private Paciente objPaciente =null;
    private Button btnAgendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        getSupportActionBar().hide();

        edtNomePaciente = findViewById(R.id.edtNomePaciente);
        edtData = findViewById(R.id.edtData);
        edtIdade = findViewById(R.id.edtIdade);
        edtNomeDoutor = findViewById(R.id.edtNomeDoutor);
        edtProcedimento = findViewById(R.id.edtProcedimento);
        btnAgendar = findViewById(R.id.btnAgendar);
        edtNomePaciente.requestFocus();
        objPacienteDAO = new PacienteDAO(this);

        Intent i = getIntent();
        if(i.hasExtra("paciente")){
            objPaciente = (Paciente) i.getSerializableExtra("paciente");

            edtNomePaciente.setText(objPaciente.getNome());
            edtData.setText(objPaciente.getDataConsulta());
            edtIdade.setText(String.valueOf(objPaciente.getIdade()));
            edtNomeDoutor.setText(objPaciente.getDoutor());
            edtProcedimento.setText(objPaciente.getProcedimento());
            btnAgendar.setText("Alterar");

        }

        btnAgendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(objPaciente == null){
                    Paciente objPaciente = new Paciente();

                    objPaciente.setNome(edtNomePaciente.getText().toString());
                    objPaciente.setDataConsulta(edtData.getText().toString());
                    objPaciente.setIdade(Integer.parseInt(edtIdade.getText().toString()));
                    objPaciente.setDoutor(edtNomeDoutor.getText().toString());
                    objPaciente.setProcedimento(edtProcedimento.getText().toString());
                    objPacienteDAO.cadastrarPacienteBD(objPaciente);
                    Toast.makeText(CadastrarActivity.this, "Consulta agendada", Toast.LENGTH_LONG).show();
                }else{

                    objPaciente.setNome(edtNomePaciente.getText().toString());
                    objPaciente.setDataConsulta(edtData.getText().toString());
                    objPaciente.setIdade(Integer.parseInt(edtIdade.getText().toString()));
                    objPaciente.setDoutor(edtNomeDoutor.getText().toString());
                    objPaciente.setProcedimento(edtProcedimento.getText().toString());

                    objPacienteDAO.alterarPacienteBD(objPaciente);
                    Toast.makeText(CadastrarActivity.this, "Consulta alterada", Toast.LENGTH_LONG).show();
                }
                edtNomePaciente.setText("");
                edtData.setText("");
                edtIdade.setText("");
                edtNomeDoutor.setText("");
                edtProcedimento.setText("");
                edtNomePaciente.requestFocus();

            }
        });


    }
}