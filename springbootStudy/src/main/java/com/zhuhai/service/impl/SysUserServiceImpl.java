package com.zhuhai.service.impl;

import com.zhuhai.mapper.SysUserMapper;
import com.zhuhai.pojo.SysUser;
import com.zhuhai.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/24
 * Time: 20:40
 *
 * @author: hai
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> ListSysUser() {
        return null;
    }
}
