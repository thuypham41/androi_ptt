package com.example.myapplication;//BTTH1_BAI1

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Bill,Percent, Tip, Total;
    Button tru,cong;
    String tien="";
    int phantram = 15;
    double bo=0;
    double tong=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bill = findViewById(R.id.editTextText2);
        Percent = findViewById(R.id.textView4);
        Tip = findViewById(R.id.textView6);
        Total = findViewById(R.id.textView7);
        tru = findViewById(R.id.button);
        cong = findViewById(R.id.button2);
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phantram > 0) {
                    float soTienHoaDon = Float.parseFloat(Bill.getText().toString());

                    phantram--;
                    Percent.setText(phantram + "%");

                    float tyLeBoa = phantram / 100.0f;
                    Float soTienBoa = soTienHoaDon * tyLeBoa;
                    soTienBoa = Math.round(soTienBoa * 100.0f) / 100.0f;
                    Tip.setText(String.valueOf(soTienBoa));

                    float tong = soTienBoa + soTienHoaDon;
                    Total.setText(String.valueOf(tong));
                }


            }

        });
        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phantram++;
                Percent.setText(phantram+"%");
                double soTienHoaDon1 = Double.parseDouble(Bill.getText().toString());
                float soTienHoaDon = Float.parseFloat(Bill.getText().toString());

                float tyLeBoa = phantram / 100.0f; // Chuyển đổi phantram thành số thập phân
                Float soTienBoa = soTienHoaDon * tyLeBoa;
                soTienBoa = Math.round(soTienBoa * 100.0f) / 100.0f;// Tính toán số tiền boa
                Tip.setText(String.valueOf(soTienBoa)); // Đặt số tiền boa vào giao diện người dùng

                float tong = soTienBoa + soTienHoaDon; // Tính tổng tiền hóa đơn và số tiền boa
                Total.setText(String.valueOf(tong));
            }
        });

    }
}