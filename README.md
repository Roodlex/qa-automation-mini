
# QA Automation Sample (TestNG + Selenium + RestAssured)

[![CI](https://img.shields.io/github/actions/workflow/status/Roodlex/qa-automation-mini/ci.yml?branch=main)](https://github.com/Roodlex/qa-automation-mini/actions/workflows/ci.yml)




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
```


## Mini Projects
- `ReqRes Users API:` GET+schema, POST create → validates status, payload, schema.
- `CoinDesk BTC Price:` Price feed sanity (non-zero rate, ISO timestamp).
- `Sauce Demo UI:` Negative login, happy path login, add-to-cart (Page Objects).
