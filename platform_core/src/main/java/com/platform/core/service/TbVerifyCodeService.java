/**
 * @author gaopj
 *
 */
package com.platform.core.service;

import com.platform.core.po.TbVerifyCode;
import com.platform.core.vo.TbVerifyCodeVo;
import com.platform.base.service.BaseService;

public interface TbVerifyCodeService extends BaseService<TbVerifyCode, TbVerifyCodeVo>{

    int getVerifyCode(String email,int type);
}
