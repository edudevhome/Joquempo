package com.devhome.eduardobastos.pedrapapeloutesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void opcaoPedra(View view) {

        this.opcaoSelecionada("pedra");

    }

    public void opcaoPapel(View view) {     // METODOS CHAMADOS DIRETAMENTE DA INTERFACE POSSUEM PARAMETROS (View view)!!!!

        this.opcaoSelecionada("papel");

    }

    public void opcaoTesoura(View view) {

        this.opcaoSelecionada("tesoura");

    }


    public void opcaoSelecionada(String escolhaUsuario) {


        ImageView imagemViewResultado = findViewById(R.id.imageViewResultado);


        // gerar numero aleatorio para escolha do app

        String[] opcoes = {"pedra", "papel", "tesoura"};

        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        TextView texto = findViewById(R.id.textViewEscolhaUser);


        texto.setText("");
        switch (escolhaApp) {

            case "pedra":
                imagemViewResultado.setImageResource(R.drawable.pedra);

                if (escolhaApp == escolhaUsuario) {

                    texto.setText("Empate técnico");
                }

                    if(escolhaUsuario == "papel"){

                        texto.setText("Você venceu!  :D");
                    }

                        if(escolhaUsuario == "tesoura"){

                            texto.setText("Você Perdeu!  :(");
                        }



                break;


            case "papel":
                imagemViewResultado.setImageResource(R.drawable.papel);


                if (escolhaApp == escolhaUsuario) {

                    texto.setText("Empate técnico");

                }

                if(escolhaUsuario == "tesoura"){

                    texto.setText("Você venceu!  :D");
                }

                if(escolhaUsuario == "pedra"){

                    texto.setText("Você Perdeu!  :(");
                }
                break;
            case "tesoura":
                imagemViewResultado.setImageResource(R.drawable.tesoura);

                if (escolhaApp == escolhaUsuario) {

                    texto.setText("Empate técnico");

                }

                if(escolhaUsuario == "pedra"){

                    texto.setText("Você venceu!  :D");
                }

                if(escolhaUsuario == "papel"){

                    texto.setText("Você Perdeu!  :(");
                }
                break;


        }


    }

}
