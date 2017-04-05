package xyz.guutong.pdfviewerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import xyz.guutong.androidpdfviewer.PdfViewActivity;

public class MainActivity extends AppCompatActivity {
    private EditText mPdfUrl;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPdfUrl = (EditText) findViewById(R.id.pdfUrl);
        Button mOpenPdf = (Button) findViewById(R.id.openPdf);
        intent = new Intent(this, PdfViewActivity.class);

        mOpenPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(PdfViewActivity.EXTRA_PDF_URL, mPdfUrl.getText().toString());
                intent.putExtra(PdfViewActivity.EXTRA_SHOW_CLOSE_BUTTON, true);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int pageNum = Integer.parseInt(data.getStringExtra(PdfViewActivity.EXTRA_PAGE_NUM));
        Toast.makeText(this, String.valueOf(pageNum), Toast.LENGTH_LONG).show();
    }
}
