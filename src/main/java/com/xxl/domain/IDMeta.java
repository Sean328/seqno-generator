package com.xxl.domain;

/**
 * @author sean
 * @date 2019/01/06/23:52
 **/
public class IDMeta {

    private long versionBits;
    private long typeBits;
    private long machineBits;
    private long timeBits;
    private long sequenceBits;

    public long getTypeBits() {
        return typeBits;
    }

    public IDMeta setTypeBits(long typeBits) {
        this.typeBits = typeBits;
        return this;
    }

    public long getMachineBits() {
        return machineBits;
    }

    public IDMeta setMachineBits(long machineBits) {
        this.machineBits = machineBits;
        return this;
    }

    public long getTimeBits() {
        return timeBits;
    }

    public IDMeta setTimeBits(long timeBits) {
        this.timeBits = timeBits;
        return this;
    }

    public long getSequenceBits() {
        return sequenceBits;
    }

    public IDMeta setSequenceBits(long sequenceBits) {
        this.sequenceBits = sequenceBits;
        return this;
    }
}
