package com.xxl.domain;

/**
 * @author lixin
 * @date 2019-01-04 14:27
 **/
public class IdMeta extends BaseDomain {

    private static final long serialVersionUID = -7434017009994277437L;

    private byte versionBits;
    private byte typeBits;
    private byte machineBits;
    private byte timeBits;
    private byte sequenceBits;

    //向右移位
    private int versionBitsShift;
    private int typeBitsShift;
    private int machineBitsShift;
    private int timeBitsShift;
    private int sequenceBitsShift;

    // 各部分掩码
    private long versionBitsMask;

    private long typeBitsMask;

    private long machineBitsMask;

    private long timeBitsMask;

    private long sequenctBitsMask;

    public IdMeta(byte versionBits,byte typeBits,byte machineBits,byte timeBits,byte sequenceBits){
        this.versionBits = versionBits;
        this.typeBits = typeBits;
        this.machineBits = machineBits;
        this.timeBits = timeBits;
        this.sequenceBits = sequenceBits;
    }

    public IdMeta(){
    }


    public byte getVersionBits() {
        return versionBits;
    }

    public IdMeta setVersionBits(byte versionBits) {
        this.versionBits = versionBits;
        return this;
    }

    public byte getTypeBits() {
        return typeBits;
    }

    public IdMeta setTypeBits(byte typeBits) {
        this.typeBits = typeBits;
        return this;
    }

    public byte getMachineBits() {
        return machineBits;
    }

    public IdMeta setMachineBits(byte machineBits) {
        this.machineBits = machineBits;
        return this;
    }

    public byte getTimeBits() {
        return timeBits;
    }

    public IdMeta setTimeBits(byte timeBits) {
        this.timeBits = timeBits;
        return this;
    }

    public byte getSequenceBits() {
        return sequenceBits;
    }

    public IdMeta setSequenceBits(byte sequenceBits) {
        this.sequenceBits = sequenceBits;
        return this;
    }

    public long getVersionBitsShift() {
        return sequenceBits + timeBits + machineBits + typeBits;
    }

    public long getTypeBitsShift() {
        return sequenceBits + timeBits + machineBits;
    }

    public long getMachineBitsShift() {
        return sequenceBits + timeBits;
    }

    public long getTimeBitsShift() {
        return sequenceBits;
    }

    public long getVersionBitsMask() {
        return -1 ^ (-1L << versionBits);
    }

    public long getTypeBitsMask() {
        return -1 ^ (-1L << typeBits);
    }

    public long getMachineBitsMask() {
        return -1 ^ (-1L << machineBits);
    }

    public long getTimeBitsMask() {
        return -1 ^ (-1L << timeBits);
    }

    public long getSequenctBitsMask() {
        return -1 ^ (-1L << sequenceBits);
    }

}
