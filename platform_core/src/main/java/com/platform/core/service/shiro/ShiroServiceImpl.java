package com.platform.core.service.shiro;

import com.platform.base.common.shiro.ShiroService;
import com.platform.base.common.shiro.ShiroUser;
import com.platform.core.dao.TbUserMapper;
import com.platform.core.po.TbUser;
import com.platform.core.vo.TbUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by gaopengju on 2016/12/28.
 *  shiro的角色权限服务类
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    TbUserMapper userMapper;
    @Override
    public ShiroUser getUserInfo(String username, String password) {
        ShiroUser shiroUser = null;
        TbUserVo vo = new TbUserVo();
        TbUserVo.Criteria citer = vo.createCriteria();
        citer.andUserIdEqualTo(username);
        citer.andPasswordEqualTo(password);
        citer.andStatusEqualTo("1");//有效
        List<TbUser> list = this.userMapper.selectByVo(vo);
        if(list != null && list.size() == 1){
            TbUser tbUser = list.get(0);
            shiroUser = new ShiroUser();
            shiroUser.setPassword(tbUser.getPassword());
            shiroUser.setUsername(tbUser.getUserId());
            shiroUser.setId(tbUser.getId());
            shiroUser.setNick(tbUser.getNick());
            //shiroUser.setUserType();
            //TODO:添加用户类型
        }
        return shiroUser;
    }

    @Override
    public Set<String> getUserRoleSet(String username) {
        return null;
    }

    @Override
    public Set<String> getUserPermissionSet(String username) {
        return null;
    }
}
