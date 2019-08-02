package top.wenburgyan.androidlearningviews;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.leon.lfilepickerlibrary.LFilePicker;

import java.io.File;

//import com.nbsp.materialfilepicker.MaterialFilePicker;
//
//import java.util.regex.Pattern;

public class FileChooseTestActivity extends AppCompatActivity {

    Button filePickerButton;
    TextView pickerResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_choose_test);
        filePickerButton = (Button) findViewById(R.id.filePickerBtn);
        pickerResultTextView = (TextView) findViewById(R.id.pickerResultTv);

        filePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //一个不错的文件选择库，可以定制尺寸类型等指标进行文件筛选，只显示文件夹和对应类型的文件
//                int REQUESTCODE_FROM_ACTIVITY = 1000;
//                new LFilePicker()
//                        .withActivity(FileChooseTestActivity.this)
//                        .withRequestCode(REQUESTCODE_FROM_ACTIVITY)
//                        .withStartPath("/storage/emulated/0/Download")
//                        .withIsGreater(false)
//                        .withFileSize(5000 * 1024)
//                        .withFileFilter(new String[]{ ".pdf"})
//                        .start();

                //调用系统的文件选择，1-制定某一类型 2-制定多种类型(kitkat4.4前后有差异) 3设置选择多个，返回数据利用getClipData获取URI
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);//可以设置进行多选；图片不支持大图预览
//                intent.setAction(Intent.ACTION_PICK); //只能选择一个；图片支持大图查看再选择
//                intent.setType("*/*");//所有类型
//                intent.setType("image/*");//图片类型
//                intent.setType("application/pdf");//pdf文件

                intent.setType("*/*"); //下述三行是4.4之后设置多个过滤条件的方式
                String[] mimeTypes = {"image/*", "application/pdf"};
                intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);

//                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);//多选设置
//                Intent wrapperIntent = Intent.createChooser(intent, "pdfffff");
                startActivityForResult(intent,0);
            }
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},
                    2);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.i("xx", "onRequestPermissionsResult: "+permissions+grantResults);
        for (int i=0;i<permissions.length;i++) {
            Log.i("xx", "onRequestPermissionsResult: "+permissions[i]+grantResults[i]);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(data!=null && data.getData()!=null)
        Log.i("xx", "onActivityResult: "+data.getData().toString());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            if(data.getClipData()!=null){
                pickerResultTextView.setText(data.getClipData().toString());
            }
        }
    }
}
