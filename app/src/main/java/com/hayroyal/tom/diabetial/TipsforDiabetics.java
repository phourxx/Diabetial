package com.hayroyal.tom.diabetial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class TipsforDiabetics extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipsfor_diabetics);

        TextView link = (TextView)findViewById(R.id.textView31);
        link.setMovementMethod(LinkMovementMethod.getInstance());

        // Setup Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(R.string.title_activity_tips_for_diabetics);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // Return to the previous activity on back press
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    // To prevent crashes due to pressing physical menu buttons
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if ( keyCode == KeyEvent.KEYCODE_MENU ) {
            // return true to prevent further propagation of the key event
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    // On clicking the back button
    @Override
    public void onBackPressed() {
        Intent back = new Intent(this, HomePage.class);
        startActivity(back);
        finish();
    }
}