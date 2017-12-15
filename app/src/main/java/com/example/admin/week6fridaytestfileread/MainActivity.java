package com.example.admin.week6fridaytestfileread;

import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivyt";
    File filesDir;
List<File> fileList;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
linearLayout = findViewById(R.id.linearLayoutId);

    }

    public void getSdFiles(View view) {
        filesDir= new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.d(TAG, "onCreate: "+filesDir);
        getFile(filesDir);
//        for (int j = 0; j < fileList.size(); j++) {
//            TextView textView = new TextView(this);
//            textView.setText(fileList.get(j).getName());
//            textView.setPadding(5, 5, 5, 5);
//
//            System.out.println(fileList.get(j).getName());
//
//            if (fileList.get(j).isDirectory()) {
//                textView.setTextColor(Color.parseColor("#FF0000"));
//            }
//            linearLayout.addView(textView);
//        }
    }

    private List<File> getFile(File filesDir) {
        File listFile[] = filesDir.listFiles();
        Log.d(TAG, "getFile: "+listFile.length);
        if (listFile!=null && listFile.length>0){
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isDirectory()){
                    fileList.add(listFile[i]);
                    Log.d(TAG, "getFile: "+listFile[i]);
                    getFile(listFile[i]);
                }else{
                if (listFile[i].getName().endsWith(".png")
                        || listFile[i].getName().endsWith(".jpg")
                        || listFile[i].getName().endsWith(".jpeg")
                        || listFile[i].getName().endsWith(".gif")){
                    Log.d(TAG, "getFile else: "+listFile[i]);
                    fileList.add(listFile[i]);
                }
                }
            }
        }
return fileList;
    }
}
