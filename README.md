# Auto Diagnostic

A command-line Java application for automated diagnostics.

## Usage

```
java AutoDiagnosticCli <healthIndex>
```

## Quick Start with Docker

You don't need to install Java or Gradle, just use Docker!

1. Build the image

```sh
docker build -t auto-diagnostic-cli .
```
2. Run the image!

```sh
docker run --rm auto-diagnostic-cli 15
```

Replace `15` with your health index.

## Development

### Prerequisites

- Java 24
- Gradle 8.14.3

### Running

```sh
./gradlew run --args 15
```

### Running tests

```sh
./gradlew test
```

### Generating Code Coverage

After running tests, a code coverage report is available at :

```
app/build/reports/jacoco/test/html/index.html
```

Open [this file](app/build/reports/jacoco/test/html/index.html) in your browser to view detailed coverage information.

#### Code Coverage Summary

| Element                               | Missed Instructions | Cov. | Missed Branches | Cov.  | Missed | Cxty | Missed | Lines | Missed | Methods | Missed | Classes |
|---------------------------------------|---------------------|------|-----------------|-------|--------|------|--------|-------|--------|---------|--------|---------|
| com.softway.autodiagnostic.services   | 3 of 31             | 90%  | 0 of 6          | 100%  | 1      | 5    | 1      | 9     | 1      | 2       | 0      | 1       |
| com.softway.autodiagnostic.cli        | 3 of 28             | 89%  | 0 of 2          | 100%  | 1      | 3    | 1      | 11    | 1      | 2       | 0      | 1       |
| **Total**                             | **6 of 59**         | 89%  | **0 of 8**      | 100%  | 2      | 8    | 2      | 20    | 2      | 4       | 0      | 2       |

### Going further...

- [Development Containers](https://containers.dev/) could help development and reproduction and avoid issues by having the same environment.
- CI and CD with GitHub Actions (or something else!)

## License

[MIT](LICENSE)