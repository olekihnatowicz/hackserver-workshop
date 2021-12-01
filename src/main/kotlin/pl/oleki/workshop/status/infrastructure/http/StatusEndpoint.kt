package pl.oleki.workshop.status.infrastructure.http

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StatusEndpoint {
    @GetMapping("/status/health")
    fun status(): ResponseEntity<Unit> {
        return ok(Unit)
    }
}
