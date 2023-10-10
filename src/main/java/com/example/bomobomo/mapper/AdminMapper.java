package com.example.bomobomo.mapper;

import com.example.bomobomo.domain.dto.*;
import com.example.bomobomo.domain.vo.*;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
//    관리자 로그인
    public AdminDto login(@Param("adminId")String adminId, @Param("adminPassword")String adminPassword);
//    주간 가입수
    public List<WeeklyRegisterVo> weeklyRegisterSelect();

//    유저 리스트
    public List<UserListVo> selectAllUsers(@Param("criteria") Criteria criteria, @Param("searchVo")SearchVo searchVo);
//    검색별 유저 수
    public int getTotalUsers(SearchVo searchVo);
//    회원 상세정보
    public UserDetailVo selectUserDetail(Long userNumber);

//    직원 리스트
    public List<EmpDto> selectAllEmp(@Param("criteria")Criteria criteria, @Param("searchVo")SearchVo searchVo);
//    검색별 직원 수
    public int getTotalEmp(SearchVo searchVo);
    public List<ActDto> selectAct();
//    직원 등록
    public void empRegist(EmpDto empDto);
//    직원 이미지 등록
    public void empImgRegist(EmpImgDto empImgDto);
//    직원 활동 등록
    public void empActRegist(EmpActItemDto empActItemDto);

//    공지사항 리스트
    public List<NoticeDto> selectAllNotice(@Param("criteria")Criteria criteria, @Param("searchVo")SearchVo searchVo);
//    검색별 공지 수
    public int getTotalNotice(SearchVo searchVo);
//    공지사항 상세정보
    public NoticeDto selectNoticeDetail(Long noticeNumber);
//    공지 등록
    public void noticeRegist(NoticeDto noticeDto);
//    공지 수정
    public void noticeUpdate(NoticeDto noticeDto);
//    공지 삭제
    public void noticeDelete(Long noticeNumber);

//    매칭 리스트
    public List<MatchListVo> selectAllMatchs(@Param("criteria")Criteria criteria, @Param("searchVo")SearchVo searchVo);
//    검색별 매칭수
    public int getTotalMatchs(SearchVo searchVo);

//    이벤트 리스트
    public List<EventVo> selectAllEvents(@Param("criteria")Criteria criteria, @Param("searchVo")SearchVo searchVo);
//    검색별 이벤트수
    public int getTotalEvents(SearchVo searchVo);
//    이벤트 조회
    public EventVo selectEventDetail(Long eventNumber);
//    이벤트 등록
    public void eventRegist(EventDto eventDto);
//    이벤트 이미지 등록
    public void eventImgRegist(EventImgDto eventImgDto);
//    이벤트 상세정보 등록
    public void eventDetailRegist(EventDetailDto eventDetailDto);
//    이벤트 삭제
    public void eventDelete(Long eventNumber);
//    이벤트 업데이트
    public void updateEvent(EventVo eventVo);
//    이벤트 이미지 업데이트
    public void updateEventImg(EventImgDto eventImgDto);
//    이벤트 상세정보 업데이트
    public void updateEventDetail(EventDetailDto eventDetailDto);
}
