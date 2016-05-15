package com.example.mobile.pessoaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.SingleLaunchActivityTestCase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup rgTipo =
                (RadioGroup) findViewById(R.id.rg_tipo);

        final EditText etCpfCnpj =
                (EditText) findViewById(R.id.et_cpf_cnpj);

        rgTipo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_pf) {
                    etCpfCnpj.setHint(R.string.cpf);
                }
                else {
                    etCpfCnpj.setHint(R.string.cnpj);
                }
            }
        });

        CheckBox cbReceberNews =
                (CheckBox) findViewById(R.id.cb_receber_news);

        final EditText etEmail =
                (EditText) findViewById(R.id.et_email);

        cbReceberNews.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                etEmail.setEnabled(isChecked);
            }
        });

        Spinner spEstado =
                (Spinner) findViewById(R.id.sp_estado);

        final Spinner spCidade =
                (Spinner) findViewById(R.id.sp_cidade);

        spEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String estado =
                        parent.getItemAtPosition(position)
                                .toString();

                ArrayAdapter<CharSequence> adapter = null;

                if (estado == getString(R.string.pr)) {
                    adapter =
                            ArrayAdapter.createFromResource(
                                    MainActivity.this,
                                    R.array.estados_pr,
                                    android.R.layout.simple_spinner_item
                            );
                }
                else if (estado == getString(R.string.rs)) {
                    adapter =
                            ArrayAdapter.createFromResource(
                                    MainActivity.this,
                                    R.array.estados_rs,
                                    android.R.layout.simple_spinner_item
                            );
                }
                else if (estado == getString(R.string.sc)) {
                    adapter =
                            ArrayAdapter.createFromResource(
                                    MainActivity.this,
                                    R.array.estados_sc,
                                    android.R.layout.simple_spinner_item
                            );
                }

                adapter.setDropDownViewResource(
                        android.R.layout.simple_spinner_dropdown_item
                );
                spCidade.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
