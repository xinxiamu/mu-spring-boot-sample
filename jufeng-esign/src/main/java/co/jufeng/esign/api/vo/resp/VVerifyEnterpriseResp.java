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
public class VVerifyEnterpriseResp implements Serializable {

    private static final long serialVersionUID = 3119835812263921328L;


    /**
     * serviceId : 1111111111111111
     * beginTime : 2017-05-02
     * endTime : 长期
     */

    /**
     * 请求e签宝服务id，唯一。
     */
    private String serviceId;

    /**
     * 企业营业起始时间。
     */
    private String beginTime;

    /**
     * 企业营业结束时间。
     */
    private String endTime;
}
