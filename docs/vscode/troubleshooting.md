# VS Code troubleshooting

The commands and settings below apply to the current Marketplace release.

## No diagnostics appear

- Confirm the workspace contains an OpenAPI 3.x document and supported Spring Boot
  Java/Kotlin or NestJS TypeScript controllers.
- Confirm `stackblender.openApiGuard.enabled` is `true`.
- Run **OpenAPI Guard: Select OpenAPI Specification** when discovery cannot choose the intended contract.
- Check `stackblender.openApiGuard.include` and `stackblender.openApiGuard.exclude` if controllers are outside conventional paths.
- Confirm the endpoint is intentionally drifted at the path or HTTP-method level. Matching endpoints should produce a clean result.
- Review the VS Code extension host logs for errors, but sanitize them before sharing.
- Restart the extension host after changing workspace structure.

## Navigation is unavailable

Navigation requires a related OpenAPI operation and implementation to be
identified. A missing operation or implementation may produce a diagnostic
without a valid destination.

## Report a reproducible problem

Use the [VS Code bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=vscode-bug.yml). Include versions, expected and actual behavior, minimal reproduction steps, and only sanitized samples and logs. Never post secrets, license keys, proprietary source, private API contracts, credentials, or personal/customer data.

Security concerns must not be filed publicly; see
[security reporting](../../SECURITY.md).
