package com.temp.nohttpmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tamic.novate.Throwable
import com.tamic.novate.callback.ResponseCallback
import com.tamic.novate.callback.RxStringCallback
import com.temp.nohttpmodel.http.Api
import com.temp.nohttpmodel.http.HttpRequestUtils

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData();
    }

    private fun getData(){
        var map = HashMap<String,Any>();
        map["teamId"] = ""
        map["materialRequisitionType"] = ""
        map["dictionaryOverhaulType"] = ""
        map["lineCode"] = ""
        map["depotCode"] = ""
        map["gmtReceiveStart"] = ""
        map["gmtReceiveEnd"] = ""
        map["gmtReceiveStart"] = ""
        map["pageNo"] = 1
        map["pageSize"] = 10

        HttpRequestUtils.getInstance().novate.rxBody(Api.MATERIAL_RENT_LIST_PAGE,map,object : RxStringCallback(){
            override fun onNext(tag: Any?, response: String?) {
              Log.i("ccccccccccc","response=="+response)
            }

            override fun onError(tag: Any?, e: Throwable?) {
                Log.i("ccccccccccc","error=="+e?.message)
            }

            override fun onCancel(tag: Any?, e: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}
