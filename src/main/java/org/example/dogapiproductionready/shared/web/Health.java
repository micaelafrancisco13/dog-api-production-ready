package org.example.dogapiproductionready.shared.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class Health {
//  Concept: /healthz vs. Actuator readiness
//      healthz: your simple “is the app process responding?” endpoint. Great for quick sanity checks.
//      Actuator health endpoints: “is the app ready to receive traffic?” and “should the platform restart it?”
//      This is what Kubernetes / load balancers typically use:
//          liveness: app is alive (if down → restart)
//          readiness: app is ready (if not ready → remove from traffic, don’t necessarily restart)
// Spring Boot supports these via Actuator when enabled.
    @GetMapping("/healthz")
    String health() {
        return "UP";
    }
}
