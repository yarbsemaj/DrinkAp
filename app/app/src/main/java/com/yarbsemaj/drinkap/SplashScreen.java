package com.yarbsemaj.drinkap;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new HelloRequest(this).execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
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
class HelloRequest extends AsyncTask <Void, Void, Void> {

   private Context context;
    public HelloRequest(Context context){
        this.context=context;
    }
    JSONParser jParser = new JSONParser();
    // url to get all products list
    private static String url = "http://drinkap.yarbsemaj.com/app/hello.php";

    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    @Override

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected Void doInBackground(Void... args){
        // getting JSON string from URL
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        JSONObject json = jParser.makeHttpRequest(url, "POST", params);
         Boolean success= false;
        try {
            // Checking for SUCCESS TAG
            success = json.getBoolean(TAG_SUCCESS);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.print(success + "flub");
        if (success) {

            Intent intent = new Intent(context, DrinkListGUI.class);
            context.startActivity(intent);
        }
        return null;
    }
}
