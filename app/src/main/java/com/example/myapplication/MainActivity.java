package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnA, btnB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);

        // Afficher Fragment A au démarrage
        if (savedInstanceState == null) {
            chargerFragment(new FragmentA(), false);
        }

        btnA.setOnClickListener(v -> chargerFragment(new FragmentA(), true));
        btnB.setOnClickListener(v -> chargerFragment(new FragmentB(), true));
    }

    private void chargerFragment(Fragment fragment, boolean ajouterPile) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.conteneur_fragment, fragment);

        if (ajouterPile) {
            ft.addToBackStack(null);
        }

        ft.commit();
    }
}