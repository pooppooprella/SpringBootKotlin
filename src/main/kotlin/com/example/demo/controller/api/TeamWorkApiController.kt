package com.example.demo.controller.api

import com.example.demo.dto.TeamDto
import com.example.demo.service.TeamService
import groovy.util.logging.Slf4j
import io.swagger.v3.oas.annotations.Operation
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.DeleteMapping
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
     * @param teamDto : TeamDto 검색 dto 변경예정.
     * @return String
     */
    @PostMapping("/team")
    @Operation(summary = "팀 목록 조회 ", description = "[파라미터설명필요]")
    fun postReqboard(@RequestBody teamDto: TeamDto): Long {
        println("teamDto : ${teamDto}")
        println("selectTeamList :  ${teamService.selectTeamList()}")
        return 1
    }

    /**
     * INSERT
     * @param name String
     * @return String
     */
    @PutMapping("/team")
    @Operation(summary = "팀 등록", description = "[createdBy=생성자]")
    fun insertBoard(@RequestBody teamDto: TeamDto): Long {
        println("tags ${teamDto}")
        return 1
    }

    /**
     * DELETE
     * @param name String
     * @return String
     */
    @DeleteMapping("/team")
    @Operation(summary = "팀 삭제", description = "[id=삭제요청자]")
    fun deleteBoard(@RequestBody teamDto: TeamDto): Long {
        println("tags ${teamDto}")
        return 1
    }


}