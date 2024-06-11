package com.example.demo.service

import com.example.demo.dto.TmAdmDto
import com.example.demo.mapper.AdmMapper
import org.springframework.stereotype.Service

@Service
class AdmServiceImpl (
    private val admMapper: AdmMapper
) : AdmService{

    override fun selectTmAdm(): List<TmAdmDto> {
        return admMapper.selectTmAdm()
    }
}