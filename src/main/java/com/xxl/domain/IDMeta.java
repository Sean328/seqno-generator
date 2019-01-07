package com.xxl.domain;

/**
 * @author sean
 * @date 2019/01/06/23:52
 **/
public class IDMeta extends BaseDomain{
    private static final long serialVersionUID = -1787589189969229716L;

    /**
     * 每部分所占位数
     */
    private byte versionBits;
    private byte typeBits;
    private byte machineBits;
    private byte timeBits;
    private byte sequenceBits;

    /**
     * 各个部分偏移位置
     * 向左移位的规则是，某部分移位的时候，后面部分加起来需要占多少位，那么该部分就向左移多少位
     */
    private long versionShift;
    private long typeShift;
    private long machineShift;
    private long timeShift;
    private long sequenctShift;

    public IDMeta(byte versionBits,byte typeBits,byte machineBits,byte timeBits,byte sequenceBits){
        this.versionBits = versionBits;
        this.typeBits = typeBits;
        this.machineBits = machineBits;
        this.timeBits = timeBits;
        this.sequenceBits = sequenceBits;
    }

    public long getTypeBits() {
        return typeBits;
    }

    public IDMeta setTypeBits(byte typeBits) {
        this.typeBits = typeBits;
        return this;
    }

    public byte getMachineBits() {
        return machineBits;
    }

    public IDMeta setMachineBits(byte machineBits) {
        this.machineBits = machineBits;
        return this;
    }

    public byte getTimeBits() {
        return timeBits;
    }

    public IDMeta setTimeBits(byte timeBits) {
        this.timeBits = timeBits;
        return this;
    }

    public byte getSequenceBits() {
        return sequenceBits;
    }

    public IDMeta setSequenceBits(byte sequenceBits) {
        this.sequenceBits = sequenceBits;
        return this;
    }

    public byte getVersionBits() {
        return versionBits;
    }

    public IDMeta setVersionBits(byte versionBits) {
        this.versionBits = versionBits;
        return this;
    }

    public long getVersionShift() {
        return versionShift;
    }

    public IDMeta setVersionShift(long versionShift) {
        this.versionShift = versionShift;
        return this;
    }

    public long getTypeShift() {
        return typeShift;
    }

    public IDMeta setTypeShift(long typeShift) {
        this.typeShift = typeShift;
        return this;
    }

    public long getMachineShift() {
        return machineShift;
    }

    public IDMeta setMachineShift(long machineShift) {
        this.machineShift = machineShift;
        return this;
    }

    public long getTimeShift() {
        return timeShift;
    }

    public IDMeta setTimeShift(long timeShift) {
        this.timeShift = timeShift;
        return this;
    }

    public long getSequenctShift() {
        return sequenctShift;
    }

    public IDMeta setSequenctShift(long sequenctShift) {
        this.sequenctShift = sequenctShift;
        return this;
    }
}
