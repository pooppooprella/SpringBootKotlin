package com.example.demo.controller.view

import com.example.demo.dto.SessionData
import com.example.demo.dto.TmAdmDto
import com.example.demo.service.AdmService
import groovy.util.logging.Slf4j
import jakarta.servlet.http.HttpServletRequest
import lombok.RequiredArgsConstructor
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/view")
class TeamWorkViewController(private val admService: AdmService) {

    @RequestMapping(value = ["/team"])
    fun teamWorkView(request: HttpServletRequest): ModelAndView {
        val mav = ModelAndView()
        mav.viewName = "teamwork/teamwork"
        return mav
    }

    //관리자 목록 검색
    @PostMapping("/account-system-search")
//    @Operation(summary = "댓글 생성", description = "[sampleId: 댓글 작성할 게시글 아이디], [body: 댓글내용,댓글수정자아이디]")
    fun accountSystemSearch(
        @RequestParam param: HashMap<String?, Any?>,
        @AuthenticationPrincipal sessionData: SessionData?
    ): ModelAndView {
        val result = HashMap<String, Any>()
        val mav = ModelAndView("admin/account-system :: #table-wrapper")
        if (sessionData != null && sessionData.adminId != null && !sessionData.adminId
                .isEmpty() && sessionData.adminId != null && !sessionData.adminId.isEmpty()
        ) {
            val sqlParam = HashMap<String, Any?>()
            sqlParam["id"] = param["id"] //아이디
            sqlParam["empNo"] = param["empNo"] //사번
            sqlParam["name"] = param["name"] //성명
            sqlParam["authCd"] = param["authCd"] //권한
            //            sqlParam.put("limit", param.get("limit"));//
            sqlParam["offset"] = param["offset"] //

//            val admList: List<HashMap<String, Any>> = adminService.selectTmAdmList(sqlParam) //관리자 목록
            val admList: List<TmAdmDto> = admService.selectTmAdm() //관리자 목록
            mav.addObject("result", admList)
        }

        return mav
    }
}