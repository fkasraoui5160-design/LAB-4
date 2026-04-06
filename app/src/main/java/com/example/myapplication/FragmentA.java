package com.example.myapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FragmentA extends Fragment {

    private TextView tvMessage;
    private Button btnSaluer;

    public FragmentA() {
        super(R.layout.fragment_a);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tvMessage = view.findViewById(R.id.tvMessageA);
        btnSaluer = view.findViewById(R.id.btnSaluer);

        btnSaluer.setOnClickListener(v ->
                tvMessage.setText("🌸 Bonjour ! Fragment A est actif !")
        );
    }
}