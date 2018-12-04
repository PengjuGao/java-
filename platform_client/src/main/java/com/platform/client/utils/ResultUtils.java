package com.platform.client.utils;

import com.platform.base.utils.StringUtils;
import com.platform.core.param.common.CommonResult;
import net.sf.json.JSONObject;

/**
 * Created by gaopengju on 2016/12/28.
 * 统一处理返回结果类
 */
public class ResultUtils {

    public final static String VIEW_TYPE_PAGE="page";//返回页面
    public final static String VIEW_TYPE_JSON="json";//返回json

    /**
     * 根据处理结果 和需要返回视图的类型，进行正确的返回
     * @param result
     * @param viewType page，json
     * @param view
     * @param errorView
     * @return
     */
    public static String getView(CommonResult result,String viewType,String view,String errorView) {

       int code = result.getCode();
       //正常情况
       if(code == 200){
           if(VIEW_TYPE_PAGE.equals(viewType)){
               return view;
           }else if(VIEW_TYPE_JSON.equals(viewType)){
               return JSONObject.fromObject(result).toString();
           }
       }else{
           //异常情况
           if(VIEW_TYPE_PAGE.equals(viewType)){
               if(StringUtils.isNotNullString(errorView)){
                   return errorView;
               }else if(StringUtils.isNotNullString(view)){
                   return view;
               }else {
                   // throw new Exception("you must give an right view......");
               }
           }else if(VIEW_TYPE_JSON.equals(viewType)){
               return JSONObject.fromObject(result).toString();
           }
       }
        return null;
    }
}
