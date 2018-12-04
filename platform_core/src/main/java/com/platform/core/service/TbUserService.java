/**
 * @author gaopj
 *
 */
package com.platform.core.service;

import com.platform.core.param.AlterPasswordParam;
import com.platform.core.param.RegisterParam;
import com.platform.core.param.common.CommonResult;
import com.platform.core.po.TbUser;
import com.platform.core.vo.TbUserVo;
import com.platform.base.service.BaseService;

public interface TbUserService extends BaseService<TbUser, TbUserVo>{

    /**
     * 注册
     * @param param
     * @return
     */
    CommonResult doRegister(RegisterParam param);

    /**
     * 验证用户是否存在
     * @param userId
     * @return
     */
    TbUser userIsExists(String userId);

    /**
     * 修改密码
     * @param param
     * @return
     */
    CommonResult updateLoginPassword(AlterPasswordParam param);

    /**
     * 忘记密码
     * @param param
     * @return
     */
    CommonResult updateUnLoginPassword(AlterPasswordParam param);
}
