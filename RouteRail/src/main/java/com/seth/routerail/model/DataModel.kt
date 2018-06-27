package com.seth.routerail.model

import com.seth.routerail.model.BaseModel

/**
 * Created by hspcadmin on 2018/6/27.
 */
class DataModel{
    public fun request(token: String): BaseModel<Any>?{
        var model: BaseModel<Any>? = null
        try {
            model = Class.forName(token).newInstance() as BaseModel<Any>
        }catch (e: ClassNotFoundException){
            e.printStackTrace()
        }catch (e: InstantiationException){
            e.printStackTrace()
        }catch (e: IllegalAccessException){
            e.printStackTrace()
        }
        return model
    }

}