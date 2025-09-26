package com.manlop.tfg.TFG_backend.repository

import com.manlop.tfg.TFG_backend.model.Report
import com.manlop.tfg.TFG_backend.model.projections.SimpleReport
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ReportRepository : CrudRepository<Report, Long> {
    @Query("SELECT new com.manlop.tfg.TFG_backend.model.projections.SimpleReport(r.tokenId, r.location) FROM Report r")
    fun findAllSimple(): List<SimpleReport>
    fun findByTokenId(tokenId: String): Optional<Report>
}
