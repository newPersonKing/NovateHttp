# NovateHttp
NovateHttp 一个网络框架 可以直接引入Model 工具类 也写好了 直接依赖 使用
简单示例

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
