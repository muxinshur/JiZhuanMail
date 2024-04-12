package com.mail.domain.aggregate.order.entity.valueObject;

import com.mail.domain.shared.BaseValueObject;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* 收件人信息
* */
public class RecipientInformation implements BaseValueObject<RecipientInformation> {

    private static final String SIMPLE_MOBILE_PHONE_REGEX = "^1\\d{10}$";

    /*
    * 订单ID
    * */
    private final long orderId;

    /*
    * 收件人姓名
    * */
    private final String name;

    /*
    * 收件人手机号
    * */
    private final String phone;

    /*
    * 收件人地址
    * */
    private final String address;

    /*
    * 校验手机号格式是否正确
    * */
    public boolean isSimpleMobilePhone(String phone) {
        Pattern pattern = Pattern.compile(SIMPLE_MOBILE_PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /*
    * 构造方法
    * */
    public RecipientInformation(long orderId, String name, String phone, String address) {
        if (isSimpleMobilePhone(phone)) {
            this.orderId = orderId;
            this.name = name;
            this.phone = phone;
            this.address = address;
        }else {
            throw new IllegalArgumentException("手机号格式不正确");
        }
    }

    /*
     * Getter
     * */
    public long getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    /*
    * 值对象相等判断
    * */
    @Override
    public boolean sameValueAs(RecipientInformation other) {
        return other != null && new EqualsBuilder().
                append(orderId, other.getOrderId()).
                append(name, other.getName()).
                append(phone, other.getPhone()).
                append(address, other.getAddress()).
                isEquals();
    }
}
