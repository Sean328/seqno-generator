package com.xxl.domain;

/**
 * @author sean
 * @date 2019/01/06/23:50
 **/
public class ID extends BaseDomain{
    private static final long serialVersionUID = 1841732843392287161L;

    private long version;
    private long type;
    private long machine;
    private long time;
    private long sequence;

    public long getVersion() {
        return version;
    }

    public ID setVersion(long version) {
        this.version = version;
        return this;
    }

    public long getType() {
        return type;
    }

    public ID setType(long type) {
        this.type = type;
        return this;
    }

    public long getMachine() {
        return machine;
    }

    public ID setMachine(long machine) {
        this.machine = machine;
        return this;
    }

    public long getTime() {
        return time;
    }

    public ID setTime(long time) {
        this.time = time;
        return this;
    }

    public long getSequence() {
        return sequence;
    }

    public ID setSequence(long sequence) {
        this.sequence = sequence;
        return this;
    }
}
