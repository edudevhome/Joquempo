package com.devhome.eduardobastos.pedrapapeloutesoura;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


//Classes ADS AdMob
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;



import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewResult;
    private Button buttonLimpar;
    private AdView mAdView;
    private TextView textViewApp, textViewUser;
    private long scoreApp, scoreUser = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView =  findViewById(R.id.imageViewResultado);
        textViewResult = findViewById(R.id.textViewEscolhaUser);
        buttonLimpar = findViewById(R.id.button);
        textViewApp = findViewById(R.id.textViewScoreApp);
        textViewUser = findViewById(R.id.textViewScoreUser);


        //Configurando Banner Nativo1
        MobileAds.initialize(this, "ca-app-pub-3253976680799709/7325011354");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

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

                    texto.setText("Empate técnico, ninguém pontuou!");
                }

                    if(escolhaUsuario == "papel"){

                        texto.setText("Você venceu!  :D");
                        scoreUser++;
                        textViewUser.setText(""+scoreUser);
                    }

                        if(escolhaUsuario == "tesoura"){

                            texto.setText("Você Perdeu!  :(");
                            scoreApp ++;
                            textViewApp.setText(""+scoreApp);

                        }



                break;


            case "papel":
                imagemViewResultado.setImageResource(R.drawable.papel);


                if (escolhaApp == escolhaUsuario) {

                    texto.setText("Empate técnico, ninguém pontuou!");

                }

                if(escolhaUsuario == "tesoura"){

                    texto.setText("Você venceu!  :D");
                    scoreUser ++;
                    textViewUser.setText(""+scoreUser);
                }

                if(escolhaUsuario == "pedra"){

                    texto.setText("Você Perdeu!  :(");
                    scoreApp ++;
                    textViewApp.setText(""+scoreApp);
                }
                break;
            case "tesoura":
                imagemViewResultado.setImageResource(R.drawable.tesoura);

                if (escolhaApp == escolhaUsuario) {

                    texto.setText("Empate técnico, ninguém pontuou!");

                }

                if(escolhaUsuario == "pedra"){

                    texto.setText("Você venceu!  :D");
                    scoreUser ++;
                    textViewUser.setText(""+scoreUser);
                }

                if(escolhaUsuario == "papel"){

                    texto.setText("Você Perdeu!  :(");
                    scoreApp ++;
                    textViewApp.setText(""+scoreApp);
                }
                break;


        }


    }

    public void limpar(View view){

        imageView.setImageResource(R.drawable.padrao);
        textViewResult.setText("Escolha a sua arma:");
        textViewApp.setText("0");
        textViewUser.setText("0");
        scoreUser = 0;
        scoreApp = 0;

        Toast.makeText(MainActivity.this,
                "Campos limpos com sucesso!",
                Toast.LENGTH_SHORT).show();


    }

}
