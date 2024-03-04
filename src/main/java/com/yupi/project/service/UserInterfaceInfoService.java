package com.yupi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cjj.apiplatformcommon.entity.UserInterfaceInfo;

/**
* @author 常俊杰
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-02-29 12:32:40
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo uerInterfaceInfo, boolean add);
}
