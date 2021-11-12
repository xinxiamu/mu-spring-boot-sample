package co.jufeng.esign.common.paasapi.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class VUploadFile implements Serializable {

    private static final long serialVersionUID = 8848933568294011960L;
    /**
     * code : 0
     * data : {"uploadUrl":"http://esignoss.esign.cn/1111564182/bcc7b1d0-6a2b-45bc-a6b0-68097a99ce08/%E8%8A%9C%E6%B5%A3%E4%B8%8A%E4%BC%A0%E6%96%87%E4%BB%B61?Expires=1570674805&OSSAccessKeyId=STS.NJUf5d3CTSM8Koy6MB3ZrftFK&Signature=xB%2B62bPNlPhE3ZDP8lZ4TbBYk0I%3D&callback-var=eyJ4OmZpbGVfa2V5IjoiJDZkM2E1NWIxLWM2Y2YtNDAyNi04NDI5LTViMDBiNWIxY2JlZSQyMTY3NzAwNjM0In0%3D%0A&callback=eyJjYWxsYmFja1VybCI6Imh0dHA6Ly80Ny45OS4yMjQuMjM1OjgwODAvZmlsZS1zeXN0ZW0vY2FsbGJhY2svYWxpb3NzIiwiY2FsbGJhY2tCb2R5IjogIntcIm1pbWVUeXBlXCI6JHttaW1lVHlwZX0sXCJzaXplXCI6ICR7c2l6ZX0sXCJidWNrZXRcIjogJHtidWNrZXR9LFwib2JqZWN0XCI6ICR7b2JqZWN0fSxcImV0YWdcIjogJHtldGFnfSxcImZpbGVfa2V5XCI6JHt4OmZpbGVfa2V5fX0iLCJjYWxsYmFja0JvZHlUeXBlIjogImFwcGxpY2F0aW9uL2pzb24ifQ%3D%3D%0A&security-token=CAIS%2BAF1q6Ft5B2yfSjIr4ngLY/Q3px15I/TSUnI0k0XP9VeibHtqTz2IHtKdXRvBu8Xs/4wnmxX7f4YlqB6T55OSAmcNZEod3TTArDkMeT7oMWQweEurv/MQBqyaXPS2MvVfJ%2BOLrf0ceusbFbpjzJ6xaCAGxypQ12iN%2B/m6/Ngdc9FHHPPD1x8CcxROxFppeIDKHLVLozNCBPxhXfKB0ca0WgVy0EHsPnvm5DNs0uH1AKjkbRM9r6ceMb0M5NeW75kSMqw0eBMca7M7TVd8RAi9t0t1/IVpGiY4YDAWQYLv0rda7DOltFiMkpla7MmXqlft%2BhzcgeQY0pc/RqAAa5BvYa8R6jX7v50o5iWdTJceZ0qwFqoAqO6uWZSPyqJHem/FntqEkDjdVHbDlGxhLECwZhV03g2YYUPV8MUyukXQa3H3Ixai3Dx84NaTff63mHyJvpmMTUYiARXOpf8U5CCmifHTOWcW6uEdV8o3QIjKLSwb%2Bfd0vR%2B3X37LMPb","fileId":"c64665aa4f1c45679e65b6fae33cd773"}
     * message : 成功
     */

    @JSONField(name = "code")
    private Integer code;
    @JSONField(name = "data")
    private DataDTO data;
    @JSONField(name = "message")
    private String message;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        /**
         * uploadUrl : http://esignoss.esign.cn/1111564182/bcc7b1d0-6a2b-45bc-a6b0-68097a99ce08/%E8%8A%9C%E6%B5%A3%E4%B8%8A%E4%BC%A0%E6%96%87%E4%BB%B61?Expires=1570674805&OSSAccessKeyId=STS.NJUf5d3CTSM8Koy6MB3ZrftFK&Signature=xB%2B62bPNlPhE3ZDP8lZ4TbBYk0I%3D&callback-var=eyJ4OmZpbGVfa2V5IjoiJDZkM2E1NWIxLWM2Y2YtNDAyNi04NDI5LTViMDBiNWIxY2JlZSQyMTY3NzAwNjM0In0%3D%0A&callback=eyJjYWxsYmFja1VybCI6Imh0dHA6Ly80Ny45OS4yMjQuMjM1OjgwODAvZmlsZS1zeXN0ZW0vY2FsbGJhY2svYWxpb3NzIiwiY2FsbGJhY2tCb2R5IjogIntcIm1pbWVUeXBlXCI6JHttaW1lVHlwZX0sXCJzaXplXCI6ICR7c2l6ZX0sXCJidWNrZXRcIjogJHtidWNrZXR9LFwib2JqZWN0XCI6ICR7b2JqZWN0fSxcImV0YWdcIjogJHtldGFnfSxcImZpbGVfa2V5XCI6JHt4OmZpbGVfa2V5fX0iLCJjYWxsYmFja0JvZHlUeXBlIjogImFwcGxpY2F0aW9uL2pzb24ifQ%3D%3D%0A&security-token=CAIS%2BAF1q6Ft5B2yfSjIr4ngLY/Q3px15I/TSUnI0k0XP9VeibHtqTz2IHtKdXRvBu8Xs/4wnmxX7f4YlqB6T55OSAmcNZEod3TTArDkMeT7oMWQweEurv/MQBqyaXPS2MvVfJ%2BOLrf0ceusbFbpjzJ6xaCAGxypQ12iN%2B/m6/Ngdc9FHHPPD1x8CcxROxFppeIDKHLVLozNCBPxhXfKB0ca0WgVy0EHsPnvm5DNs0uH1AKjkbRM9r6ceMb0M5NeW75kSMqw0eBMca7M7TVd8RAi9t0t1/IVpGiY4YDAWQYLv0rda7DOltFiMkpla7MmXqlft%2BhzcgeQY0pc/RqAAa5BvYa8R6jX7v50o5iWdTJceZ0qwFqoAqO6uWZSPyqJHem/FntqEkDjdVHbDlGxhLECwZhV03g2YYUPV8MUyukXQa3H3Ixai3Dx84NaTff63mHyJvpmMTUYiARXOpf8U5CCmifHTOWcW6uEdV8o3QIjKLSwb%2Bfd0vR%2B3X37LMPb
         * fileId : c64665aa4f1c45679e65b6fae33cd773
         */

        @JSONField(name = "uploadUrl")
        private String uploadUrl;
        @JSONField(name = "fileId")
        private String fileId;
    }
}
