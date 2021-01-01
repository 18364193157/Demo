package com.test.regex;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author langyonghe
 * @date 2020/10/27 17:12
 */
@Slf4j
public class TestRegex {

    private static List<Pattern> patterns = null;
    public static void main(String[] args) {
        Object[] objects = {"(window\\.location|window\\.|\\.location|document\\.cookie|document\\.|alert\\(.*?\\)|window\\.open\\()*"
                , Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL};
        String str = "3e7d338ebd0b43f790d9a618da1c25c9\"onmouseover=`[window[\"location\"]=\"\\x6a\\x61\\x76\\x61\\x73\\x63\\x72\\x69\\x70\\x74\\x3a\\x61\\x6c\\x65\\x72\\x74\\x28164\\x29\"]`\n + alert(101)";
//        String alert = "+alert(101)";
        Pattern localPattern = Pattern.compile("(window\\.location|window\\.|\\.location|document\\.cookie|document\\.|alert\\(.*?\\)|window\\.open\\()*", 2);
        localPattern = Pattern.compile("(window\\.location|document\\.cookie|document\\.|alert\\(.*?\\)|window\\.open\\(.*?\\)|\\[window\\]\\[location\\]|window\\.|\\.location|window\\[\"location\"\\]|<iframe.*?>|<iframe.*|<IMG.*?>)", 42);

        str = localPattern.matcher(str).replaceAll("");
        System.out.printf(str);
//        String star = "3e7d338ebd0b43f790d9a618da1c25c9\"onmouseover=`[window[\"location\"]=\"\\x6a\\x61\\x76\\x61\\x73\\x63\\x72\\x69\\x70\\x74\\x3a\\x61\\x6c\\x65\\x72\\x74\\x28164\\x29\"]`";

//        String star = "3'\"><iframe id=3767 src=http://demo.testfire.net/phishing.html>'";
//        String alert = "+alert(101)";
//        String s1 = HtmlUtils.htmlEscape(alert);
//        System.out.print(s1+"\n");
//        System.out.println("===========================");
//        String s = StringEscapeUtils.escapeHtml(alert);
//        System.out.println(s);

//        String s = stripXss(str);
//        System.out.printf(s);


    }

    private static List<Object[]> getXssPatternList() {

        List<Object[]> ret = new ArrayList<Object[]>();
        ret.add(new Object[]{"(window\\.location|window\\.|\\.location|document\\.cookie|document\\.|alert\\(.*?\\)|window\\.open\\()*", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"<+\\s*\\w*\\s*(oncontrolselect|oncopy|oncut|ondataavailable|ondatasetchanged|ondatasetcomplete|ondblclick|ondeactivate|ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop|onerror=|onerroupdate|onfilterchange|onfinish|onfocus|onfocusin|onfocusout|onhelp|onkeydown|onkeypress|onkeyup|onlayoutcomplete|onload|onlosecapture|onmousedown|onmouseenter|onmouseleave|onmousemove|onmousout|onmouseover|onmouseup|onmousewheel|onmove|onmoveend|onmovestart|onabort|onactivate|onafterprint|onafterupdate|onbefore|onbeforeactivate|onbeforecopy|onbeforecut|onbeforedeactivate|onbeforeeditocus|onbeforepaste|onbeforeprint|onbeforeunload|onbeforeupdate|onblur|onbounce|oncellchange|onchange|onclick|oncontextmenu|onpaste|onpropertychange|onreadystatechange|onreset|onresize|onresizend|onresizestart|onrowenter|onrowexit|onrowsdelete|onrowsinserted|onscroll|onselect|onselectionchange|onselectstart|onstart|onstop|onsubmit|onunload)+\\s*=+", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        return ret;
    }
    public static String stripXss(String value) {

        if (StringUtils.isNotBlank(value)) {

            log.info("【XSS攻击防御】，接收字符是：{}", value);

            //
            Matcher matcher = null;

            for (Pattern pattern : getPatterns()) {
                matcher = pattern.matcher(value);
                // 匹配
                if (matcher.find()) {
                    // 删除相关字符串
                    value = matcher.replaceAll("");
                }
            }

            log.info("【XSS攻击防御】，匹配正则是：{}，处理后是：{}", matcher, value);


        }


        return value;
    }

    private static List<Pattern> getPatterns() {


        if (patterns == null) {

            List<Pattern> list = new ArrayList<Pattern>();

            String regex = null;
            Integer flag = null;
            int arrLength = 0;

            for (Object[] arr : getXssPatternList()) {
                arrLength = arr.length;
                for (int i = 0; i < arrLength; i++) {
                    regex = (String) arr[0];
                    flag = (Integer) arr[1];
                    list.add(Pattern.compile(regex, flag));
                }
            }

            patterns = list;
        }

        return patterns;
    }

}
