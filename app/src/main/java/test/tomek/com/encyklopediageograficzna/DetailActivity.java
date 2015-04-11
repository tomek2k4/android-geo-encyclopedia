package test.tomek.com.encyklopediageograficzna;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView img = (ImageView) findViewById(R.id.imageView_pojecie);
        TextView desc = (TextView) findViewById(R.id.textView_detail_pojecie_opis);

        int imgId = getIntent().getIntExtra("img-id",R.drawable.stalagmit);
        int descId = getIntent().getIntExtra("desc-id",R.string.stalagmit_opis);
        int pojecieId = getIntent().getIntExtra("pojecie", R.string.stalagmit_text_string);

        Drawable imgDraw = getDrawable(imgId);
        String descString = getString(descId);
        String pojecieStr = getString(pojecieId);

        img.setImageDrawable(imgDraw);
        desc.setText(descString);
        this.getActionBar().setTitle(pojecieStr);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            Log.d("Tomek", "Orientation changed to landscape");
            finish();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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
