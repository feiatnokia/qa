package com.tututu.qa.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: 玉麒麟
 * @create: 2020-02-23 22:51
 **/
@Data
@Builder
public class RouterParam {
    private int current;
    private int pageSize;
    private int name;
}
