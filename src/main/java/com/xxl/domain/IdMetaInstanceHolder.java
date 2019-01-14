package com.xxl.domain;

/**
 * ID类型工厂文件
 * @author lixin
 * @date 2019-01-08 11:23
 **/
public class IdMetaInstanceHolder {

    /**
     * 以秒为单位生成ID，秒位占32位，序号位占20位，同一秒内最多产生 2^20次方个ID，即1048576 个，理论上不会超过，超过则阻塞到下一秒
     */
    private static IdMeta secondsType = new IdMeta((byte) 1,(byte)1,(byte)12,(byte)30,(byte)20);

    /**
     * 以毫秒为单位生成ID，毫秒位占40位，序号为占10位，同一毫秒内最多产生2^10次方个ID，即1024个,超过则阻塞至下一毫秒
     */
    private static IdMeta millisType = new IdMeta((byte)1,(byte)1,(byte)12,(byte)40,(byte)10);

    private IdMetaInstanceHolder(){};


    public static IdMeta getIdMetaInstance(String type){
        if(type.equals(IdMetaTypeEnum.MILLIS.getCode())){
            return millisType;
        } else if(type.equals(IdMetaTypeEnum.SECONDS.getCode())){
            return secondsType;
        } else {
            return null;
        }
    }

}
