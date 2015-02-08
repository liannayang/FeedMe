package flyingsquirrels.feedmetake2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    private float x1, x2;
    private int minDistance = 300;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            //get first x coordinate when user touches the screen
            case MotionEvent.ACTION_DOWN:
                x1 = e.getX();
                break;
            //get second x coordinate when user releases the screen
            case MotionEvent.ACTION_UP:
                x2 = e.getX();

                //get total lateral distance swiped
                float distance = Math.abs(x2 - x1);

                //if distance swiped was greater than minimal distance required to consider the gesture a swipe,
                //show calendar page
                if (minDistance < distance && x2 < x1) {
                    Intent intent = new Intent(MainActivity.this, Categories.class);
                    MainActivity.this.startActivity(intent);
                }
                break;
        }
        return false;
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
