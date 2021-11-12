package co.jufeng.esign.api.vo.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VVerifyPersonalResp implements Serializable {

    /**
     * 个人实名认证流水号
     */
    private String flowId;
    /**
     * 个人实名认证账号ID。该字段要保存在数据库。
     */
    private String accountId;
}
