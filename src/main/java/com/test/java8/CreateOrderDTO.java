package com.test.java8;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * yeepay订单
 *
 * @author langyonghe
 * @create 2019-03-26 14:57
 */
@Data
public class CreateOrderDTO implements Serializable {
    private static final long serialVersionUID = 2434421099160421364L;

    @ApiModelProperty("商户订单号")
//    @NotBlank(message = "订单号不能为空")
    private String orderId;

    @ApiModelProperty(value = "订单金额", notes = "业务上是必须参数，单位： 元， 两位小数， 最低 0.01")
//    @NotBlank(message = "订单金额不能为空")
    private String orderAmount;

    @ApiModelProperty(value = "商品拓展信息", notes = " Json 格式，{“goodsName”:“abc 商品名称”}")
//    @NotBlank(message = "商品拓展信息不能为空")
    private String goodsParamExt;

    @ApiModelProperty("店铺ID")
//    @NotNull(message = "店铺ID不能为空")
    private Long storeId;

    @ApiModelProperty(value = "订单类型", name = "0 APP；  1小程序；  2收银购（线下）',")
//    @NotNull(message = "订单类型不能为空")
    private Integer orderSource;

    public static void main(String[] args) {
//        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
//        createOrderDTO.setOrderId("119120110");
//        createOrderDTO.setOrderAmount("0.02");
//        createOrderDTO.setGoodsParamExt("{\"name\":\"aasjdfkaj\"}");
//        createOrderDTO.setOrderSource(0);
//        createOrderDTO.setStoreId(18L);
//
//        System.out.println(JSON.toJSONString(createOrderDTO));
//        String s = "2,3,";
//        BigDecimal bigDecimal = new BigDecimal(String.valueOf(148000L));
//        BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(190L));
//        BigDecimal bigDecimal2 = bigDecimal.divide(bigDecimal1,0,RoundingMode.HALF_UP);
//        System.out.println(bigDecimal2.longValue());

//        List<Long> list = new ArrayList<>();
//        list.add(1L);
//        list.add(2L);
//        list.add(3L);
//        StringBuilder stringBuilder = new StringBuilder();
//        list.forEach(e ->{
//            stringBuilder.append(String.valueOf(e)).append("  ");
//        });
//        System.out.println(stringBuilder.toString());
//
//        System.out.println();
//        System.out.println(" ".equals(" "));
//        System.out.println(s.contains("3"));
        String s = "23.0";
        System.out.println(s.equals(null));
//        int length = s.length();
//        s = s.substring(0,length-2);
//        System.out.println(s);
    }
}
