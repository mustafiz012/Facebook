package webapp.kuet.musta.facebook;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


    WebView faceWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        faceWeb = (WebView) findViewById(R.id.facebook);
        faceWeb.loadUrl("https://www.facebook.com/");
        WebSettings faceSetting = faceWeb.getSettings();
        faceSetting.setJavaScriptEnabled(true);
        faceSetting.setSupportZoom(true);
        faceSetting.setBuiltInZoomControls(true);
        faceWeb.setWebViewClient(new WebViewClient());
        faceSetting.setUseWideViewPort(true);



    }

    @Override
    public void onBackPressed() {
        if (faceWeb.canGoBack()){
            faceWeb.goBack();
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Exiting now???")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && faceWeb.canGoBack()){
            faceWeb.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
