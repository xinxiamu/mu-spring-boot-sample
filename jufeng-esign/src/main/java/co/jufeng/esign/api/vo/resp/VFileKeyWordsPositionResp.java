package co.jufeng.esign.api.vo.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class VFileKeyWordsPositionResp implements Serializable {
    private static final long serialVersionUID = 2072579531024202619L;


    /**
     * keyword : 方法
     * fileId : b4f3d89420ec438ab83e8a02cabf1342
     * positionList : [{"pageIndex":1,"coordinateList":[{"posx":315.43,"posy":185.65723}]}]
     */

    @JsonProperty("keyword")
    private String keyword;
    @JsonProperty("fileId")
    private String fileId;
    @JsonProperty("positionList")
    private List<PositionListDTO> positionList;

    @NoArgsConstructor
    @Data
    public static class PositionListDTO {
        /**
         * pageIndex : 1
         * coordinateList : [{"posx":315.43,"posy":185.65723}]
         */

        @JsonProperty("pageIndex")
        private Integer pageIndex;
        @JsonProperty("coordinateList")
        private List<CoordinateListDTO> coordinateList;

        @NoArgsConstructor
        @Data
        public static class CoordinateListDTO {
            /**
             * posx : 315.43
             * posy : 185.65723
             */

            @JsonProperty("posx")
            private Double posx;
            @JsonProperty("posy")
            private Double posy;
        }
    }
}
