package com.platform.base.common.classTemplate;

import org.mozilla.universalchardet.UniversalDetector;

import java.io.*;

public class FileUtils {


	/**
	 * 读取文件内容，并返回字符串
	 * @param filePath
	 * @return
	 */
	public static String getFileContent(String filePath,String charSet){

		StringBuffer buffer = new StringBuffer();

		Reader reader = null;

		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),charSet)); 

			char[] tempArr = new char[1024];

			int num = 0;

			while((num = reader.read(tempArr)) != -1){

				buffer.append(tempArr,0,num);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
					System.err.println("-----------关闭输入流失败");
					e.printStackTrace();
				}
			}
			
		}

		return buffer.toString();
	}
	
	
	/**
	 * 生成文件
	 * @param filePath
	 * @param content
	 */
	public static void makeFile(String filePath,String content,String charSet,boolean flag){
		
		File tempFile = new File(filePath);
		
		if(tempFile.exists() && !flag){
			return;
		}

		Writer writer = null;
		
		//判断目录是否存在
		File parentFile = tempFile.getParentFile();
		
		if(!parentFile.exists()){
			
			parentFile.mkdirs();
			
		}
		
		
		if(tempFile.exists() && !flag){
			//什么也不做
		}else{
			try {
				//创建FILE
				tempFile.createNewFile();
				//写数据到file
				writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), charSet));

				writer.write(content.toCharArray());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(null !=  writer){
					try {
						writer.flush();
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * 生成文件目录
	 * @param path
	 * @param name
     * @return
     */
	public static String creatdir(String path, String name) {

		return path;
	}

	/**
	 * 生成文件
	 * @param path
	 * @param name
     * @return
     */
	public static String createFile(String path, String name) {

		return path+File.separator+name;
	}


	/**
	 * 判断文件的编码格式
	 * @param fileName :file
	 * @return 文件编码格式
	 * @throws Exception
	 */
	public static String codeString(String fileName) throws Exception{
		BufferedInputStream bin = new BufferedInputStream(
				new FileInputStream(fileName));
		int p = (bin.read() << 8) + bin.read();
		String code = null;

		switch (p) {
			case 0xefbb:
				code = "UTF-8";
				break;
			case 0xfffe:
				code = "Unicode";
				break;
			case 0xfeff:
				code = "UTF-16BE";
				break;
			default:
				code = "GBK";
		}

		return code;
	}

	/**
	 * 转换字符编码
	 * @param old_charset
	 * @param new_charset
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String codeConvert(String old_charset,String new_charset,String fileName) throws Exception {
		StringBuilder builder = new StringBuilder();
		String result = "";
		BufferedInputStream bin = new BufferedInputStream(
				new FileInputStream(fileName));
		byte[] arr = new byte[4096];
		int num = 0;
		while((num = bin.read(arr))!=-1){
//			String unicode = new String(arr,0,num,old_charset);
//			result = new String(unicode.getBytes(new_charset));
            builder.append(new String(arr,0,num,"gbk"));
		}
		return builder.toString() ;
	}



	public static void main11(String[] args) {



		try {
			byte[] buf = new byte[4096];
			FileInputStream fis = new FileInputStream("F:\\javaProject\\sso\\smart\\smart-job\\smart-job-demo\\src\\main\\resources\\job.xml");

			// (1)
			UniversalDetector detector = new UniversalDetector(null);

			// (2)
			int nread;
			while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
				detector.handleData(buf, 0, nread);
			}
			// (3)
			detector.dataEnd();

			// (4)
			String encoding = detector.getDetectedCharset();
			if (encoding != null) {
				System.out.println("Detected encoding = " + encoding);
			} else {
				System.out.println("No encoding detected.");
			}

			// (5)
			detector.reset();



			String out = FileUtils.codeString("F:\\javaProject\\sso\\smart\\smart-job\\smart-job-demo\\src\\main\\resources\\job.xml");
			System.out.println(out);
		} catch (Exception e) {
			e.printStackTrace();
		}


		try {

			String out = FileUtils.codeConvert("utf-8","gbk","F:\\javaProject\\sso\\smart\\smart-job\\smart-job-demo\\src\\main\\java\\com\\smart\\job\\demo\\TestJob.java");
			System.out.println(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		// 字符串与字节串间相互转化

		String string= FileUtils.codeConvert("utf-8","gbk","F:\\20160928_platform\\platform\\platform_base\\src\\main\\java\\com\\platform\\base\\common\\classTemplate\\FileUtils.java");
		System.out.println(string);
// 按照 GB2312 得到字节（得到多字节字符串）
		byte [] bytes = string.getBytes("utf-8");

// 从字节按照 GB2312 得到 UNICODE 字符串
		string = new String(string.getBytes("gbk"), "gbk");

// 要将 String 按照某种编码写入文本文件，有两种方法：

// 第一种办法：用 Stream 类写入已经按照指定编码转化好的字节串
		OutputStream os = new FileOutputStream("1.txt");
		os.write(bytes);
		os.close();

// 第二种办法：构造指定编码的 Writer 来写入字符串
		Writer ow = new OutputStreamWriter(new FileOutputStream("2.txt"), "utf-8");
		ow.write(string);
		ow.close();

	}
}