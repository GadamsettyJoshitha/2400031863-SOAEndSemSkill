# Tourist Records API — Spring Boot + MySQL

## Import into Spring Tool Suite (STS) / Eclipse / IntelliJ
1. Extract this ZIP.
2. In STS choose **File → Import → Maven → Existing Maven Projects**.
3. Select the extracted folder containing `pom.xml`, then Finish.
4. Use JDK 17+ and allow Maven to download dependencies.

## Database
Run `src/main/resources/schema.sql` in MySQL Workbench or:
`mysql -u root -p < src/main/resources/schema.sql`

The included sample rows are dummy demonstration data.

## Configure database and existing token(s)
Set environment variables before running. This project validates existing tokens and does not generate tokens.

Windows PowerShell:
```powershell
$env:DB_USERNAME="root"
$env:DB_PASSWORD="your_mysql_password"
$env:APP_SECURITY_TOKENS="your-existing-token-1,your-existing-token-2"
```
macOS/Linux:
```bash
export DB_USERNAME='root'
export DB_PASSWORD='your_mysql_password'
export APP_SECURITY_TOKENS='your-existing-token-1,your-existing-token-2'
```
Optional `DB_URL` defaults to `jdbc:mysql://localhost:3306/tourism_db?useSSL=false&serverTimezone=UTC`.
If `APP_SECURITY_TOKENS` is empty, requests to `/api/tourists` are rejected.

## Run
From the project directory: `mvn spring-boot:run`
Or run `TouristApiApplication.java` in the IDE.

Swagger UI: http://localhost:8080/swagger-ui.html
OpenAPI JSON: http://localhost:8080/v3/api-docs

## Test
Swagger → GET `/api/tourists` → Try it out → add `X-Auth-Token` header → Execute.
- Missing token: 401 Unauthorized
- Invalid token: 401 Unauthorized
- Valid token + working MySQL: 200 OK with JSON array

Command line:
`curl -H "X-Auth-Token: YOUR_EXISTING_TOKEN" http://localhost:8080/api/tourists`

Run unit tests: `mvn test`

## Security
The filter validates the custom header before the controller runs and uses constant-time token comparison. The response DTO intentionally excludes passwords, identity-document numbers and payment details. Use HTTPS and a secret manager in production. This is a read-only API; it does not delete or deactivate tourist records.
