package com.platform.client.enums;

/**
 * Created by Administrator on 2017/1/21.
 * 软件对应的名称
 */
public enum SoftwareEnum {

    xiaoheitxt("xiaohei-big","HNInstall_Setup_2162296536_7654_121816.exe","小黑记事本"),
    qqpcmgr("qqpcmgr-big","qqpcmgr_v12.1.18202.223_86276.exe","腾讯电脑管家"),
    qqbrowser("qqbrowser-big","QQBrowser_Setup_9.2.5170.402_9.2_Coop_subid@22722.exe","QQ浏览器"),
    baofengyingyin("baoying-big","bdBaofeng.[[1718_00121816]].exe","暴风影音"),
    aiqiyi("big_iqiyi","iqiyi_k42725478_627351.exe","爱奇艺"),
    cmgr360("360-big","360safe+06526DL61311+n478bfd1a95.exe","360安全卫士"),
    shadu360("360-big-antivirus","360sd_06526DL60557.exe","360杀毒"),
    browser360("360-big-browser","360se+06526DL60067+n478bfd1a95.exe","360浏览器"),
    kugou360("kugou-big","kugou7_3577_121915.exe","酷狗音乐盒"),
    kuaiya("kyzip-big","Kuaizip_Setup_7654_1121816.exe","快压软件"),
    kantuwang("ktw","2345pic_k42725478.exe","看图王"),
    browser2345("browser","2345explorer_k42725478.exe","2345浏览器"),
    pingyin2345("pinyin","2345pinyin_k42725478.exe","2345输入法"),
    anquanweishi2345("pcsafe","2345pcsafe_k42725478.exe","2345安全卫士"),
    mofawangzuo("mfwz-big","7654wd2_mfwz121816.exe","魔法王国游戏"),
    tijichongfeng("tqcf-big","7654wd2_tqcf121816.exe","铁骑冲锋游戏"),
    daomubiji("dmbj-big","7654wd2_dmbj121816.exe","盗墓笔记游戏"),
    lanyuechuanqi("big_lycq","lycq_k42725478_100032.exe","蓝月传奇游戏"),
    shaonianqunxiazhuan("big_snqxz","snqxz_k42725478_100029.exe","少年群侠传游戏"),
    maven("maven","apache-maven-3.1.1.rar","Apache Maven 开发工具"),
    memcached("memcached","memcached.rar","Memcached 开发工具"),
    redis("redis","redis-3.0.1-win64.rar","Redis 开发工具"),
    ;

    //对应图片名称
    public String img_name;
    //对应文件名称
    public String file_name;
    //中文名称
    public String alais;
    SoftwareEnum(String img_name,String file_name,String alais){
        this.img_name = img_name;
        this.file_name = file_name;
        this.alais = alais;
    }
    //静态方法获取对应的enum，从而可以获取对应的文件名称
    public static SoftwareEnum getEnum(String img_name){
        for (SoftwareEnum tempEnum:values()
             ) {
            if(tempEnum.img_name.equals(img_name)){
                return tempEnum;
            }
        }
        return null;
    }
}
