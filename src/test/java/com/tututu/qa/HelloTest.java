package com.tututu.qa;


import com.tututu.qa.common.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

/**
 * @description:
 * @author: 玉麒麟
 * @create: 2020-02-23 00:34
 **/
@Slf4j
public class HelloTest {

    @Test
    public void add(){
        log.info("hello");
        log.info(UUIDUtils.uuid());
    }
}
