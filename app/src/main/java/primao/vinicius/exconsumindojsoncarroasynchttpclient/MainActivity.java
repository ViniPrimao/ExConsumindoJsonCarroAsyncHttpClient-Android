package primao.vinicius.exconsumindojsoncarroasynchttpclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.Arrays;

import cz.msebera.android.httpclient.Header;

    public class MainActivity extends AppCompatActivity {

        private ProgressBar progress;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //Refs
            progress = findViewById(R.id.progress);
            //setando a progress para ficar invisivel
            progress.setVisibility(View.INVISIBLE);
            //chamando carros
            getCarros();
        }//fecha oncreate

        public void getCarros(){
            RequestParams params = new RequestParams();
            AsyncHttpClient client = new AsyncHttpClient();

            client.get("http://www.thiagocury.eti.br/testes/json/carros.json", params, new TextHttpResponseHandler() {

                @Override
                public void onStart() {
                    super.onStart();
                    progress.setVisibility(View.VISIBLE);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    Toast.makeText(
                            getBaseContext(),
                            "ONFAILURE: "+statusCode,
                            Toast.LENGTH_LONG).show();
                }

                @Override
                public void onSuccess(int statusCode,
                                      Header[] headers,
                                      String responseString) {

                    Gson gson = new Gson();
                    Veiculo[] v = gson.fromJson(responseString,
                            Veiculo[].class);
                    ArrayList<Veiculo> veiculos =
                            new ArrayList<>(Arrays.asList(v));


                    Toast.makeText(
                            getBaseContext(),
                            "veiculos:"+veiculos.toString(),
                            Toast.LENGTH_LONG).show();
                    progress.setVisibility(View.INVISIBLE);
                }
            });

        }//fecha carros
    }//fecha classe
