# SQL Injection Example

Una aplicación de demostración de Spring Boot que ilustra vulnerabilidades de SQL Injection y cómo prevenirlas.

## 📋 Descripción

Este proyecto es una aplicación educativa que demuestra cómo funcionan los ataques de SQL Injection y la importancia de utilizar consultas paramétrizadas y otras medidas de seguridad para proteger bases de datos.

## 📦 Requisitos Previos

- **Java 21** o superior
- **MySQL 8.3** o superior
- **Maven 3.6+**
- **Spring Boot 3.5.7**

## 🗄️ Configuración de la Base de Datos

### Opción 1: Importar la Base de Datos Existente

Si ya tienes el archivo SQL en el directorio `DB/sql_injection_demo.sql`, sigue estos pasos:

#### Pasos:

1. **Abre MySQL Workbench o el cliente de MySQL de tu preferencia**

2. **Crea la conexión a tu servidor MySQL** (por defecto en `localhost:3306`)

3. **Ejecuta el script SQL:**
   ```bash
   mysql -h 127.0.0.1 -u root -p < DB/sql_injection_demo.sql
   ```
   O en MySQL Workbench:
   - Abre el archivo `DB/sql_injection_demo.sql`
   - Ejecuta el script (Ctrl + Shift + Enter)

4. **Verifica que la base de datos se haya creado:**
   ```sql
   SHOW DATABASES;
   ```

### Opción 2: Crear la Base de Datos Manualmente

Si prefieres crear la base de datos desde cero:

```sql
-- Crear la base de datos
CREATE DATABASE sql_injection_demo;

-- Usar la base de datos
USE sql_injection_demo;

-- Crear la tabla de usuarios
CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(50) DEFAULT NULL,
  PASSWORD VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insertar datos de prueba
INSERT INTO users (id, username, PASSWORD) VALUES
(1, 'admin', 'admin123'),
(2, 'jose', '1234');
```

## ⚙️ Configuración de la Aplicación

### Paso 1: Configura la Conexión a MySQL

Edita el archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sql_injection_demo
spring.datasource.username=root
spring.datasource.password=tu_contraseña_mysql
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración adicional (opcional)
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

**Reemplaza:**
- `tu_contraseña_mysql` con tu contraseña de MySQL

### Paso 2: Compila la Aplicación

```bash
cd sql_injection_demo
mvn clean install
```

### Paso 3: Ejecuta la Aplicación

```bash
mvn spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

## 🔐 Usuarios de Prueba

Después de importar la base de datos, puedes usar estos usuarios para probar:

| Usuario | Contraseña |
|---------|-----------|
| admin   | admin123  |
| jose    | 1234      |

## 📁 Estructura del Proyecto

```
sql_injection_demo/
├── DB/
│   └── sql_injection_demo.sql          # Script de la base de datos
├── src/
│   ├── main/
│   │   ├── java/com/sv/edu/udb/dss/sql_injection_demo/
│   │   │   ├── loginController.java    # Controlador vulnerable (demo)
│   │   │   ├── loginPageController.java # Controlador seguro
│   │   │   ├── SqlInjectionDemoApplication.java
│   │   │   └── config/
│   │   │       └── SecurityConfig.java # Configuración de seguridad
│   │   └── resources/
│   │       ├── application.properties  # Configuración de la app
│   │       └── templates/
│   │           └── login.html          # Página de login
│   └── test/
│       └── java/...                    # Pruebas unitarias
├── pom.xml                              # Dependencias de Maven
└── README.md                            # Este archivo
```

## 🚀 Endpoints Disponibles

- `GET /` - Página de inicio
- `GET /login` - Página de login
- `POST /login` - Procesar login (formulario)

## ⚠️ Advertencia de Seguridad

**Este proyecto es solo con fines educativos.** Las vulnerabilidades demostrativas no deben ser usadas en aplicaciones de producción.

### Buenas Prácticas Implementadas:

- ✅ Uso de consultas paramétrizadas
- ✅ Hash de contraseñas
- ✅ Validación de entrada
- ✅ Protección CSRF
- ✅ Configuración de seguridad Spring

## 🛠️ Tecnologías Utilizadas

- **Spring Boot 3.5.7**
- **Spring Security**
- **Spring Data JDBC**
- **MySQL 8.3**
- **Java 21**
- **Maven 3.6+**
- **Thymeleaf** (Template Engine)

## 📝 Licencia

Este proyecto es de código abierto y está disponible bajo licencia MIT.

## 👨‍💻 Autor

Proyecto educativo para demostración de seguridad en bases de datos.

---

**Última actualización:** Noviembre 17, 2025