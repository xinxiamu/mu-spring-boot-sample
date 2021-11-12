package co.jufeng.esign.api.vo.resp;

import java.io.Serializable;

public class ESignPdfFileInfoResp implements Serializable {
    private static final long serialVersionUID = 2103777169416626668L;

    /**
     * 文件名称。
     */
    private String name;
    /**
     * pdf文件下载地址。
     */
    private String downloadUrl;
    /**
     * pdf文件总页数。
     */
    private Integer pdfTotalPages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Integer getPdfTotalPages() {
        return pdfTotalPages;
    }

    public void setPdfTotalPages(Integer pdfTotalPages) {
        this.pdfTotalPages = pdfTotalPages;
    }
}
