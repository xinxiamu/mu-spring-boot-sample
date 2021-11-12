package co.jufeng.esign.api.vo.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VGenSealsReq implements Serializable {

    private static final long serialVersionUID = 7555014584271642434L;

    /**
     * 个人或者企业账号id。
     */
    @NotBlank
    private String accountId;
    /**
     * 印章名称。
     */
    @NotBlank
    private String alias;
    /**
     * 1-创建个人印章模板；2-创建企业印章模板。
     */
    @NotNull(message = "1-创建个人印章模板；2-创建企业印章模板")
    private Integer type;
}
