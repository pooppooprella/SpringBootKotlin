package com.example.demo.mapper

import com.example.demo.dto.TeamDto
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

@Repository
@Mapper
interface TeamMapper {
    fun selectTmAdm(): List<TeamDto>
}