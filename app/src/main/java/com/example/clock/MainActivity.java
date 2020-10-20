package com.example.clock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ListView list;
    private String [] times = new String[] {"8:00", "13:00", "22:00", "00:00"};
    private String [] desc = new String[] {"Breakfast", "Launch", "Sleep", "00:00"};
    private Button add;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list();
        addListenerOnButton();

    }

    public void addListenerOnButton() {
        add = (Button)findViewById(R.id.add);

        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent("com.example.clock.MainActivity2");
                        startActivity(intent);
                    }
                }
        );
    }



    public void list() {
        list = (ListView)findViewById(R.id.listView);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.times, times);
        list.setAdapter(adapter);
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("24 hours left");
//                        alertDialog.setMessage("");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                }
        );
        list.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Do you wont to delete?");
//                        alertDialog.setMessage("");
                        alertDialog.setButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "You press yes", 1).show();
                            }
                        });
                        alertDialog.setButton2("NO",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "You press no", 1).show();
                            }
                        });
                        alertDialog.show();
                        return true;
                    }
                }
        );
    }


}