package com.kylelk.toasttest;

import android.app.Notification;
import android.os.Bundle;
import android.app.Activity;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int[] i = {0};

//		EditText edt=(EditText) findViewById(R.id.ToastData);
//		String toast_str=edt.getText().toString();

        Button button = (Button) findViewById(R.id.ShowToast);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                EditText edt = (EditText) findViewById(R.id.ToastData);
                String toast_str = edt.getText().toString();
                
                Toast.makeText(getApplicationContext(), toast_str, Toast.LENGTH_LONG).show();
                /*
                Toast.makeText(getApplicationContext(), toast_str, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), toast_str, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), toast_str, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), toast_str, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), toast_str, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), toast_str, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), toast_str, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), toast_str, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), toast_str, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), toast_str, Toast.LENGTH_LONG).show();
                */
            }
        });

        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                i[0]++;
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(">>>2rd btn is clicked "+i[0]+" times");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    public void onAccessibilityEvent(AccessibilityEvent event) {
        if(event.getEventType() != AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED)
            return; // event is not a notification

        String sourcePackageName = (String)event.getPackageName();

        Parcelable parcelable = event.getParcelableData();
        if(parcelable instanceof Notification){
            // Statusbar Notification
        }
        else{
            // something else, e.g. a Toast message
            String log = "Message: "+event.getText().get(0)+" [Source: "+sourcePackageName+"]";
            // write `log` to file...
        }
    }

}
