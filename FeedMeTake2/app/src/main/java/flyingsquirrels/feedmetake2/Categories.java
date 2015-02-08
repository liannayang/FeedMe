package flyingsquirrels.feedmetake2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Categories extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        //show first eatery in first category
        final Button category1 = (Button) findViewById(R.id.category1);
        category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, RestoPage.class);
                Categories.this.startActivity(intent);
            }
        });

        //show first eatery in second category
        final Button category2 = (Button) findViewById(R.id.category2);
        category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, RestoPage.class);
                Categories.this.startActivity(intent);
            }
        });

        //show first eatery in third category
        final Button category3 = (Button) findViewById(R.id.category3);
        category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, RestoPage.class);
                Categories.this.startActivity(intent);
            }
        });
        //show feelinglucky
        final Button feelinglucky = (Button) findViewById(R.id.feelinglucky);
        feelinglucky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, RestoPage.class);
                Categories.this.startActivity(intent);
            }
        });
        //show advanced search
        final Button advsearch = (Button) findViewById(R.id.advsearch);
        advsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, AdvancedSearch.class);
                Categories.this.startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_categories, menu);
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
