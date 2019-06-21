package com.debug.mooc.dubbo.two.server.controller;

import com.debug.mooc.dubbo.one.enums.StatusCode;
import com.debug.mooc.dubbo.one.response.BaseResponse;
import com.debug.mooc.dubbo.one.service.IDubboItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private IDubboItemService dubboItemService;
    /**
     * 测试服务发布方提供的dubbo服务
     * 用户商城列表查询
     */
    @RequestMapping(value="/selectList",method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse selectAll(){
        BaseResponse response = new BaseResponse(StatusCode.SUCCESS);
        try{
            BaseResponse responseItem = dubboItemService.listItems();
            if(responseItem != null){
                response.setData(responseItem.getData());
            }
        }catch (Exception e){
            e.printStackTrace();
            response = new BaseResponse(StatusCode.FAIL);
        }
        //dubboItemService.listItems();
        return response;
    }
}
