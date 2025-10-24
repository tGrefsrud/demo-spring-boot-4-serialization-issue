package com.example.demo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DraftServiceTest {

    @Autowired
    private lateinit var draftService: DraftService

    @Test
    fun `should fetch draft by id and verify Hello World message`() {
        // Given: A draft with id 1 should exist from the Flyway migration
        val draftId = 1L

        // When: Fetching the draft by id
        val draft = draftService.findById(draftId)
        // Then: The draft should exist and contain the expected JSON message
        assertNotNull(draft, "Draft should not be null")
        assertNotNull(draft!!.data, "Draft data should not be null")

        // Verify the JSON structure and message
        assertTrue(draft.data.has("message"), "JSON should have 'message' field")
        assertEquals("Hello World", draft.data.get("message").asText(),
            "Message should be 'Hello World'")
    }
}

