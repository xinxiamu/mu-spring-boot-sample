package co.jufeng.esign.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public abstract class Base {

    @Value("${spring.application.name}")
    protected String appName;

    @Autowired
    protected MessageSource messageSource;

    @Autowired
    protected Environment env;

    /**
     * 获取国际化信息。
     * @param code 国际化配置文件的key
     * @return 返回jvm本地环境下，对应配置的key的值。
     */
    protected String getMsgI18nDefault(String code) {
        return messageSource.getMessage(code,null,null);
    }

    /**
     * 获取临时文件夹路径。
     * @return
     */
    protected String getAppTmpFileDir() {
        //win  C:\Users\xinxiamu\.xrlj\appname\
        String appTmpFileDir = FileUtils.getUserDirectoryPath().concat(File.separator).concat(".xrlj").concat(File.separator).concat(appName).concat(File.separator);
        return appTmpFileDir;
    }

    /**
     * 根据url发起http请求从文件系统拉取文件保存到临时文件夹并返回文件所在路径。
     * @param url 文件在文件系统中的位置。
     * @return 应用临时文件夹下该文件路径。
     */
    protected String getFileFromFileSystem(String url) {
        if (url == null) {
            return null;
        }
        String filePath = new StringBuffer()
                .append(getAppTmpFileDir())
                .append(StringUtil.getUUID())
                .append(".")
                .append(FilenameUtils.getExtension(url))
                .toString();

        InputStream i = HttpsUtils.create(url).get().getContentAsInputStream();
        try {
            FileUtils.copyInputStreamToFile(i, new File(filePath));
        } catch (IOException e) {
            log.error(">>>>>下载文件{}失败", url, e);
        }

        return filePath;
    }

    /**
     * 获取网络文件流。
     * @param url 文件网络路径
     * @return 文件流
     */
    protected InputStream getNetFileAsStream(String url) {
        if (url == null) {
            return null;
        }

        InputStream i = HttpsUtils.create(url).get().getContentAsInputStream();

        return i;
    }
}
