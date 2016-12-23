package com.lyh.testdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWeather();
    }

    private void getWeather() {
        AppClient.ApiStores apiStores = AppClient.retrofit().create(AppClient.ApiStores.class);
        Observable<WeatherJson> observable = apiStores.getWeather("101010100");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherJson>() {
                    @Override
                    public void onCompleted() {
                        Log.i("wxl", "onCompleted");
                    }
                    @Override
                    public void onError(Throwable e) {
                        Log.i("wxl", "e=" + e.getMessage());
                    }
                    @Override
                    public void onNext(WeatherJson weatherJson) {
                        Log.i("wxl", "getWeatherinfo=" + weatherJson.getWeatherinfo().toString());
                    }
                });

    }
}
