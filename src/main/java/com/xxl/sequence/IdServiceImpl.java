package com.xxl.sequence;

import com.xxl.domain.ID;
import com.xxl.domain.IdMeta;
import com.xxl.domain.IdMetaInstanceHolder;
import com.xxl.domain.IdMetaTypeEnum;
import com.xxl.exception.IdGenerateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author lixin
 * @date 2019-01-09 10:30
 **/
public class IdServiceImpl implements IdService {
    protected static final Logger logger = LoggerFactory.getLogger(IdService.class);

    protected IdMeta idMeta;
    private ID id;
    private String type;
    private long lastTimeStamp = -1L;
    private AtomicLong sequenceNoId = new AtomicLong(0);

    public void init(){
        idMeta = IdMetaInstanceHolder.getIdMetaInstance(type);
        if(idMeta == null){
            throw new IdGenerateException("获取IdMeta失败");
        }
    }

    @Override
    public long nextId() {
        long currentTime = genCurTime();

        if(currentTime < lastTimeStamp){
            throw new IdGenerateException(String.format("current time is before last time, inteval time is %d",lastTimeStamp - currentTime));
        }else if(currentTime == lastTimeStamp){
            //同一时间单位内，新增ID
            sequenceNoId.set(sequenceNoId.incrementAndGet() & idMeta.getSequenctBitsMask());
            if(sequenceNoId.get() == 0){
                // 阻塞到下一个时间单位,获得新的时间戳
                currentTime = tilNextMillis(lastTimeStamp);
            }
        } else {
            //下一个时间单位 赋0
            sequenceNoId.set(0);
        }

        lastTimeStamp = currentTime;
        id.setTime(currentTime);
        id.setSequence(sequenceNoId.get());

        return genId(id,idMeta);
    }

    private long tilNextMillis(long lastTimeStamp){
        long nextTimeStamp = genCurTime();
        while (nextTimeStamp <= lastTimeStamp){
            nextTimeStamp = genCurTime();
        }

        return nextTimeStamp;
    }

    private long genCurTime(){
        long currentTime = 0L;
        if(type.equals(IdMetaTypeEnum.MILLIS.getCode())){
            currentTime = System.currentTimeMillis();
        }else if(type.equals(IdMetaTypeEnum.SECONDS.getCode())){
            currentTime = System.currentTimeMillis() /1000L;
        }

        return currentTime;
    }

    @Override
    public long genId(ID id, IdMeta idMeta) {
        long result = 0L;
        result |= id.getSequence();
        result |= id.getTime() << idMeta.getTimeBitsShift();
        result |= id.getMachine() << idMeta.getMachineBitsShift();
        result |= id.getType() << idMeta.getTypeBitsShift();
        result |= id.getVersion() << idMeta.getVersionBitsShift();

        return result;
    }

    @Override
    public ID decomposeId() {
        return null;
    }

    public String getType() {
        return type;
    }

    public IdServiceImpl setType(String type) {
        this.type = type;
        return this;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
