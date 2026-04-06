package com.example.myapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class FragmentB extends Fragment {

    private TextView tvCompteur;
    private SeekBar seekBar;
    private int progress = 0;
    private static final String CLE_SCORE = "score";

    public FragmentB() {
        super(R.layout.fragment_b);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tvCompteur = view.findViewById(R.id.tvCompteur);
        seekBar    = view.findViewById(R.id.seekBar);

        // Restaurer si rotation
        if (savedInstanceState != null) {
            progress = savedInstanceState.getInt(CLE_SCORE, 0);
            seekBar.setProgress(progress);
            tvCompteur.setText("Valeur : " + progress);
        }

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar s, int p, boolean fromUser) {
                progress = p;
                tvCompteur.setText("Valeur : " + p);
            }
            @Override public void onStartTrackingTouch(SeekBar s) {}
            @Override public void onStopTrackingTouch(SeekBar s) {}
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CLE_SCORE, progress);
    }
}