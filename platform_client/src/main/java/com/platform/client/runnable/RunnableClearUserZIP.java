package com.platform.client.runnable;

import com.platform.client.utils.FileUtils;
import com.platform.core.po.TbRecord;
import com.platform.core.service.TbRecordService;
import com.platform.core.vo.TbRecordVo;
import net.sf.json.JSONObject;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by CHUCHU on 2017/5/23.
 */
public class RunnableClearUserZIP implements Runnable{

    private Date date;
    private long userId;
    private String url;
    private String currentProject;

    public String getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(String currentProject) {
        this.currentProject = currentProject;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TbRecordService getRecordService() {
        return recordService;
    }

    public void setRecordService(TbRecordService recordService) {
        this.recordService = recordService;
    }

    private TbRecordService recordService;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        System.out.println("begin delete zip------");
        TbRecordVo recordVo = new TbRecordVo();
        TbRecordVo.Criteria citer = recordVo.or();
        citer.andCreateTimeLessThan(date);
        citer.andUserIdEqualTo(userId);
        citer.andStatusEqualTo(1);

        List<TbRecord> recordList = this.recordService.selectByVo(recordVo);
        for (TbRecord record :
                recordList) {
            TbRecord tempRecord = new TbRecord();
            tempRecord.setId(record.getId());
            tempRecord.setStatus(0);//设置为无效
            tempRecord.setUpdateTime(new Date());
            this.recordService.updateByPrimaryKeySelective(tempRecord);
            //删除文件和文件夹
            JSONObject jsonObject = JSONObject.fromObject(record.getRecordDetail());
            System.out.println("[runnable]================================="+jsonObject);
            //fcfa61855a28","urlRewiter":"","userId":"619109848@qq.com","webFramework":"springMVC","downloadUrl":"/mnt/download/619109848@qq.com/SSM"}
            String dirUrl = jsonObject.getString("downloadUrl");
            //删除文件夹，删除zip文件
            String fileUrl = dirUrl+"_java_framework.zip";
            FileUtils.deleteDir(new File(dirUrl));
            FileUtils.deleteDir(new File(fileUrl));
        }
        System.out.println("begin delete zip------");
    }


}
