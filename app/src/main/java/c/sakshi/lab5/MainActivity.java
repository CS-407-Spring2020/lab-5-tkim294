package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static String usernameKey;

    public void clickFunction(View view){
        EditText idText = (EditText) findViewById(R.id.idView);
        String id = idText.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", id).apply();
        //String username = sharedPreferences.getString("username", "");
        goToActivity2();
    }

    public void goToActivity2(){
        Intent intent = new Intent(this, Main2Activity.class);
        //intent.putExtra("message", id);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);

        if(!sharedPreferences.getString(usernameKey, "").equals("")) {
            goToActivity2();
        } else{
            setContentView(R.layout.activity_main);
        }
    }
}
