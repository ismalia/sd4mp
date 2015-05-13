package br.ufc.dc.sd4mp.mymail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class EscreverEmailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escrever_email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_escrever_email, menu);
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

    public void cancelarEmail(View view) {
        Context context = getApplicationContext();
        CharSequence texto = "O email foi descartado";
        int duracao = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, texto, duracao);
        toast.show();
        finish();
    }

    public void mandarEmail(View view) {
        EditText destinatarioEditText = (EditText) findViewById(R.id.destinatarioEditText);
        String destinatario = destinatarioEditText.getText().toString();

        EditText assuntoEditText = (EditText) findViewById(R.id.assuntoEditText);
        String assunto = assuntoEditText.getText().toString();

        EditText conteudoEditText = (EditText) findViewById(R.id.conteudoEditText);
        String conteudo = conteudoEditText.getText().toString();

        if (!destinatario.isEmpty() && !assunto.isEmpty() && !conteudo.isEmpty()) {
            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{destinatario});
            email.putExtra(Intent.EXTRA_SUBJECT, assunto);
            email.putExtra(Intent.EXTRA_TEXT, conteudo);
            email.setType("plain/text");
            startActivity(Intent.createChooser(email, "Mandando email..."));
        }
        else {
            Context context = getApplicationContext();
            CharSequence texto = "Todos os campos devem ser preenchidos!";
            int duracao = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, texto, duracao);
            toast.show();
        }
    }
}
