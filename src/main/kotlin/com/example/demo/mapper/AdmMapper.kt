package com.example.demo.mapper

import com.example.demo.dto.TmAdmDto
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

@Repository
@Mapper
interface AdmMapper {
    fun selectTmAdm(): List<TmAdmDto>
}