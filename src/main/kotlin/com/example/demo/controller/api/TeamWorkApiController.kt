package com.example.demo.controller.api

import com.example.demo.service.AdmService
import groovy.util.logging.Slf4j
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/adminApi")
class TeamWorkApiController(private val admService: AdmService) {



}