package com.example.demo.service

import com.example.demo.dto.TmAdmDto

interface AdmService {
    fun selectTmAdm(): List<TmAdmDto>
}