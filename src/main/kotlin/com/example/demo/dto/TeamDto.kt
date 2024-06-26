package com.example.demo.dto

import lombok.Data

/** 관리자계정기본 */
@Data
data class TeamDto(
    private var admSeq: Int,
    private val authCd: String,
    private val id: String,
    private val pw: String,
    private val pwErrCnt: Int,
    private val name: String,
    private val empNo: String,
    private val email: String,
    private val useYn: String,
    private val delYn: String,
    private val regAdmSeq: String,
    private val regDt: String,
    private val uptAdmSeq: String,
    private val uptDt: String,
)
    
