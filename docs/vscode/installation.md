# VS Code installation

OpenAPI Guard requires desktop VS Code 1.96.0 or later. Its extension identifier is `StackBlender.openapi-guard`.

Install [OpenAPI Guard](https://marketplace.visualstudio.com/items?itemName=StackBlender.openapi-guard) from the Extensions view, or run:

```sh
code --install-extension StackBlender.openapi-guard
```

After installation:

1. Open a Spring Boot Java/Kotlin or NestJS TypeScript workspace containing an
   OpenAPI 3.x document.
2. Allow automatic analysis to run, or invoke **OpenAPI Guard: Analyze Current File**.
3. Open the Problems panel to review endpoint drift.
4. Use Go to Definition or the OpenAPI Guard navigation commands to move between the contract and implementation.

Continue with [configuration](configuration.md), or consult [troubleshooting](troubleshooting.md).
