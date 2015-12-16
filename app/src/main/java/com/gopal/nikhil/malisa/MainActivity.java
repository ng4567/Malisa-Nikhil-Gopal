package com.gopal.nikhil.malisa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    public void bestfitline(View view) {

        EditText X1 = (EditText) findViewById(R.id.X1); // this gets X2, returns as a float
        double first_x = Double.parseDouble(X1.getText().toString());

        EditText X2 = (EditText) findViewById(R.id.X2); // this gets X2, returns as a float
        double second_x = Double.parseDouble(X2.getText().toString());

        EditText X3 = (EditText) findViewById(R.id.X3); // this gets X3, returns as a float
        double third_x = Double.parseDouble(X3.getText().toString());

        EditText X4 = (EditText) findViewById(R.id.X4); // this gets X2, returns as a float
        double fourth_x = Double.parseDouble(X4.getText().toString());

        EditText Y1 = (EditText) findViewById(R.id.Y1); // this gets Y1, returns as a float
        double first_y = Double.parseDouble(Y1.getText().toString());

        EditText Y2 = (EditText) findViewById(R.id.Y2); // this gets Y2, returns as a float
        double second_y = Double.parseDouble(Y2.getText().toString());

        EditText Y3 = (EditText) findViewById(R.id.Y3); // this gets Y2, returns as a float
        double third_y = Double.parseDouble(Y3.getText().toString());





        // standard deviation and average of x values of x values starts here, stored in x_stdev and average_xs

        double average_xs = (first_x + second_x + third_x) / 3;  //gets the average of the x values, also known as x bar

        double x1_squared = (first_x - average_xs) * (first_x-average_xs);

        double x2_squared = (second_x - average_xs) * (second_x - average_xs);

        double x3_squared = (third_x - average_xs) * (third_x - average_xs);

        double average_sqaures_x = (x1_squared + x2_squared + x3_squared) / 3;

        double x_stdev = Math.sqrt(average_sqaures_x);







    // calculates the standard deviation and average of y values, stored in y_stdev and average_ys


        double average_ys = (first_y + second_y + third_y) / 3; //average of the y values, also known as y bar

        double y1_squared = (first_y - average_ys) * (first_y - average_ys);

        double y2_squared = (second_y - average_ys) * (second_y - average_ys);

        double y3_squared = (third_y - average_ys) * (third_y - average_ys);

        double average_squares_y = (y1_squared + y2_squared + y3_squared) / 3;

        double y_stdev = Math.sqrt(average_squares_y);

    //calculates the correlation coefficient also known as r


        double xy1average = (first_x - average_xs) * (first_y - average_ys); //taking (x - x bar) times (y - y bar for each point)

        double xy2average = (second_x - average_xs) * (second_y - average_ys);

        double xy3average = (third_x - average_xs) * (third_y - average_ys);

        // calculates the value n by adding the the above values

        double n = xy1average + xy2average + xy3average;

        // divides n by standard deviation of x * y

        double stdevx_times_stdevy = x_stdev * y_stdev;

        double n_divided_by_product_stdevs = n / stdevx_times_stdevy;

        // to find r, divide n_divided_by_product_stdevs by number of (x,y) pairs minus 1

        double r = n_divided_by_product_stdevs / 2;

        // to find slope do the formula m = r(stdevy/stdevx)

        double m = r * (y_stdev/x_stdev);

        // to find y intercept, use b = y bar - m(x bar)

        double b = average_ys - m * average_xs;

        // now to find the line equation, y = mx + b

        double concentration = (m * fourth_x) + b;

        //now we have to convert the data type of concentration to a string to toast it

        String string_concentration = String.valueOf(concentration);

        String final_string_to_toast = "Concentration: " + string_concentration;

        Toast test = Toast.makeText(getApplicationContext(), new String(final_string_to_toast), Toast.LENGTH_SHORT);
        test.show();
    }
}
