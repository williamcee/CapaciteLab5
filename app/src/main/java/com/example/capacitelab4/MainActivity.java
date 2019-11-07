package com.example.capacitelab4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] name, vaersion, api, releaseDate;
    ListView listView;
    int[] aLogo = {R.drawable.cupcake, R.drawable.donut, R.drawable.e, R.drawable.froyo, R.drawable.g, R.drawable.honey, R.drawable.ice, R.drawable.jelly, R.drawable.kitkat, R.drawable.lolli, R.drawable.marsh, R.drawable.nougat, R.drawable.oreo, R.drawable.pie, R.drawable.q10};
    ArrayList<Versions> AndroidList = new ArrayList<>();
    String[] versionInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Android Versions");
        name = getResources().getStringArray(R.array.Name);
        version = getResources().getStringArray(R.array.Version);
        api = getResources().getStringArray(R.array.API);
        releaseDate = getResources().getStringArray(R.array.ReleaseDate);
        versionInfo = getResources().getStringArray(R.array.Trivia);
        for(int i=0; i < name.length; i++){
            AndroidList.add(new Versions(aLogo[i], name[i], "Ver. " + version[i], "API Level " + api[i], "Released " + releaseDate[i]));
        }

        listView = findViewById(R.id.listView);
        ArrayAdapter myArrayAdapter = new Adapter(this, R.layout.item, AndroidList);
        listView.setAdapter(myArrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
        myDialog.setTitle(AndroidList.get(i).getName());
        myDialog.setIcon(AndroidList.get(i).getLogo());
        myDialog.setMessage(versionInfo[i]);
        myDialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        myDialog.create().show();
    }
}
