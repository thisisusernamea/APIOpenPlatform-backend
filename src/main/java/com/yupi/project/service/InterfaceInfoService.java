package com.yupi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.project.model.entity.InterfaceInfo;

/**
* @author 常俊杰
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-02-26 19:25:16
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean b);
}
