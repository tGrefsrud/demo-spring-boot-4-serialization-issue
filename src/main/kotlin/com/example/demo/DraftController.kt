package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/drafts")
class DraftController(
    private val draftService: DraftService
) {

    private val logger = LoggerFactory.getLogger(DraftController::class.java)

    @GetMapping("/{id}")
    fun getDraftById(@PathVariable id: Long): ResponseEntity<Draft> {
        val draft = draftService.findById(id)
        return if (draft != null) {
            logger.info("Draft data: {}", draft.data)
            ResponseEntity.ok(draft)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}

