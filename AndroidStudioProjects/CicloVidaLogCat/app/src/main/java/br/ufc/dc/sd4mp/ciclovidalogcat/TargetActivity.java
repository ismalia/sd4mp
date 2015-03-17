package br.ufc.dc.sd4mp.ciclovidalogcat;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class TargetActivity extends ActionBarActivity {

    private static String CATEGORY = "CicloVida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        Log.i(CATEGORY, getClassName() + ".onCreate() ---> Created");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(CATEGORY, getClassName() + ".onDestroy() ---> Destroyed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(CATEGORY, getClassName() + ".onPause() ---> Paused");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(CATEGORY, getClassName() + ".onRestart() ---> Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(CATEGORY, getClassName() + ".onResume() ---> Resumed");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(CATEGORY, getClassName() + ".onStart() ---> Started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(CATEGORY, getClassName() + ".onStop() ---> Stopped");
    }

    private String getClassName() {
        return TargetActivity.class.getName();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_target, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void voltar(View view) {
        this.finish();
    }
}
