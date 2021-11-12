package co.jufeng.esign.api.vo.resp;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VSignResp implements Serializable {

    private static final long serialVersionUID = 3984293772523630556L;

    /**
     * 文件存储id。
     */
    private long id;

    /**
     * 文件原始名称。
     */
    private String oriName;

    /**
     * 文件所在网络全路径。
     */
    private String url;

    /**
     * 本次签章服务id。有必要，本地保存该字段。
     */
    private String signServiceId;
}
