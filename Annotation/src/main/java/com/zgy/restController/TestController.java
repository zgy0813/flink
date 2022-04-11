package com.zgy.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @GetMapping("/doTest")
    public CallResultMsg testObjectReturn() {
        Map<String, Integer> map = new HashMap();
        map.put("qingfen", 16);
        map.put("lantian", 17);
        map.put("baiyun", 18);
        return new UniformResponseHandler<Map>().sendSuccessResponse(map);
    }


    @GetMapping("/doException/{x}")
    public int testExceptionResturn(@PathVariable int x) {
        if (0 < x && x < 10) {
            throw new UserDefinedException(CodeAndMsg.METHOD_FAIL);
        } else {
            return 1 / 0;
        }
    }
}
