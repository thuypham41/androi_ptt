package com.example.bai_intent1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class childActivity extends AppCompatActivity {
    TextView txt;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_child);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt = findViewById(R.id.tvKQ);
        btn2 = findViewById(R.id.btnBack);
        Intent intent2 = getIntent();
        Bundle bundle2 = intent2.getBundleExtra("mybackage");
        int a = bundle2.getInt("soa");
        int b = bundle2.getInt("sob");
        String kq="";
        if(a==0&&b==0){
            kq= "Vô số nghiệm";
        }
        else if(a==0 &&b!=0){
            kq="Vô nghiệm";
        }
        else{
            DecimalFormat dcf = new DecimalFormat("0.##");
            kq=dcf.format(-b*1.0/a);

        }
        txt.setText(kq);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(childActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}