package com.kezilai.merchant.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.FileItem;
import com.alipay.api.request.AlipayMarketingCardTemplateCreateRequest;
import com.alipay.api.request.AlipayOfflineMaterialImageUploadRequest;
import com.alipay.api.response.AlipayMarketingCardTemplateCreateResponse;
import com.alipay.api.response.AlipayOfflineMaterialImageUploadResponse;
import org.junit.jupiter.api.Test;

public class TestController {
    AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", "2019091867568437", "XfCqmdNlT5dnqEaxhhhNkA==", "json", "UTF-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAobOYSBZ9vqyr2coYA+uUZDLoKakNr3RgcJWStmqtTV/5YmLf0sH4pvAxBLcYevlJ5Q+aYIe1I5GQPqH5jZtAFsU6dF7wk0SVNureO9W6xUlzpXQrN/2iLGqvPMmNGFP0whVU6MiY/G0+WBE7jtq6E6Xb2S4DPJc+No0HqAs1T3HKx6cSAastWsm+eyc1D4F52S1gLrNYRmkGty8jTpnr/me/vcfutP0RFvQjO+8sAnftHwzMp1ZnuXbbiuPW0EWNLt7kL0rZRweGi1OIMk3Krfy/Ksuweb7XHhCl1tA0hV+eYPA0yl0bPSKtqlr/VhDG9FNKkWhorMCBKdbK9EATRwIDAQAB", "RSA2");

    public void test() throws AlipayApiException {

        System.out.println("结果：" + alipayClient);

        AlipayMarketingCardTemplateCreateRequest request = new AlipayMarketingCardTemplateCreateRequest();
        request.setBizContent("{" +
                "\"request_id\":\"2019092700000000000000001\"," +
                "\"card_type\":\"OUT_MEMBER_CARD\"," +
                "\"biz_no_prefix\":\"KZLJPHYK\"," +
                "\"biz_no_suffix_len\":\"10\"," +
                "\"write_off_type\":\"qrcode\"," +
                "\"template_style_info\":{" +
                "\"card_show_name\":\"客自来精品会员卡\"," +
                "\"logo_id\":\"1T8Pp00AT7eo9NoAJkMR3AAAACMAAQEC\"," +
                "\"color\":\"rgb(55,112,179)\"," +
                "\"background_id\":\"1T8Pp00AT7eo9NoAJkMR3AAAACMAAQEC\"," +
                "\"bg_color\":\"rgb(55,112,179)\"," +
                "\"front_text_list_enable\":false," +
                "\"front_image_enable\":false," +
                "        \"feature_descriptions\":[" +
                "          \"使用花呗卡可享受免费分期\"" +
                "        ]," +
                "\"slogan\":\"会员权益享不停\"," +
                "\"slogan_img_id\":\"1T8Pp00AT7eo9NoAJkMR3AAAACMAAQEC\"," +
                "\"brand_name\":\"可乐\"," +
                "\"banner_img_id\":\"1T8Pp00AT7eo9NoAJkMR3AAAACMAAQEC\"," +
                "\"banner_url\":\"http://www.baidu.com\"," +
                "\"column_info_layout\":\"list\"" +
                "    }," +
                "      \"template_benefit_info\":[{" +
                "        \"title\":\"消费即折扣\"," +
                "          \"benefit_desc\":[" +
                "            \"消费即折扣\"" +
                "          ]," +
                "\"start_date\":\"2016-07-18 15:17:23\"," +
                "\"end_date\":\"2016-07-34 12:12:12\"" +
                "        }]," +
                "      \"column_info_list\":[{" +
                "        \"code\":\"BENEFIT_INFO\"," +
                "\"operate_type\":\"openWeb\"," +
                "\"title\":\"会员专享\"," +
                "\"value\":\"80\"," +
                "\"more_info\":{" +
                "\"title\":\"会员专享权益\"," +
                "\"url\":\"http://www.baidu.com\"," +
                "\"params\":\"{}\"," +
                "            \"descs\":[" +
                "              \"会员生日7折\"" +
                "            ]" +
                "        }," +
                "\"icon_id\":\"1T8Pp00AT7eo9NoAJkMR3AAAACMAAQEC\"," +
                "\"tag\":\"热门\"," +
                "\"group_title\":\"校园助手\"" +
                "        }]," +
                "      \"field_rule_list\":[{" +
                "        \"field_name\":\"Balance\"," +
                "\"rule_name\":\"ASSIGN_FROM_REQUEST\"," +
                "\"rule_value\":\"Balance\"" +
                "        }]," +
                "      \"card_action_list\":[{" +
                "        \"code\":\"TO_CLOCK_IN\"," +
                "\"text\":\"打卡\"," +
                "\"url_type\":\"url\"," +
                "\"url\":\"https://merchant.ali.com/ee/clock_in.do\"," +
                "\"mini_app_url\":{" +
                "\"mini_app_id\":\"2018xxxxxxx\"," +
                "\"mini_page_param\":\"xxxxxxxx\"," +
                "\"mini_query_param\":\"abcxxxxxx\"," +
                "\"display_on_list\":\"false\"" +
                "        }" +
                "        }]," +
                "\"open_card_conf\":{" +
                "\"open_card_source_type\":\"ISV\"," +
                "\"source_app_id\":\"201609191111111\"," +
                "\"open_card_url\":\"https://www.alipay.com\"," +
                "\"conf\":\"\\\"\\\"\"," +
                "        \"card_rights\":[{" +
                "          \"title\":\"积分兑换好礼\"," +
                "\"detail\":\"积分随时查，积分换好礼\"" +
                "          }]" +
                "    }," +
                "      \"shop_ids\":[" +
                "        \"2015122900077000000002409504\"" +
                "      ]," +
                "      \"pub_channels\":[{" +
                "        \"pub_channel\":\"SHOP_DETAIL\"," +
                "\"ext_info\":\"\\\"key\\\":\\\"value\\\"\"" +
                "        }]," +
                "      \"card_level_conf\":[{" +
                "        \"level\":\"VIP1\"," +
                "\"level_show_name\":\"黄金会员\"," +
                "\"level_icon\":\"1T8Pp00AT7eo9NoAJkMR3AAAACMAAQEC\"," +
                "\"level_desc\":\"黄金会员享受免费停车\"" +
                "        }]," +
                "\"mdcode_notify_conf\":{" +
                "\"url\":\"https://www.ali123.com/ant/mdcode\"," +
                "\"ext_params\":\"{\\\"param1\\\":\\\"value1\\\",\\\"param2\\\":\\\"value2\\\"}\"" +
                "    }," +
                "\"card_spec_tag\":\"NONE\"" +
                "  }");
        AlipayMarketingCardTemplateCreateResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }


    }

    @Test
    public void UploadImage() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", "2019091867568437", "XfCqmdNlT5dnqEaxhhhNkA==", "json", "UTF-8", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAobOYSBZ9vqyr2coYA+uUZDLoKakNr3RgcJWStmqtTV/5YmLf0sH4pvAxBLcYevlJ5Q+aYIe1I5GQPqH5jZtAFsU6dF7wk0SVNureO9W6xUlzpXQrN/2iLGqvPMmNGFP0whVU6MiY/G0+WBE7jtq6E6Xb2S4DPJc+No0HqAs1T3HKx6cSAastWsm+eyc1D4F52S1gLrNYRmkGty8jTpnr/me/vcfutP0RFvQjO+8sAnftHwzMp1ZnuXbbiuPW0EWNLt7kL0rZRweGi1OIMk3Krfy/Ksuweb7XHhCl1tA0hV+eYPA0yl0bPSKtqlr/VhDG9FNKkWhorMCBKdbK9EATRwIDAQAB", "RSA2");
        AlipayOfflineMaterialImageUploadRequest request = new AlipayOfflineMaterialImageUploadRequest();
        request.setImageType("jpg或mp4");
        request.setImageName("客自来精品会员logo");
        FileItem ImageContent = new FileItem("C:\\Users\\PRQ\\Desktop\\logo.jpg");
        request.setImageContent(ImageContent);
        request.setImagePid("20190927120000");
        AlipayOfflineMaterialImageUploadResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}
