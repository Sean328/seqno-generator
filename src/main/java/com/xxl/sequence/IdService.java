package com.xxl.sequence;

import com.xxl.domain.ID;
import com.xxl.domain.IdMeta;

/**
 * @author lixin
 * @date 2019-01-08 18:29
 **/
public interface IdService {

    /**
     * 生成ID
     * @return
     */
    public long nextId();

    /**
     * 根据传入的各个部分生成ID
     * @return
     */
    public long genId(ID id, IdMeta idMeta);

    /**
     * 分解ID
     * @return
     */
    public ID decomposeId();

}
