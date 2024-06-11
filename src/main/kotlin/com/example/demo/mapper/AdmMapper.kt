package com.example.demo.mapper

import com.example.demo.dto.TmAdmDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface AdmMapper {

    fun findAll(): List<TmAdmDto>
}