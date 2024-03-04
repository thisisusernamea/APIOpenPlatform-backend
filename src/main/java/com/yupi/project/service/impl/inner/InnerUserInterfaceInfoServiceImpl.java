package com.yupi.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjj.apiplatformcommon.entity.UserInterfaceInfo;
import com.cjj.apiplatformcommon.service.InnerUserInterfaceInfoService;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserInterfaceInfoMapper;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    UserInterfaceInfoMapper userInterfaceInfoMapper;

    /**
     *判断用户是否可以调用接口
     * @param userId
     * @param interfaceInfoId
     * @return
     */
    @Override
    public boolean isInvoke(long userId, long interfaceInfoId) {
        if(userId <= 0 || interfaceInfoId <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<UserInterfaceInfo> userInterfaceInfoQueryWrapper = new QueryWrapper<>();
        userInterfaceInfoQueryWrapper.eq("userId",userId);
        userInterfaceInfoQueryWrapper.eq("interfaceInfoId",interfaceInfoId);
        UserInterfaceInfo userInterfaceInfo = userInterfaceInfoMapper.selectOne(userInterfaceInfoQueryWrapper);
        if(userInterfaceInfo.getStatus() != 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"当前用户已被禁用");
        }
        if(userInterfaceInfo.getLeftNum() <= 0){
            return false;
        }
        return true;
    }

    /**
     * 统计用户调用接口次数
     * @param userId
     * @param interfaceInfoId
     * @return
     */
    @Override
    public int invokeCount(long userId, long interfaceInfoId) {
        if(userId <= 0 || interfaceInfoId <= 0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<UserInterfaceInfo> userInterfaceInfoQueryWrapper = new QueryWrapper<>();
        userInterfaceInfoQueryWrapper.eq("userId",userId);
        userInterfaceInfoQueryWrapper.eq("interfaceInfoId",interfaceInfoId);
        UserInterfaceInfo userInterfaceInfo = userInterfaceInfoMapper.selectOne(userInterfaceInfoQueryWrapper);
        userInterfaceInfo.setTotalNum(userInterfaceInfo.getTotalNum() + 1);
        userInterfaceInfo.setLeftNum(userInterfaceInfo.getLeftNum() - 1);
        return userInterfaceInfoMapper.updateById(userInterfaceInfo);
    }
}
