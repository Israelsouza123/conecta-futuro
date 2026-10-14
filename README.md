# FreelaDaQuebrada — Backend (Java + MySQL)

1. Instale Java 17+, Maven e MySQL.
2. No MySQL, rode `src/main/resources/banco.sql` (cria o banco, as tabelas e dados de exemplo).
3. Edite `src/main/resources/application.properties` com seu usuário e senha do MySQL.
4. Rode: `mvn spring-boot:run` — a API sobe em http://localhost:8080/api

CRUDs: `/api/prestadores`, `/api/servicos`, `/api/avaliacoes` (GET, POST, PUT /{id}, DELETE /{id}).

O frontend React procura a API em `http://localhost:8080/api` (ou na variável `VITE_API_URL`).
Rode o frontend em outra porta (ex.: `npm run dev -- --port 5173`).
