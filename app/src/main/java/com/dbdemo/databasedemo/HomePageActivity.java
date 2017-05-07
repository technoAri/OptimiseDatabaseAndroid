package com.dbdemo.databasedemo;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import io.realm.Realm;
import io.realm.RealmResults;

public class HomePageActivity extends AppCompatActivity {

    Button download, show, execTime;
    Realm realm;
    int id = 0;
    URL url;
    String formattedText;
    long startTime, stopTime, executionTime;
    double execTimeSeconds;
    TextView exec_time;
    ProgressDialog pdLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        exec_time = (TextView) findViewById(R.id.exec_time);
        download = (Button) findViewById(R.id.download_button);
        show = (Button) findViewById(R.id.show_button);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                download.setVisibility(View.INVISIBLE);
                try {

                    //realm.beginTransaction();
                 //   downloadAllFile();
                    new AsyncCaller().execute();
                                        //dialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                download.setVisibility(View.VISIBLE);
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, ShowFilesActivity.class);
                startActivity(intent);
            }
        });
    }

    private void downloadAllFile() throws IOException {
        downloadFile1();
        downloadFile2();
        downloadFile3();
        downloadFile4();
        downloadFile5();
        downloadFile6();
        downloadFile7();
        downloadFile8();
        downloadFile9();
        downloadFile10();
        downloadFile11();
        downloadFile12();
        downloadFile13();
        downloadFile14();
        downloadFile15();
        downloadFile16();
        downloadFile17();
        downloadFile18();
        downloadFile19();
        downloadFile20();
        downloadFile21();
        downloadFile22();
        downloadFile23();
        downloadFile24();
        downloadFile25();
        downloadFile26();
    }

    private void downloadFile1() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_a.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File A");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        //request.setDestinationInExternalFilesDir(getApplicationContext(),null, "File A");
        request.setDescription("File A");

        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_a.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File A");
        model.setBody(formattedText);

        //startTime = (int) System.currentTimeMillis();
        startTime = System.nanoTime();
        System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;


        // get download service and enqueue file
        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile2() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_b.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File B");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        Log.d("fiel", "File B");
        RealmResults<FileModel> results = realm.where(FileModel.class).findAll();
        Log.d("results", String.valueOf(results));
        request.setDescription("File B");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_b.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File B");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile3() throws IOException {

        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_c.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File C");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        //request.setDestinationInExternalFilesDir(getApplicationContext(),null, "File C");
        request.setDescription("File C");

        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_c.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();
        //realm.beginTransaction();
        FileModel model = new FileModel();

        model.setId(id++);
        model.setTitle("File C");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        // get download service and enqueue file
        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile4() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_d.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File D");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File D");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_d.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File D");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile5() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_e.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File E");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File E");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_e.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File E");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile6() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_f.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File F");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File F");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_f.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File F");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile7() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_g.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File G");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File G");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_g.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File G");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile8() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_h.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File H");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File H");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_h.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File H");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile9() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_i.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File I");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File I");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_i.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File I");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile10() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_j.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File J");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File J");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_j.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File J");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile11() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_k.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File K");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File K");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_k.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File K");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile12() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_l.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File L");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File L");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_l.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File L");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile13() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_m.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File M");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File M");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_m.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File M");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile14() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_n.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File N");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File N");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_n.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File N");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile15() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_o.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File O");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File O");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_o.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File O");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile16() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_p.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File P");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File P");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_p.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File P");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile17() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_q.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File Q");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File Q");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_q.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File Q");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile18() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_r.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File R");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File R");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_r.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File R");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile19() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_s.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File S");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File S");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_s.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File S");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile20() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_t.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File T");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File T");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_t.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File T");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile21() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_u.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File U");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File U");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_u.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File U");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile22() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_v.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File V");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File V");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_v.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File V");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile23() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_w.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File W");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File W");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_w.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File W");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile24() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_x.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File X");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File X");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_x.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File X");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile25() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_y.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File Y");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File Y");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_y.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File Y");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private void downloadFile26() throws IOException {
        String DownloadUrl = "http://unreal3112.16mb.com/wb1913_z.html";
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadUrl));
        request.setDescription("downloading");   //appears the same in Notification bar while downloading
        request.setTitle("File Z");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        }
        request.setDescription("File Z");
        URL oracle = new URL("http://unreal3112.16mb.com/wb1913_z.html");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            if (inputLine != null) {
                formattedText = inputLine.replaceAll("\\<.*?>", "");
                System.out.println(formattedText);
            }
        }
        in.close();

        FileModel model = new FileModel();
        model.setId(id++);
        model.setTitle("File Z");
        model.setBody(formattedText);

        startTime = System.nanoTime();
        //System.out.println(stopTime - startTime);
        realm.copyToRealmOrUpdate(model);
        stopTime = System.nanoTime();
        executionTime += stopTime - startTime;

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    private class AsyncCaller extends AsyncTask<Void, Void, Void>
    {
        //pdLoading = new ProgressDialog(HomePageActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


            pdLoading = new ProgressDialog(HomePageActivity.this);

            //this method will be running on UI thread
            pdLoading.setMessage("\tPlease wait while all the files are downloaded...");
            pdLoading.show();
        }
        @Override
        protected Void doInBackground(Void... params) {

            try {
                realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                downloadAllFile();
                realm.commitTransaction();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            //this method will be running on UI thread

            execTimeSeconds = (double)executionTime / 1000000000.0;
            Log.d("time", String.valueOf(execTimeSeconds));
            exec_time.setText("Execution Time: " + String.valueOf(execTimeSeconds) + "seconds");
            pdLoading.dismiss();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pdLoading.dismiss();
    }
}
