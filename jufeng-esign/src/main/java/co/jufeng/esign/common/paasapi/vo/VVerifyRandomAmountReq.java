package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class VVerifyRandomAmountReq {

    /**
     * amount : 0.51
     */

    @JSONField(name = "amount")
    private Double amount;
}
