package co.jufeng.esign.api.vo.resp;

import java.io.Serializable;

public class VDoSignResp implements Serializable {
    private static final long serialVersionUID = 197927762796737973L;

    private String flowId;

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }
}
