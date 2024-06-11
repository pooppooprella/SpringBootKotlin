package com.example.demo.dto

import lombok.Data

@Data
data class SessionData (
    /** 관리자 번호  */
    val adminNo: String?,

    /** 관리자 아이디  */
    val adminId: String?,

    /** 관리자 권한  */
    val adminAuthNo: String?,

    /** 관리자 권한  */
    val adminAuthNm: String?,

    /** 첫 로그인  */
    val firstLogin: Boolean,

    /** 90일 비밀번호 미변경  */
    val isBeforeLimitDays: Boolean,

    /** 로그인실패  */
    val loginFail: Boolean,

    /** 로그인실패메시지  */
    val loginFailMsg: String?,
)