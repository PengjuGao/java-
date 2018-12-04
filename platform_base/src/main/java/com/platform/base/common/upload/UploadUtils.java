package com.platform.base.common.upload;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class UploadUtils {

	// 流转化成字符串
	  public static String inputStream2String(InputStream is,String charset) throws IOException
	  {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    int i = -1;
	    while ((i = is.read()) != -1)
	    {
	      baos.write(i);
	    }
	    return baos.toString(charset);
	  }

	  // 流转化成文件
	  public static String inputStream2File(InputStream is,String staticPath, String savePath,String name)
	      throws Exception
	  {
	    System.out.println("file upload path:" + savePath);
	    File file = new File(savePath,name);
	    if(!file.getParentFile().exists()){
	    	file.getParentFile().mkdirs();
	    }
	    
	    InputStream inputSteam = is;
	    BufferedInputStream fis = new BufferedInputStream(inputSteam);
	    FileOutputStream fos = new FileOutputStream(file);
	    int f;
	    while ((f = fis.read()) != -1)
	    {
	      fos.write(f);
	    }
	    fos.flush();
	    fos.close();
	    fis.close();
	    inputSteam.close();
	    
	    return staticPath+File.separator+name;
	  }
}
