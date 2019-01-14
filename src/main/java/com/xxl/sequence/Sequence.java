package com.xxl.sequence;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lixin
 * @date 2019-01-08 18:41
 **/
@Service
public class Sequence {

    @Resource
    private IdService idService;

    /**
     *
     * @return id
     */
    public long getSeqNo() {
        return idService.nextId();
    }


    /**
     * 根据传业务类型、长度、前缀生成业务流水号，规则:prefix+yyyyMMdd+0000*，
     * length只除了businessType和yyyyMMdd之外的长度
     * 该方法不能放到业务方法的事务中
     *
     * @param sysCode      系统编码-非空
     * @param businessType 业务类型-非空
     * @param length       按日序列号长度-非空
     * @param prefix       流水号前缀
     * @return BusinessNo
     */
    public String getBusinessSeqNo(String sysCode, String businessType, int length, String prefix) {
//        Preconditions.checkArgument(StringUtils.isEmpty(sysCode));
//        Preconditions.checkArgument(StringUtils.isNoneBlank(businessType));
//        Preconditions.checkArgument(length > 0);
//        return sequenceService.getBusinessNo(sysCode + businessType, length, prefix);
        return null;
    }

}
