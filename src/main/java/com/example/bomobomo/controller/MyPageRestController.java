package com.example.bomobomo.controller;

import com.example.bomobomo.domain.dto.MatchDto;
import com.example.bomobomo.domain.vo.*;
import com.example.bomobomo.service.EventBoardService;
import com.example.bomobomo.service.MyPageService;
import com.example.bomobomo.service.SitterBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/myPages")
@RequiredArgsConstructor
public class MyPageRestController {
    private final MyPageService myPageService;
    private final SitterBoardService sitterBoardService;
    private final EventBoardService eventBoardService;
//     파일경로 확인 , 시터 결제내역 이미지
    @Value("${file.empImg}")
    private String fileSitterBuyImg;

    @GetMapping("/img")
    public byte[] getPfpImg(String fileFullPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileSitterBuyImg, fileFullPath));
    }
// 이벤트 결제 내역 이미지
    @Value("${file.eventImg}")
    private String fileeventImg;

    @GetMapping("/eventimg")
    public byte[] getEventImg(String fileFullPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileeventImg, fileFullPath));
    }

    // 마이페이지 메인에서 데이터 정보 출력
    @Value("${file.empImg}")
    private String fileEmpImg;

    @GetMapping("/empimg")
    public byte[] getEmpImg(String fileFullPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileEmpImg, fileFullPath));
    }

    //마이페이지 메인헤서 활동 이미지 출력
    @Value("${actImg.dir}")
    private String fileEmpActImg;

    @GetMapping("/empActimg")
    public byte[] getEmpActImg(String fileFullPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileEmpActImg, fileFullPath));
    }
    // 마이페이지 시터 이용후기 사용자가 작성한 내용만 출력

    /**
     * 시터이용후기 메인페이지 비동기 처리
     * @param page
     * @param req
     * @param criteria
     * @return
     */
    @GetMapping("/sitterReviewList/{page}")
    public Map<String, Object> showEventReviewList(@PathVariable("page") int page,HttpServletRequest req, Criteria criteria){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        criteria.setPage(page);

        PageVo pageVo = new PageVo(sitterBoardService.findSitterReviewTotal(userNumber), criteria);
        //내가 작성한 시터리뷰 조회 쿼리
        List<SitterBoardVo> sitterBoardVoList = sitterBoardService.findAll(criteria,userNumber);

        Map<String, Object> map = new HashMap<>();
        map.put("pageVo", pageVo);
        map.put("list", sitterBoardVoList);
        return map;
    }

    /**
     * 내가 작성한 이벤트 후기 메인페이지 비동기 처리
     * @param pages
     * @param req
     * @param criteria
     * @return
     */
    @GetMapping("/eventReviewList/{pages}")
    public Map<String, Object> showSitterReviewList(@PathVariable("pages") int pages,HttpServletRequest req, Criteria criteria){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        criteria.setPage(pages);

        PageVo pageVO = new PageVo(eventBoardService.findEventReviewTotal(userNumber), criteria);
        List<EventBoardVo> eventBoardVoList = eventBoardService.findEventAll(criteria,userNumber);

        Map<String, Object> map = new HashMap<>();
        map.put("pageVO", pageVO);
        map.put("eventlist", eventBoardVoList);
        return map;
    }

    /**
     * 매칭 시터 결제페이지 이동시 결제 정보 조회
     * @param req
     * @return
     */
    @PostMapping("/purchase")
    public Map<String, Object> purchasePage(HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        System.out.println(userNumber);
        MatchUserInfoVo matchUserInfoVo=myPageService.findMatchUserInfo(userNumber);
        List<MatchBuyInfoVo> matchBuyInfoVo=myPageService.findMatchBuyInfo(userNumber);

        Map<String, Object> map =new HashMap<>();
        map.put("userInfo",matchUserInfoVo);
        map.put("buyInfo",matchBuyInfoVo);

        return map;
    }

    /**
     * 매칭 시터 결제 완료후 경제 상태 변경
     * @param matchNumber
     * @param matchDto 매칭대상의 정보 필드
     */
    @PatchMapping("/{matchNumber}")
    public void modify(@PathVariable("matchNumber") Long matchNumber,
                       @RequestBody MatchDto matchDto){
        //json형식으로 받을거야
        System.out.println(matchNumber);


        myPageService.statusUpdate(matchDto.getMatchNumber());


    }

}









