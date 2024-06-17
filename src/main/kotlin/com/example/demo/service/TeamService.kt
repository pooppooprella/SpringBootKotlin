package com.example.demo.service

import com.example.demo.dto.TeamDto

interface TeamService {
    fun selectTeamList(): List<TeamDto>
}