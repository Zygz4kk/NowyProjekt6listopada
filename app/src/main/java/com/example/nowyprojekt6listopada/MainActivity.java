package com.example.nowyprojekt6listopada;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    protected static ArrayList<Integer> imageVievsArray;
    private Button buttonDalej, buttonWstecz, buttonLosuj;
    private int ktoreZdjecie;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
            //pusty commit
        });
        imageView = findViewById(R.id.imageView5);
        buttonDalej = findViewById(R.id.buttondalej);
        buttonLosuj = findViewById(R.id.buttonlosuj);
        buttonWstecz = findViewById(R.id.buttonwstecz);
        listaAut();
        pokazAuta(ktoreZdjecie);
        buttonDalej.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ktoreZdjecie++;
                        imageView.setImageResource(R.drawable.auto2);
                        pokazAuta(ktoreZdjecie);
                    }
                }
        );
        buttonLosuj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ktoreZdjecie = random.nextInt(imageVievsArray.size());
                        pokazAuta(ktoreZdjecie);
                    }
                }
        );
        buttonWstecz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ktoreZdjecie--;
                        if (ktoreZdjecie < 0){
                            textView.setText("Nie ma więcej zdjęć wstecz.");
                        }
                        pokazAuta(ktoreZdjecie);
                    }
                }
        );
    }
    private void listaAut(){
        imageVievsArray = new ArrayList<Integer>();
        imageVievsArray.add(R.drawable.auto1);
        imageVievsArray.add(R.drawable.auto2);
        imageVievsArray.add(R.drawable.auto3);
        imageVievsArray.add(R.drawable.auto4);
        imageVievsArray.add(R.drawable.auto5);
        imageVievsArray.add(R.drawable.auto6);
    }
    private void pokazAuta (int ktoreZdjecie){
        imageView.setImageResource(imageVievsArray.get(ktoreZdjecie));
    }
}