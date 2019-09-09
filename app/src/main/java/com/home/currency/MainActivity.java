package com.home.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText ntd;
    private Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        onGoButtonClicked();


    }

    private void onGoButtonClicked() {
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ntdString = ntd.getText().toString().trim();
                if (ntdString.equals("")) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(getString(R.string.problem))
                            .setMessage(getString(R.string.please_enter_ntd))
                            .setPositiveButton("OK",null)
                            .show();
                } else {
                    int ntdNumber = Integer.parseInt(ntdString);
                    float USD = (float) (ntdNumber / 30.9);
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle(getString(R.string.result))
                            .setMessage(getString(R.string.use_is) + USD)
                            .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ntd.setText("");
                                }
                            })
                            .show();
                }
            }
        });
    }

    private void findViews() {
        ntd = findViewById(R.id.ntd);
        goButton = findViewById(R.id.go_button);
    }


}
