package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class Telecom3FactorsReq implements Serializable {

    /**
     * mobileNo : 13543495275
     */

    @JSONField(name = "mobileNo")
    private String mobileNo;
}
