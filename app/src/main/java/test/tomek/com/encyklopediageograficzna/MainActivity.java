package test.tomek.com.encyklopediageograficzna;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {

    private int savedImgId = R.drawable.stalagmit;
    private int savedDescId = R.string.stalagmit_opis;
    private int savedPojecieId = R.string.stalagmit_text_string;

    private Boolean memory = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            Log.d("Tomek","SaveInstanceState is not null");
            savedImgId = savedInstanceState.getInt("img-id");
            savedDescId = savedInstanceState.getInt("desc-id");
            savedPojecieId = savedInstanceState.getInt("pojecie");
            memory = true;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Tomek","Main Activity on start");
        ImageView img = (ImageView) findViewById(R.id.imageView_pojecie);
        TextView desc = (TextView) findViewById(R.id.textView_detail_pojecie_opis);
        if (img != null) {
            Drawable d = getResources().getDrawable(savedImgId);
            img.setImageDrawable(d);
            desc.setText(savedDescId);
        }else
        {
            if(memory == true){
                showDetails(savedImgId,savedDescId,savedPojecieId);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("Tomek","onSaveInstanceState called");
        outState.putInt("img-id",savedImgId);
        outState.putInt("desc-id",savedDescId);
        outState.putInt("pojecie",savedPojecieId);

    }

    @Override
    protected void onStop() {
        super.onStop();
        memory = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void stalagmitButtonClicked(View v){
        showDetails(R.drawable.stalagmit, R.string.stalagmit_opis, R.string.stalagmit_text_string);
    }

    public void stalaktytButtonClicked(View v){
        showDetails(R.drawable.stalaktyt, R.string.stalaktyt_opis, R.string.stalaktyt_text_string);
    }

    public void stalagnatButtonClicked(View v){
        showDetails(R.drawable.stalagnat, R.string.stalagnat_opis, R.string.stalagnat_text_string);
    }

    public void showDetails(int imgId, int descId, int pojecie){
        ImageView img = (ImageView) findViewById(R.id.imageView_pojecie);
        TextView desc = (TextView) findViewById(R.id.textView_detail_pojecie_opis);

        savedImgId = imgId;
        savedDescId = descId;
        savedPojecieId = pojecie;

        if (img ==null){
            Intent i = new Intent(this,DetailActivity.class);
            i.putExtra("img-id",imgId);
            i.putExtra("desc-id",descId);
            i.putExtra("pojecie",pojecie);

            startActivity(i);
        }else{
            Drawable d = getResources().getDrawable(imgId);

            img.setImageDrawable(d);
            desc.setText(descId);
        }

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
