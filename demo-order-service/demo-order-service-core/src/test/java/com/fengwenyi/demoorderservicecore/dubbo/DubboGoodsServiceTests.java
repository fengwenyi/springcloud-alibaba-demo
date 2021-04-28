package com.fengwenyi.demoorderservicecore.dubbo;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demogoodsserviceapi.service.IDubboGoodsService;
import com.fengwenyi.demogoodsserviceapi.vo.GoodsResponseVo;
import com.fengwenyi.demoorderservicecore.DemoOrderServiceCoreApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-04-28
 */
@Component
@Slf4j
public class DubboGoodsServiceTests extends DemoOrderServiceCoreApplicationTests {

    @DubboReference
    private IDubboGoodsService dubboGoodsService;

    @Test
    void testGetGoods() {
        ResultTemplate<GoodsResponseVo> resultTemplate = dubboGoodsService.getById(1L);
        if (resultTemplate != null && resultTemplate.getSuccess()) {
            GoodsResponseVo goodsResponseVo = resultTemplate.getBody();
            log.info(goodsResponseVo.toString());
        } else {
            String msg = resultTemplate == null ? "服务调用失败" : resultTemplate.getMessage();
            log.error("goods查询失败，原因：{}", msg);
        }
    }

}
