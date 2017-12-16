package com.ar.testroom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.ar.testroom.R;
import com.ar.testroom.data.AppDatabase;
import com.ar.testroom.data.Constant;
import com.ar.testroom.data.Product;

public class MainActivity extends AppCompatActivity {

    private AppDatabase mDb;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());

        text = findViewById(R.id.text);

        checkCache();
        storeCache();

        text.setText(readCache());

    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    private void checkCache(){
        Product cache = mDb.productModel().loadProductById(1);
        if (cache == null){
            Product product = new Product();
            product.id = 1;
            product.json = "";
            mDb.productModel().insertProduct(product);
        }
    }

    private void storeCache(){
        Product product = new Product();
        product.id = 1;
        product.json = Constant.dummy;
        mDb.productModel().updateProduct(product);
    }

    private String readCache(){
        Product product = mDb.productModel().loadProductById(1);
        return product.json;
    }

}
