package com.test.java8;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

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
        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
        createOrderDTO.setOrderId("119120110");
        createOrderDTO.setOrderAmount("0.02");
        createOrderDTO.setGoodsParamExt("{\"name\":\"aasjdfkaj\"}");
        createOrderDTO.setOrderSource(0);
        createOrderDTO.setStoreId(18L);

        System.out.println(JSON.toJSONString(createOrderDTO));
    }
}
