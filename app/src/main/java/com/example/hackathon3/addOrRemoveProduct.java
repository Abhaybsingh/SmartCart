package com.example.hackathon3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class addOrRemoveProduct extends AppCompatActivity {
    public static TextView resulttextview;
    private Button buttontoast;
    private Button scanQrCodeBtn, goToCartBtn, generateBillBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_remove_product);

        scanQrCodeBtn = (Button) findViewById(R.id.scanQrCodeBtn);
        goToCartBtn = (Button) findViewById(R.id.goToCartBtn);
        generateBillBtn = (Button) findViewById(R.id.generateBillBtn);
        resulttextview = findViewById(R.id.barcodetextview);
    }

    public void scanQrCode(View view) {
        Intent intent = new Intent(getApplicationContext(), QrCodeScanner.class);
        startActivity(intent);
    }

    public void goToCart(View view) {
        Toast.makeText(addOrRemoveProduct.this, resulttextview.getText(), Toast.LENGTH_SHORT).show();
    }

}