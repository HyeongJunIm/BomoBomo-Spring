package com.example.bomobomo.controller;


import com.example.bomobomo.domain.dto.*;
import com.example.bomobomo.domain.vo.*;
import com.example.bomobomo.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
public class MyPageController {
    private final OrderService orderService;
    private final AdressService adressService;
    private final UserService userService;
    private final SitterBoardService sitterBoardService;
    private final MyPageService myPageService;
    private final EventBoardService eventBoardService;


    /**
     * 마이 페이지 메인으로 이동
     * 값의 유무처리에 따라 예외를 발생시켜 보여지는 페이지 변경
     * @param req
     * @param model
     * @return
     */
    @GetMapping("/main")
    public String showMainPage(HttpServletRequest req, Model model){
        Long userNumber=(Long)req.getSession().getAttribute("userNumber");
            MatchDto findMatch=myPageService.findMatch(userNumber);
        try {
            model.addAttribute("match",findMatch);
            log.info("예외처리"+findMatch.toString());

        } catch (NullPointerException e) {
            return "mypage/myPageMain";
        }

        MatchEmpInfoVo matchEmpInfoVo =  myPageService.findEmpInfoImg(findMatch.getEmpNumber());
        model.addAttribute("empInfoImg",matchEmpInfoVo);
        log.info(matchEmpInfoVo.toString());

        List<EmpActItemImgVo> empActItemImgVos=myPageService.findEmpActItemImg(findMatch.getEmpNumber());
        model.addAttribute("empActItemImgList",empActItemImgVos);
        log.info(empActItemImgVos.toString());

        double rating = myPageService.findMatchEmpRating(findMatch.getEmpNumber());
        model.addAttribute("rating",rating);

        return "mypage/myPageMain";

    }

    /**
     * OrderDto 값의 따라서 페이지 진입시 예외를 발생시켜 동기통신으로 페이지 이동
     * @param req
     * @param model
     * @return
     */
    @GetMapping("/application")
    public String showapplicationPage(HttpServletRequest req,Model model){
        Long userNumber=(Long)req.getSession().getAttribute("userNumber");
        System.out.println(userNumber);

        try {
            OrderDto orderDto=orderService.findOrder(userNumber);
            System.out.println(orderDto.toString());
            model.addAttribute("order",orderDto);
        } catch (NullPointerException e) {
            return "mypage/applicationPage";
        }


        return "mypage/updateApplicationPage";
    }

    //신청서 데이터 저장후 이동
    @PostMapping("/application")
    public RedirectView applicationRegister(OrderDto orderDto,HttpServletRequest req){

        // 저장 서비스 실행
        Long userNumber=(Long)req.getSession().getAttribute("userNumber");
        System.out.println(userNumber);
        orderDto.setUserNumber(userNumber);
        orderService.register(orderDto);


        log.info(orderDto.getUserNumber().toString());
        // 신청서 내용 입력 후 이동
        return new RedirectView("/mypage/main");
    }

    @PostMapping("/updateApplication")
    public RedirectView updateApplication(OrderDto orderDto,HttpServletRequest req){
        Long userNumber =(Long)req.getSession().getAttribute("userNumber");
        log.info("=============================오더{}",orderDto);
        orderDto.setUserNumber(userNumber);
      orderService.orderUpdate(orderDto);
        log.info("=============================오더{}",orderDto);

        return new RedirectView("/mypage/main");
    }

    /**
     *  시터 결제내역 리스트 조회와 페이징 처리
     * @param model
     * @param req
     * @param criteria
     * @return
     */
    @GetMapping("/buy")
    public String showBuyPage(Model model, HttpServletRequest req, Criteria criteria){
        criteria.setAmount(5);
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        PageVo pageVo = new PageVo(myPageService.getTotal(userNumber), criteria);


        List<MyPageSitterVo> myPageSitterVos=myPageService.findSitterList(criteria, userNumber);

        model.addAttribute("buyList",myPageSitterVos);
        model.addAttribute("pageVo", pageVo);

        return "mypage/buyPage";
    }

    /**
     * 이벤트 결제 내역 리스트 조회 및 페이징 처리
     * @param model
     * @param req
     * @param criteria
     * @return
     */
    @GetMapping("/buyEvent")
    public String showBuyEventPage(Model model, HttpServletRequest req, Criteria criteria){
        criteria.setAmount(5);
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");


        PageVo pageVO=new PageVo(myPageService.findEventTotal(userNumber),criteria);
        model.addAttribute("eventList",myPageService.findEventList(criteria,userNumber));
        model.addAttribute("pageVO",pageVO);
        return "mypage/buyEventPage";
    }

    /**
     * 회원정보 수정 페이지 이동
     * @param req
     * @param model 이전 DB에 있는 저장 내용 조회
     * @return
     */
    @GetMapping("/userManage")
    public String showuserManagePage(HttpServletRequest req,Model model){
        Long userNumber=(Long)req.getSession().getAttribute("userNumber");

        myPageService.findUser(userNumber);
        model.addAttribute("user",myPageService.findUser(userNumber));
        myPageService.findUserAddress(userNumber);
        model.addAttribute("userAddress",myPageService.findUserAddress(userNumber));


        System.out.println(userNumber);


        return "mypage/userManageMentPage";
    }

    /**
     * 수정된 회원정보 update
     * @param userDto 수정된 유저정보
     * @param addressDto 수정된 유저 주소
     * @param req 현재 session에 있는 유저
     * @return
     */
    @PostMapping("/userManage")
    public RedirectView userManageModify(UserDto userDto, AddressDto addressDto,HttpServletRequest req){
        Long userNumber=(Long)req.getSession().getAttribute("userNumber");

        userDto.setUserNumber(userNumber);
        addressDto.setUserNumber(userNumber);

        System.out.println(userNumber);


        userService.modify(userDto);
        adressService.modify(addressDto);

        log.info(userDto.toString());
        log.info(addressDto.toString());


        return new RedirectView("/mypage/main");
    }

    /**
     * 회원 탈퇴
     * @param userNumber
     * @param req
     * @return
     */
    @GetMapping("/userInfoDelete")
    public String removeUserInfo(@RequestParam(name = "userNumber") Long userNumber,HttpServletRequest req){

        myPageService.removeUser(userNumber);
        req.getSession().invalidate();
        return "user/login";

    }


    @GetMapping("/reviewwrite")
    public String showreviewwritePage(HttpServletRequest req,
                                      @ModelAttribute("eventPayNumber") Long eventPayNumber,
                                      Model model){
        Long userNUmber =(Long)req.getSession().getAttribute("userNumber");
        System.out.println(eventPayNumber);
        model.addAttribute("eventNameNumber",eventBoardService.findEventTitle(eventPayNumber));


        return "mypage/reviewWrite";
    }

    @PostMapping("/reviewwrite")
    public RedirectView eventreviewwrite(EventBoardDto eventBoardDto, HttpServletRequest req,
                                         @RequestParam("eventBoardImg")MultipartFile file){
        Long userNumber=(Long) req.getSession().getAttribute("userNumber");
        eventBoardDto.setUserNumber(userNumber);
        eventBoardService.registerAndFileproc(eventBoardDto,file);

        return new RedirectView("/mypage/main");
    }


   // buy페이지에서 시터 리뷰로 이동하는 컨트롤러
    @GetMapping("/siterreview")
    public String showsiterreviewPage(HttpServletRequest req,
                                      @RequestParam(name="empName") String empName,
                                      @ModelAttribute("matchNumber") Long matchNumber,
                                      @ModelAttribute("empNumber") Long empNumber,
                                      Model model){
        model.addAttribute("empName",empName);
        return "myPage/siterReview";
    }
    //게시물 작성후 이동하는 컨트롤러
    @PostMapping("/siterreview")
    public RedirectView siterreviewWriter(SitterBoardDto sitterBoardDto, HttpServletRequest req){
        Long userNumber = (Long)req.getSession().getAttribute("userNumber");
        sitterBoardDto.setUserNumber(userNumber);
        sitterBoardService.register(sitterBoardDto);
        System.out.println("-------"+sitterBoardDto);
        return new RedirectView("/mypage/main");
    }

}

