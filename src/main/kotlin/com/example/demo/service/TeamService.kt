package com.example.demo.service

import com.example.demo.dto.TeamDto

interface TeamService {
    fun selectTmAdm(): List<TeamDto>
}