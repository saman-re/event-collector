package com.example.tapselltask.event

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
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
    fun eventsReport(
        @RequestParam(name = "advertiserId", required = false) advertiserId: Optional<String>,
        @RequestParam(name = "publisherId", required = false) publisherId: Optional<String>
    ): ResponseEntity<String> {
        if (advertiserId.isPresent and publisherId.isPresent) {

            return ResponseEntity.badRequest().body("specify only one of advertiser or publisher ID")

        } else if (advertiserId.isPresent) {

            val id:Int = Integer.parseInt(advertiserId.get())
            eventService.getAdvertiserEvents(id)
            return ResponseEntity.ok("wait for income of advertiser with ID: ${advertiserId.get()}")

        } else if (publisherId.isPresent) {

            val id:Int = Integer.parseInt(publisherId.get())
            eventService.getPublisherEvents(id)
            return ResponseEntity.ok("wait for income of advertiser with ID: ${publisherId.get()}")

        } else {

            return ResponseEntity.badRequest().body("required at least one of advertiser or publisher Id")

        }

    }
}