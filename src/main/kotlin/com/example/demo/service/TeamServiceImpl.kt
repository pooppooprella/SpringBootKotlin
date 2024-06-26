package com.example.demo.service

import com.example.demo.dto.TeamDto
import com.example.demo.mapper.TeamMapper
import org.springframework.stereotype.Service

@Service
class TeamServiceImpl (
    private val teamMapper: TeamMapper
) : TeamService{

    override fun selectTeamList(): List<TeamDto> {
        return teamMapper.selectTeamList()
    }
}