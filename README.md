# QA Automation Sample (TestNG + Selenium + RestAssured)

Minimal demo framework showing API, UI and sample tests with a CI pipeline.

## Tech
- **TestNG** for test runner
- **Selenium** (headless Chrome) for UI tests
- **RestAssured** for API tests
- **GitHub Actions** for CI

## Structure
- `pom.xml` – Maven dependencies  
- `.github/workflows/ci.yml` – CI pipeline  
- `src/test/java/tests/` – Test classes (ApiTest, UiTest, SampleTest)  
- `src/test/resources/testng.xml` – TestNG suite  

## How to Run
```bash
mvn test
