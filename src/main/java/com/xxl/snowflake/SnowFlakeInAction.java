package com.xxl.snowflake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lixin
 * @date 2019-01-03 11:24
 **/
public class SnowFlakeInAction {

    private static final Logger logger = LoggerFactory.getLogger(SnowFlakeInAction.class);

    private final long initialPoch = 1546272000000L;

    /**
     * 每一部分占用位数
     */
    private final long machineIdBits = 5L;
    private final long dataCenterIdBits = 5L;
    private final long sequenceIdBits = 12L;


    /**
     * 支持最大的机器ID,这里是31，说明从0算起最多支持32台机器
     * （这种位移算法可以很快的计算出N位二进制所有标识的最大十进制整数）
     */
    private final long maxMachineId = -1L ^ (-1L << machineIdBits);
    /**
     * 支持最大数据中心ID，这里是31，说明最多支持32个数据中心
     */
    private final long maxDataCenterId = -1 ^ (-1L << dataCenterIdBits);

    /**
     * 最大支持的毫秒内序列ID，这里是4095
     */
    private final long sequenceIDMask = -1 ^ (-1L << sequenceIdBits);


    /**
     * 每一部分偏移位数
     */
    private final long machineIdShift = sequenceIdBits;
    private final long dataCenterIdShift = sequenceIdBits + machineIdBits;
    private final long timestampLeftShift = sequenceIdBits + machineIdBits + dataCenterIdBits;


    private long machineId;
    private long dataCenterId;
    private long sequenceNoId = 0L;
    private long lastTimestamp = -1L;

    public SnowFlakeInAction(long machineId){
        this(machineId,0L);
    }
    public SnowFlakeInAction(long machineId,long dataCenterId){
        if(machineId > maxMachineId){
            throw new IllegalArgumentException(String.format("machine ID cann't greater than %d or less than 0",maxMachineId));
        }

        if(dataCenterId > maxDataCenterId){
            throw new IllegalArgumentException(String.format("dataCenter ID cann't greater than %d or less than 0",maxDataCenterId));
        }

        this.machineId = machineId;
        this.dataCenterId = dataCenterId;
    }

    public synchronized long nextId(){
        long timeStamp = timeGen();
        if(timeStamp < lastTimestamp){
            throw new SeqNoGenerateExeception(String.format("current timestamp is before than last timestamp, interval millis is %d", lastTimestamp -timeStamp));
        }else if(timeStamp == lastTimestamp){
            // 如果是在同一个时间戳内生成的，则sequenceId在这一毫秒内递增
            sequenceNoId = (sequenceNoId+1) & sequenceIDMask;
            //如果为0 则说明了这一毫秒内产生的ID超过了4095，达到了4096，需要阻塞到下一毫秒生成
            if(sequenceNoId == 0){
                timeStamp = getNextMillis(timeStamp);
            }
        }else {
            // 当前时间戳大于记录的上一个时间戳 正常赋值sequenceId
            sequenceNoId = 0L;
        }
        // 赋值lastTimestamp为当前的
        lastTimestamp = timeStamp;

        // 通过移位或运算拼成64位的ID


        long longId = ((timeStamp - initialPoch) << timestampLeftShift)
                | (dataCenterId << dataCenterIdShift)
                | (machineId << machineIdShift)
                | sequenceNoId;

        long timeId = (timeStamp - initialPoch) << timestampLeftShift;
        long dataId = dataCenterId << dataCenterIdShift;
        long machId = machineId << machineIdShift;

//        System.out.println("timeId: "+timeId+"\n dataId: "+dataId+"\n machId: "+machId +"\n sequenceId: "+sequenceNoId);

//        System.out.println(timeId | dataId | machId | sequenceNoId);

        return (timeStamp - initialPoch) << timestampLeftShift //左移22位占位
                | dataCenterId << dataCenterIdShift  //左移17位占位
                | machineId << machineIdShift //左移12位占位
                | sequenceNoId;
    }

    private long getNextMillis(long timeStamp) {
        long nextTimeStamp = timeGen();
        while (nextTimeStamp <= timeStamp){
             nextTimeStamp = timeGen();
        }
        return nextTimeStamp;
    }


    /**
     * 返回以毫秒为单位的当前时间
     *
     * @return 当前时间(毫秒)
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        SnowFlakeInAction snowFlakeInAction = new SnowFlakeInAction(31,12);
        long seqNo = snowFlakeInAction.nextId();
        for(int i =0 ; i < 60; i++){
            System.out.println(snowFlakeInAction.nextId());
        }
//        System.out.println(seqNo);
    }

}
