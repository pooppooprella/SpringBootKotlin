package com.example.demo.controller.api

import com.example.demo.dto.TeamDto
import com.example.demo.service.TeamService
import groovy.util.logging.Slf4j
import io.swagger.v3.oas.annotations.Operation
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
class TeamWorkApiController(private val teamService: TeamService) {

    /**
     * SELECT
     * @param name String
     * @return String
     */
    @PostMapping("/posts")
    @Operation(summary = "팀조회 ", description = "[createdBy=생성자]")
    fun postRequboard(@RequestBody teamDto: TeamDto): Long {
        println("tags ${teamDto}")
        println("tmadm ${teamService.selectTmAdm()}")
        return 1
    }

    /**
     * INSERT
     * @param name String
     * @return String
     */
    @PutMapping("/posts")
    @Operation(summary = "팀 등록", description = "[createdBy=생성자]")
    fun insertBoard(@RequestBody teamDto: TeamDto): Long {
        println("tags ${teamDto}")

        return 1
    }


}