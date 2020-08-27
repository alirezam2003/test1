package com.example.sharedpreftest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_save, btn_load;
    EditText inpt_name;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getPreferences(MODE_PRIVATE);
//        pref=getSharedPreferences("my_pref",MODE_PRIVATE);

        view_init();
        btn_save.setOnClickListener(this);
        load_pref_dialog();


        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = pref.getString("name", "not-found");
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("hi :)")
                        .setMessage("ur name is :" + name)
                        .show();
            }
        });

    }

    private void load_pref_dialog() {
        Context context;
        SharedPreferences apppref = PreferenceManager.getDefaultSharedPreferences(this);
        String name= apppref.getString("name","404");
        Boolean n =apppref.getBoolean("c",false);
        new AlertDialog.Builder(this)
                .setTitle("hi")
                .setMessage(name +'\n'+n)
                .show();
    }

    public void view_init() {
        btn_save = findViewById(R.id.btn_save);
        btn_load = findViewById(R.id.btn_load);
        inpt_name = findViewById(R.id.inpt_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Setting").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onClick(View v) {
        String name = inpt_name.getText().toString();
        SharedPreferences.Editor editor = pref.edit();
        if (inpt_name != null) {
            editor.putString("name", name)
                    .apply();
            Toast.makeText(getApplicationContext(), "saved successfully", Toast.LENGTH_SHORT).show();
        }
    }

    public void man(View view) {

       Global.toast("saloam,vdvklifhn ");
//        Toast.makeText(this, "fdkljhfdfdnbfd", Toast.LENGTH_SHORT).show();
    }
}