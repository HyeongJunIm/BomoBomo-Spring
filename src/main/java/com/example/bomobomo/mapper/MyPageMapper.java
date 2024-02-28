package com.example.bomobomo.mapper;

import com.example.bomobomo.domain.dto.AddressDto;
import com.example.bomobomo.domain.dto.EstContentDto;
import com.example.bomobomo.domain.dto.MatchDto;
import com.example.bomobomo.domain.dto.UserDto;
import com.example.bomobomo.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MyPageMapper {

    /**시터 결제 내역 조회
     * 쿼리에 2가지이 변수를 넘겨줘서 조회
     * @param criteria
     * @param userNumber
     * @return
     */
    public List<MyPageSitterVo> selectSitterList(@Param("criteria")Criteria criteria,@Param("userNumber")Long userNumber);

    /**결제한 시터의 전체 내용 조회
     *
     * @param matchNumber
     * @return
     */
    public  List<EstContentDto> selectEst(Long matchNumber);

    /**
     * 페이징 처리를 위한  결재 내역 총 갯수 조회
     * @param userNumber
     * @return
     */
    public int selectTotal(Long userNumber);

    /**
     * 이벤트 결재 내역과 페이징 처리
     * @param criteria 이벤트 내역 페이징처리를 위한 변수
     * @param userNumber 해당 사용자의 건수 조회
     * @return
     */
    public List<MyPageEventVo> selectEventList(@Param("criteria")Criteria criteria,@Param("userNumber")Long userNumber);

    /**
     * 이벤트 결재내역 페이징을 위한 전체 건수 조회
     * @param userNumber
     * @return
     */
    public int selectEventTotal(Long userNumber);

    /**
     * 사용자의 시터 매칭 상태 조회
     * @param userNumber
     * @return
     */
    public MatchDto selectMatch(Long userNumber);

    /**
     * 사용자와 매칭된 직원 정보 조회
     * @param empNumber
     * @return
     */
    public MatchEmpInfoVo selectEmpInfoImg(Long empNumber);

    /**
     * 매칭된 직원의 활동영역 이미지와 활동명 전체 리스트 조회
     * @param empNumber
     * @return
     */
    public List<EmpActItemImgVo> selectEmpActItemImg(Long empNumber);

    /**
     * 매칭직원의 평점 조회
     * @param empNumber
     * @return
     */
    public double selectMatchEmpRating(Long empNumber);


    /**
     * 결제시 사용자의 정보를 조회
     * @param userNumber
     * @return
     */
    public MatchUserInfoVo selectMatchUserInfo(Long userNumber);

    /**
     * 사용자의 결제 견적서 조회
     * @param userNumber
     * @return
     */
    public List<MatchBuyInfoVo> selectMatchBuyInfo(Long userNumber);

    /**
     * 결제 후 사용자의 매칭 상태 수정
     * @param matchNumber
     */
    public void update(Long matchNumber);


    /**
     * 회원정보 수정
     * @param userNumber
     * @return
     */
    public UserDto selectUser(Long userNumber);

    /**
     * 회원 주소 정보 조회
     * @param userNumber
     * @return
     */
    public AddressDto selectUserAddress(Long userNumber);

    /**
     * 회원 정보 삭제
     * @param userNumber
     */
    public void deleteUser(Long userNumber);


}
