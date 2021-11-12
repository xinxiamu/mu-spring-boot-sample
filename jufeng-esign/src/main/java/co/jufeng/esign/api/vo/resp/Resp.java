package co.jufeng.esign.api.vo.resp;

import java.io.Serializable;

public class Resp implements Serializable {

    /**
     * 错误码。0-成功，其它失败。
     */
    private int errCode;
    /**
     * 错误信息是否显示
     */
    private boolean errShow;
    /**
     * 错误信息
     */
    private String msg;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public boolean isErrShow() {
        return errShow;
    }

    public void setErrShow(boolean errShow) {
        this.errShow = errShow;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
