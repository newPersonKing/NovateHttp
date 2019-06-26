package com.tamic.novate.callback;




import android.util.Log;

import com.tamic.novate.util.LogWraper;

import org.json.JSONObject;

import java.io.File;

import okhttp3.Call;
import okhttp3.ResponseBody;

/**
 * RxStringCallback  字符串解析器
 *
 * Created by Tamic on 2017-5-30.
 * ink :https://github.com/Tamicer/Novate
 *
 */
public abstract class RxStringCallback extends ResponseCallback<String, ResponseBody> {

    @Override
    public String onHandleResponse(ResponseBody response) throws Exception {
        String  responseString = new String(response.bytes());
        Log.d("Novate", responseString);
        return responseString;
    }

    @Override
    public void onNext(Object tag, Call call, String response) {

        JSONObject jsonObject = null;
        LogWraper.e(TAG, response);
        try {
            jsonObject = new JSONObject(response);
            int code = jsonObject.optInt("state");
            String msg = jsonObject.optString("msg");
            boolean success = jsonObject.optBoolean("success");

            if (code == 401) {
                gotoLogin();
                return;
            }

            onNext(tag, response);
        } catch (Exception e) {
        }
    }
    public abstract void onNext(Object tag, String response);

    public void gotoLogin(){

    }
}
