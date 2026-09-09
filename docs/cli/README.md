# OpenAPI Guard CLI

> **Status: pre-launch; bundled with the VS Code extension.**

The local `openapi-guard` CLI provides the same endpoint analysis outside the editor. It is bundled as `dist/cli.js` in the pre-launch VSIX, but installing the VSIX does not add a global shell command. A stable standalone installation method has not yet been announced.

Usage of the bundled executable is:

```text
openapi-guard [workspace] [options]

--spec <path>       Workspace-relative OpenAPI specification
--include <glob>    Source include glob; may be repeated
--exclude <glob>    Additional exclude glob; may be repeated
--format <format>   text (default) or json
-h, --help          Show help
```

Exit code `0` means clean, `1` means contract drift, and `2` means analysis or configuration failed. JSON output uses a versioned report with `clean`, `drift`, or `error` status. In JSON mode, standard output is reserved for the machine-readable report.

The interface above is verified but remains pre-release until the first public package is published. The CLI performs analysis locally; see the [privacy overview](../privacy.md). For reproducible pre-launch problems, use the [CLI/MCP bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=cli-mcp-bug.yml).
