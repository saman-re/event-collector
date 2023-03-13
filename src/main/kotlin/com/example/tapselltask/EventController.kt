package com.example.tapselltask

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping(path = ["/api/v1"])
class EventController(
    @Autowired
    private val eventService: EventService
) {

    @GetMapping
    fun checkHealth(
        @RequestParam(name = "publisherId", required = false) advertiserId: Optional<String>,
        @RequestParam(name = "publisherId", required = false) publisherId: Optional<String>
    ): String {
        return "salam $advertiserId $publisherId"
    }
}