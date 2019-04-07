package com.zhuhai.controller;

import com.zhuhai.exception.BusinessException;
import com.zhuhai.exception.EnumBusinessError;
import com.zhuhai.pojo.User;
import com.zhuhai.service.UserService;
import com.zhuhai.vo.ResultBean;
import com.zhuhai.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/21
 * Time: 22:34
 *
 * @author: hai
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String listUser(Model model) {
        List<User> userList = userService.listUser();
        model.addAttribute("userList", userList);
        return "user";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<UserVO> findAllUser() {
        List<User> userList = userService.findAll();
        List<UserVO> userVOList = new ArrayList<>();
        for (User user : userList) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            userVOList.add(userVO);
        }

        BeanUtils.copyProperties(userList, userVOList);
        return userVOList;
    }


    @RequestMapping("/{id}/info")
    @ResponseBody
    public ResultBean findUserById(@PathVariable("id") Long id) {
        if (id == 1) {
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST);
        }
        User user = userService.findById(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return ResultBean.success(userVO);
    }
}
