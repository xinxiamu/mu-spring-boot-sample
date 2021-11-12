package co.jufeng.esign.mappers;

import co.jufeng.esign.api.vo.req.VDoSignReq;
import co.jufeng.esign.api.vo.resp.VFileKeyWordsPositionResp;
import co.jufeng.esign.common.paasapi.vo.VCreateFlowOneStepReq;
import co.jufeng.esign.common.paasapi.vo.VWordsPosition;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ESignMapper {

    ESignMapper INSTANCE = Mappers.getMapper( ESignMapper.class );

    VCreateFlowOneStepReq vDoSignReqTo(VDoSignReq vDoSignReq);

    List<VFileKeyWordsPositionResp> toVFileKeyWordsPositionRespList(List<VWordsPosition.DataDTO> data);
}
