package com.example.demo.controller.view

import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class TeamWorkViewController {

    @RequestMapping(value = ["/team"])
    fun teamWorkView(request: HttpServletRequest): ModelAndView {
        val mav = ModelAndView()
        mav.viewName = "teamwork/teamwork"
        return mav
    }
}