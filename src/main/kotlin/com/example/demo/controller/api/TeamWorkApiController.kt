package com.example.demo.controller.api

import com.example.demo.dto.SessionData
import com.example.demo.dto.TmAdmDto
import com.example.demo.service.AdmService
import groovy.util.logging.Slf4j
import io.swagger.v3.oas.annotations.Operation
import jakarta.servlet.http.HttpServletRequest
import lombok.RequiredArgsConstructor
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
class TeamWorkApiController(private val admService: AdmService) {

    /**
     * INSERT
     * @param name String
     * @return String
     */
    @PutMapping("/posts")
    @Operation(summary = "게시글 등록", description = "[sampleRequest: title=제목, content=내용, createdBy=생성자]")
    fun insertBoard(@RequestParam createdBy: String): Long {
        println("tags ${createdBy}")
        return 1
    }

    /**
     * INSERT
     * @param name String
     * @return String
     */
    @PostMapping("/posts")
    @Operation(summary = "게시글 등록", description = "[sampleRequest: title=제목, content=내용, createdBy=생성자]")
    fun postRequboard(@RequestParam createdBy: String): Long {
        println("tags ${createdBy}")
        return 1
    }



}