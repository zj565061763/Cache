package com.sd.www.cache;

import android.app.Application;

import com.sd.lib.cache.CacheConfig;
import com.sd.lib.cache.FCache;
import com.sd.www.cache.converter.GlobalEncryptConverter;
import com.sd.www.cache.converter.GlobalExceptionHandler;
import com.sd.www.cache.converter.GsonObjectConverter;
import com.tencent.mmkv.MMKV;

public class App extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        MMKV.initialize(this);

        // 初始化
        FCache.init(new CacheConfig.Builder()
                // 设置全局Gson对象转换器
                .setObjectConverter(new GsonObjectConverter())
                // 如果需要加解密，设置全局加解密转换器
                .setEncryptConverter(new GlobalEncryptConverter())
                // 设置全局异常监听
                .setExceptionHandler(new GlobalExceptionHandler())
                .build(this)
        );
    }
}
