package com.cnjtg.gitspringboot.rest;

import com.cnjtg.gitspringboot.beans.Results;
import com.cnjtg.gitspringboot.entity.Good;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-08 15:21
 */
@Api(value = "商品管理")
@ApiResponses({@ApiResponse(code = 200, message = "success", response = Results.class)})
@RestController
//@CrossOrigin
@RequestMapping("/api/good")
public class GoodResource {

    @Autowired
//    IGoodService GoodService;

//    @GetMapping("/getGood")
//    public Results getGood() {
//        Good Good = new Good();
//        Good.setGoodname(UUID.randomUUID().toString());
//        Good.setGoodname("tom");
//        Good.setPassword("1234");
//        Good.setAddress("广州");
//        return Results.SUCCESS("成功！", Good);
//    }

    @GetMapping("/list")
    public Results listGood() {
        List<Good> list = new ArrayList<>();
        Good good = new Good();
        good.setId(1);
        good.setTitle("显示器");
        good.setPrice(288.3);

        Good good2 = new Good();
        good2.setId(2);
        good2.setTitle("主板");
        good2.setPrice(188.4);

        Good good3 = new Good();
        good3.setId(3);
        good3.setTitle("CPU");
        good3.setPrice(1188.8);

        Good good4 = new Good();
        good4.setId(4);
        good4.setTitle("键盘");
        good4.setPrice(58.9);

        list.add(good);
        list.add(good2);
        list.add(good3);
        list.add(good4);
        Results results = Results.SUCCESS();
        results.setData(list);
        return results;
    }

}
