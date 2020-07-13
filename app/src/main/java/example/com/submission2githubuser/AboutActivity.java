package example.com.submission2githubuser;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{

    Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_about);

        getSupportActionBar().setTitle(getString(R.string.about));
        menu = findViewById(R.id.menu);

        menu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu:
                Intent intentMenu = new Intent(this, MainActivity.class);
                intentMenu.putExtra("KEY_TITLE", "Menu Utama");
                startActivity(intentMenu);
                break;

        }

    }
}
