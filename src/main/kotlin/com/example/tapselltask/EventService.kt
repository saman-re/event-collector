package com.example.tapselltask

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class EventService(
    @Autowired
    val eventRepository: EventRepository
) {

    val builder = WebClient.builder().codecs { codecs -> codecs.defaultCodecs().maxInMemorySize(1000 * 1024) }
    val startTime:Long = 1

    @Scheduled(fixedRate = 60000)
    fun eventFetch() {
        val timeMillis = System.currentTimeMillis()
        val since: Long = timeMillis - startTime * 60000
        val url = "http://192.168.1.57:8071/api/events?since=$since"
        val response:EventResponse? = builder.build().get().uri(url).retrieve().bodyToMono(EventResponse::class.java).block()
        println(response!!.events[0].toString())
    }

    fun getAdvertiserEvents(id: Int){

        //TODO this method must find the event base on advertiser ID

    }

    fun getPublisherEvents(id:Int){

        //TODO this method must find the event base on publisher ID

    }
}