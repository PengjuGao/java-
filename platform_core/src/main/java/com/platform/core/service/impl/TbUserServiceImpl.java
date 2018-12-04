/**
 * @author gaopj
 */
package com.platform.core.service.impl;

import com.platform.base.cache.MemcacheCache;
import com.platform.base.utils.StringUtils;
import com.platform.core.param.AlterPasswordParam;
import com.platform.core.param.RegisterParam;
import com.platform.core.param.common.CommonResult;
import com.platform.core.service.TbVerifyCodeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbUserMapper;
import com.platform.core.po.TbUser;
import com.platform.core.vo.TbUserVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbUserService;

import java.util.List;

@Service
public class TbUserServiceImpl extends BaseServiceImpl<TbUser, TbUserVo> implements TbUserService {

    @Autowired
    private TbUserMapper mapper;
    @Autowired
    private TbVerifyCodeService verifyCodeService;
    @Autowired
    private MemcacheCache memcacheCache;

    /**
     * 注册
     * @param param
     * @return
     */
    @Override
    public CommonResult doRegister(RegisterParam param) {
        CommonResult result = new CommonResult();
        String code = (String)memcacheCache.getCacheValue(param.getUserId());

        if(StringUtils.isNullString(param.getVerifyCode())
                && param.getVerifyCode().equals(code)){
            result.setCode(303);
            result.setMessage("验证码错误");
        }

        //不存在，插入数据，注册成功
        if (userIsExists(param.getUserId()) == null ) {
            TbUser tbUser = new TbUser();
            BeanUtils.copyProperties(param, tbUser);
            tbUser.setStatus("1");
            int id = mapper.insert(tbUser);
            System.out.println(id);
        } else {
            result.setCode(201);
            result.setMessage("邮箱已存在，请重新输入");
        }
        return result;
    }

    /**
     * 校验用户是否存在true 存在；false 不存在
     * @return
     */
    @Override
    public TbUser userIsExists(String userId) {
        TbUserVo vo = new TbUserVo();
        TbUserVo.Criteria citer = vo.or();
        citer.andUserIdEqualTo(userId);
        List<TbUser> list = mapper.selectByVo(vo);
        if (list != null && list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 登录之后修改密码
     * @return
     */
    @Override
    public CommonResult updateLoginPassword(AlterPasswordParam param) {
        CommonResult result = new CommonResult();
        String userId = param.getUserId();
        //校验用户是否存在
        TbUser tbUser = userIsExists(userId);
        if (tbUser != null) {
            //param.getType = 1 是修改密码  =2 忘记密码
            if(param.getType()==1){
                if(param.getOldPassword().equals(tbUser.getPassword())){
                    tbUser.setPassword(param.getNewPassword());
                }else{
                    result.setCode(308);
                    result.setMessage("原密码不正确");
                    return result;
                }
            }else if(param.getType()==2){
                tbUser.setPassword(param.getNewPassword());
            }else{
                result.setCode(301);
                result.setMessage("修改密码参数type 值错误");
                return result;
            }
           mapper.updateByPrimaryKey(tbUser);
        }else {
            result.setCode(202);
            result.setMessage("user is not existed ....");
        }
        return result;
    }

    /**
     * 忘记密码
     * @param param
     * @return
     */
    @Override
    public CommonResult updateUnLoginPassword(AlterPasswordParam param){
            CommonResult result = new CommonResult();
            //查询验证码
          // String verifyCode = verifyCodeService.getVerifyCode(param.getUserId(),param.getType())+"";
        String verifyCode = (String) memcacheCache.getCacheValue(param.getUserId());
           if(param.getVerifyCode().equals(verifyCode)){
               updateLoginPassword(param);
           }else{
               result.setCode(203);
               result.setMessage("验证码错误-----");
           }
           return result;
        }
}
