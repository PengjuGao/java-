package com.platform.client.web.home;

import com.platform.base.common.shiro.ShiroUser;
import com.platform.client.config.ConfigVo;
import com.platform.client.enums.SoftwareEnum;
import com.platform.client.utils.SessionUtils;
import com.platform.core.po.TbRecord;
import com.platform.core.service.TbRecordService;
import com.platform.core.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/1/7.
 * 首页控制器
 */
@Controller
@RequestMapping("/platform/home")
public class HomeController {

    @Autowired
    private ConfigVo configVo;
    @Autowired
    private TbRecordService recordService;

    /**
     * t跳转到首页
     * @return
     */
    @RequestMapping("/gotoHome")
    public String gotoHome(){
        return "/project/home";
    }

    /**
     * t跳转到说明页
     * @return
     */
    @RequestMapping("/gotoShow")
    public String gotoShow(){
        return "/project/show";
    }

    /**
     * t跳转到下载页面
     * @return
     */
    @RequestMapping("/gotoDownload")
    public String gotoDownload(){
        return "/project/softDownload";
    }

    /**
     * 下载软件
     * @return
     */
    @RequestMapping("/doDownload")
    public String doDownload(String name, HttpServletResponse response){
        //获取路径
        String path = configVo.getSoftewarePath();
        InputStream inputStream = null;
        OutputStream os = null;
        boolean flag = true;
        //根据名称获取文件名
        SoftwareEnum softwareEnum = SoftwareEnum.getEnum(name);
        try {
            if(softwareEnum == null){
                return "/error";
            }else{
                String fileUrl = path+ File.separator+softwareEnum.file_name;
                System.out.println("download:>>>>>>>>>>>>>>>>>>>>>>>>>>"+fileUrl);
                response.reset();
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment;fileName="
                        + softwareEnum.file_name);
                File downloadFile = new File(fileUrl);
                if(!downloadFile.exists()){
                    return "/error";
                }
                inputStream = new FileInputStream(downloadFile);
                os = response.getOutputStream();
                byte[] b = new byte[2048];
                os.flush();
                int length;
                while ((length = inputStream.read(b)) > 0) {
                    os.write(b, 0, length);
                }

            }
        } catch (IOException e) {
            flag = false;
            e.printStackTrace();
        }finally {
            // 这里主要关闭。
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                flag = false;
                e.printStackTrace();
            }finally {
                if(flag){
                    TbRecord record = new TbRecord();
                    ShiroUser shiroUser = SessionUtils.getShiroUser();
                    if(shiroUser != null){
                        record.setUserId(shiroUser.getId());
                    }
                    record.setStatus(2);//下载其他软件
                    record.setRecordType(9999);
                    record.setCreateTime(new Date());
                    record.setUpdateTime(new Date());
                    record.setRecordDetail(softwareEnum.alais+"----->>>>>>被下载了~~~");
                    this.recordService.insert(record);
                }
            }
        }

        return null;
    }

}
