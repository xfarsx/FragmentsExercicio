package br.com.digitalhouse.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.fragments.fragments.Fragment1;
import br.com.digitalhouse.fragments.fragments.Fragment2;

public class MainActivity extends AppCompatActivity {

    private Button botaoVerde;
    private Button botaoVermelho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoVerde = findViewById(R.id.botaoVerde);
        botaoVermelho = findViewById(R.id.botaoVermelho);

        botaoVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragment(R.id.conteudo,new Fragment1());
                botaoVerde.setBackgroundTintList(getResources().getColorStateList(R.color.Verde));
                botaoVermelho.setBackgroundTintList(getResources().getColorStateList(R.color.Cinza));

            }
        });

        botaoVermelho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                replaceFragment(R.id.conteudo,new Fragment2());
                botaoVerde.setBackgroundTintList(getResources().getColorStateList(R.color.Cinza));
                botaoVermelho.setBackgroundTintList(getResources().getColorStateList(R.color.Vermelho));


            }
        });


    }

    public void replaceFragment(int position, Fragment fragment)
    {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(position,fragment)
                .addToBackStack(null)
                .commit();
    }
}
