# Spring Kotlin clean example

This fixture pairs `GET /pets/{petId}` in [`openapi.yaml`](src/main/resources/openapi.yaml) with the same route and HTTP method in [`PetController.kt`](src/main/kotlin/com/example/pets/PetController.kt).

Expected OpenAPI Guard result: **clean at the endpoint level**—no missing implementation, undocumented Spring endpoint, or HTTP method mismatch.

This is a minimal source fixture, not a standalone build. The controller expects Spring Web and Kotlin support on the classpath. Copy it into a compatible Spring Boot Kotlin project if execution is needed.

To test drift safely, change `@GetMapping` to `@PostMapping` in a temporary copy. OpenAPI Guard should then report an HTTP method mismatch. Do not commit the intentionally incorrect copy as the clean fixture.

This example is intentionally public and licensed under the repository's [MIT License](../../LICENSE).

