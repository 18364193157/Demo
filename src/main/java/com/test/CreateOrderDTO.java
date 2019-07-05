//package com.test;
//
//import com.alibaba.fastjson.JSON;
//import com.test.lenho.City;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//
//import java.io.Serializable;
//
///**
// * 描述:
// * yeepay订单
// *
// * @author langyonghe
// * @create 2019-03-26 14:57
// */
//@Data
//public class CreateOrderDTO implements Serializable {
//    private static final long serialVersionUID = 2434421099160421364L;
//
//    @ApiModelProperty("商户订单号")
//    private String orderId;
//
//    @ApiModelProperty(value = "订单金额", notes = "业务上是必须参数，单位： 元， 两位小数， 最低 0.01")
//    private String orderAmount;
//
//    @ApiModelProperty(value = "商品拓展信息", notes = " Json 格式，{“goodsName”:“abc 商品名称”}")
//    private String goodsParamExt;
//
//    @ApiModelProperty("店铺ID")
//    private Long storeId;
//
//    @ApiModelProperty(value = "订单类型", name = "0 APP；  1小程序；  2收银购（线下）',")
//    private Integer orderSource;
//
//    public static void main(String[] args) {
//        City city = new City();
//        city.setName("中华老字号");
//        CreateOrderDTO createOrderDTO = new CreateOrderDTO();
//        createOrderDTO.setOrderId("123456789");
//        createOrderDTO.setOrderAmount("0.01");
//        createOrderDTO.setGoodsParamExt(JSON.toJSONString(city));
//        createOrderDTO.setStoreId(18L);
//        createOrderDTO.setOrderSource(0);
//        System.out.println(JSON.toJSONString(createOrderDTO));
//
//    }
//
//}
