package com.manlop.tfg.TFG_backend.controller

import com.manlop.tfg.TFG_backend.model.Report
import com.manlop.tfg.TFG_backend.model.projections.SimpleReport
import com.manlop.tfg.TFG_backend.repository.ReportRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/reports")
class ReportsController {
    @Autowired
    lateinit var reportRepository: ReportRepository

    @CrossOrigin(origins = ["http://localhost:8084", "*"])
    @PostMapping
    fun createReport(@RequestBody report: Report): ResponseEntity<Report> {
        val savedReport = reportRepository.save(report)
        return ResponseEntity.ok(savedReport)
    }

    @CrossOrigin(origins = ["http://localhost:8084", "*"])
    @GetMapping("/simple")
    fun getAllSimpleReports(): ResponseEntity<List<SimpleReport>> {
        val reports = reportRepository.findAllSimple()
        return ResponseEntity.ok(reports)
    }

    @CrossOrigin(origins = ["http://localhost:8084", "*"])
    @GetMapping()
    fun getAllReports(): ResponseEntity<List<Report>> {
        val reports = reportRepository.findAll().toList()
        return ResponseEntity.ok(reports)
    }

    @CrossOrigin(origins = ["http://localhost:8084", "*"])
    @GetMapping("/{tokenId}")
    fun getReportByTokenId(@PathVariable tokenId: String): ResponseEntity<Report> {
        val report = reportRepository.findByTokenId(tokenId)
        return if (report.isPresent) {
            ResponseEntity.ok(report.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }
}