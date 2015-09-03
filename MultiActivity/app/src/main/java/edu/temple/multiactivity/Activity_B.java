package edu.temple.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class Activity_B extends Activity {

    Button btnA;
    Button btnB;
    ArrayList<String> trace;
    TextView txtD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__b);

        btnA = (Button) findViewById(R.id.btn1);
        btnB = (Button) findViewById(R.id.btn2);
        Intent intent = getIntent();
        trace = intent.getStringArrayListExtra("1000");

        txtD = (TextView)findViewById(R.id.txtDisplay);
        String txtTrace = "";
        if(trace != null) {
            for (int i = 0; i < trace.size(); i++) {
                txtTrace = txtTrace + trace.get(i).toString() + "\n";
            }
            txtD.setText(txtTrace);
        }
        else
        {
            trace = new ArrayList<String>();
        }

        View.OnClickListener oclA = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchActivityIntent = new Intent(Activity_B.this, Activity_A.class);

                trace.add("String data from Activity B");

                launchActivityIntent.putExtra("1000", trace);

                startActivity(launchActivityIntent);
            }
        };

        View.OnClickListener oclB = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchActivityIntent = new Intent(Activity_B.this, Activity_C.class);

                trace.add("String data from Activity B");

                launchActivityIntent.putExtra("1000", trace);

                startActivity(launchActivityIntent);
            }
        };

        btnA.setOnClickListener(oclA);

        btnB.setOnClickListener(oclB);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity__b, menu);
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
