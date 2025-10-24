package com.example.demo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class DraftService(
    private val draftRepository: DraftRepository
) {
    fun findById(id: Long): Draft? {
        return draftRepository.findById(id).orElse(null)
    }
}


