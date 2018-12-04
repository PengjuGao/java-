package com.platform.base.common.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.platform.base.utils.CommonUtils;
import com.platform.base.utils.DateUtils;
import com.platform.base.utils.DigestUtils;

/**
 * Created by Administrator on 14-3-25.
 */
public class UnionTag  {

    public static String currDayPrevDay(int day){
        return DateUtils.getCurrDayPrevDay(day);
    }

    /**
     * 获取指定日期的后N天
     * @param date
     * @param n
     * @return
     */
    public static String getNextDay(String date,int n){
        return DateUtils.getNextDay(date, n);
    }

    /**
     * 获取指定日期的前N天
     * @param date
     * @param n
     * @return
     */
    public static String getPrevDay(String date,int n){
        return DateUtils.getPrevDay(date, n);
    }

    public static String substr(Object obj,int index,int end){
        return  substr(obj, index, end, "");
    }

    public static String substr(Object obj,int index,int end,String tempStr){
        if (CommonUtils.isEmpty(obj))
            return "";
        String str = obj.toString();
        if (obj instanceof Date){
            str = DateUtils.formatSimpleDate((Date)obj);
        } else {
            str = str+"";
        }
        int len = str.length();
        if (len>end&&index<end){
            return  str.substring(index,end)+tempStr;
        }
        return  str;
    }



    public static String subwithstr(Object obj,int start,String strx,int index){
        if (CommonUtils.isEmpty(obj))
            return "";
        String str = obj.toString();
        if (obj instanceof Date){
            str = DateUtils.formatSimpleDate((Date)obj);
        } else {
            str = str+"";
        }
        int pos=str.indexOf(strx);
        if (pos+index<0){
            return str;
        }
        return  str.substring(start,str.indexOf(strx)+index);
    }

    public static String from_base64(String val) throws IOException {
        return DigestUtils.fromBase64(val);
    }

    public static String getDate(String date,String format){
       // "%Y年%m月%s日";
        if (CommonUtils.isEmpty(date)) return "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            return simpleDateFormat.format(DateUtils.parseSimpleDate(date));
        }catch (NumberFormatException e) {
            return "";
        }
    }

    public static String format(String date,String format){
        // "%Y年%m月%s日";
        return DateUtils.parseStrDateWithFormat(date,format,format);
    }

    /**根据日期返回周几*/
    public static String getWeek(String date) {
        if (CommonUtils.isEmpty(date)) return null;
        return DateUtils.getWeek(date);
    }

    public static String rep(Object obj, int start, int end, String s1) {
        if (CommonUtils.isEmpty(obj)) return "";
        if (start<0||end<0) return obj.toString();
        String str = obj.toString();
        if (start>str.length()) return str;
        String str1 = str.substring(0,start-1);
        String str2 = "";
        if (start+end<=str.length()){
            str2 = str.substring(start+end-1);
        }

        String replStr = "";
        int index = end;
        if (start+end>str.length()-1){
            index = str.length()-start;
        }
        for(int j=0;j<index;j++){
            replStr+=s1;
        }
        return str1+replStr+str2;
    }

    public static String repinx(Object obj, String str,String replaceStr,int count,int index) {
        if (CommonUtils.isEmpty(obj)) return "";
        if (CommonUtils.isEmpty(str)||count<=0) return obj.toString();
        String args = obj.toString();
        if (!args.contains(str)) return args;
        int ops = args.indexOf(str);
        if (index<0){//符号前
            //fafdsafdsasd@qq.com
            if (count>ops){
                String temp = "";
                for (int j = 0;j<ops;j++) {
                    temp+=replaceStr;
                }
                return temp+args.substring(ops);
            }else {
                String str1 = args.substring(0,ops-count);
                String temp = "";
                for (int j = 0;j<count;j++) {
                    temp+=replaceStr;
                }
                String str3 = args.substring(ops);
                return str1+temp+str3;
            }
        }else {
            if (count>ops){
                String temp = "";
                for (int j = 0;j<args.length()-ops-1;j++) {
                    temp+=replaceStr;
                }
                return args.substring(0,ops+1)+temp;
            }else {
                //fdafdafsda@fdsafdsaf
                String str1 = args.substring(0,ops+1);
                String temp = "";
                for (int j = 0;j<count;j++) {
                    temp+=replaceStr;
                }
                String str3 = args.substring(ops+count+1);
                return str1+temp+str3;
            }
        }

    }
    
    public static String shiftEnter(String str) { 
        String newStr = str.replaceAll("\r\n", "<br>"); // 替换回车换行符
        newStr = newStr.replaceAll(" ", "&nbsp;");// 替换空格符
        return newStr;
    }

    /**
     * 将lonng型time格式化
     * @param value
     * @return
     */
    public static String longtimeToDate(String value){
    	 String s = "";
    	if(StringUtils.isNotBlank(value)){
    		long time = Long.valueOf(value);  
            Calendar c = Calendar.getInstance();  
            c.setTimeInMillis(time);  
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            s = dateformat.format(c.getTime());  
    	}
    	
        return s;
    }
    /**
     * 替换手机号中间位数
     * @param str
     * @return
     */
    public static String StrReplaceAll(String str) {
    	if (StringUtils.isNotBlank(str) && str.length()>=11) {
    		return str.substring(0,3)+"****"+str.substring(7);
		}else {
			return str;
		}
    }
    
    /**
     * 将xxxx-xx字符串替换为xxxx年xx月
     * @param str
     * @return
     */
    public static String strToDateStr(String str) {
    	if (StringUtils.isNotBlank(str)) {
    		str = str.replace("-", "年");
    		str += "月";
    		return str;
		}else {
			return str;
		}
    }
    /**
     * 截取code前4位和后4位，中间用*代替
     * @param code
     * @param len（*号显示数量）
     * @return
     * @author yaohu
     */
    public static String strToCardCode(String code,int len){
    	String ret = code;
    	if(StringUtils.isNotBlank(code) && code.length() > 8){
    		String str = "";
    		if(len <= 0){
    			len = code.length()-8;
    		}
    		for(int i=0;i<len;i++){
    			str += "*";
    		}
    		ret = code.substring(0,4)+str+code.substring(code.length()-4,code.length());
    	}
    	return ret;
    }

    public static String toMoney(Double money){
        if (CommonUtils.isEmpty(money)) return "";
        double fix = Double.parseDouble("0"+money.toString().substring(money.toString().lastIndexOf(".")));

        if (fix>0) {
            return money.toString();
        }
        return money.toString().substring(0,money.toString().lastIndexOf("."));
    }

    public static void main(String[] args) {
        System.out.println(toMoney(4.99D));
	}
}

