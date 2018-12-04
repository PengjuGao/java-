/**
 * @author gaopj
 *
 */
package com.platform.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.core.dao.TbVerifyCodeMapper;
import com.platform.core.po.TbVerifyCode;
import com.platform.core.vo.TbVerifyCodeVo;
import com.platform.base.service.impl.BaseServiceImpl;
import com.platform.core.service.TbVerifyCodeService;

import java.util.List;

@Service
public class TbVerifyCodeServiceImpl extends BaseServiceImpl<TbVerifyCode, TbVerifyCodeVo> implements TbVerifyCodeService {

	@Autowired
	private TbVerifyCodeMapper mapper;

	/**
	 * 根据类型获取status为1的验证码
	 * @param email
	 * @param type
	 * @return
	 */
	@Override
	public int getVerifyCode(String email,int type){

		TbVerifyCodeVo vo = new TbVerifyCodeVo();
		TbVerifyCodeVo.Criteria citer = vo.or();
		citer.andEmailEqualTo(email);
		citer.andTypeEqualTo(type);
		citer.andStatusEqualTo(1);
		List<TbVerifyCode> list = this.mapper.selectByVo(vo);
		if(list != null && list.size() == 1){
			return list.get(0).getVerifyCode().intValue();
		}
		return 0;
	}

}
