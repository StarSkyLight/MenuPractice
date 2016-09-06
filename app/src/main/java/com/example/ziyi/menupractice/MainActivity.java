package com.example.ziyi.menupractice;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textview);
        registerForContextMenu(textView);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();

        switch (id){
            case R.id.action_settings:
                Toast.makeText(this,"settings",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_another:
                Toast.makeText(this,"another",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view,ContextMenu.ContextMenuInfo infor){
        super.onCreateOptionsMenu(contextMenu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_concent,contextMenu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_settings:
                Toast.makeText(this,"settings",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_another:
                Toast.makeText(this,"another",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void showPopup(View view){
        PopupMenu popupMenu = new PopupMenu(this,view);
        popupMenu.inflate(R.menu.menu_popup);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.pop_settings:
                Toast.makeText(this,"settings",Toast.LENGTH_SHORT).show();
                break;
            case R.id.pop_another:
                Toast.makeText(this,"another",Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
