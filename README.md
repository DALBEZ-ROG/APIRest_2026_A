# APIRest 2026-A

Aplicación Android de demostración para consumo de APIs REST, desarrollada en Java para la asignatura de programación móvil — UTEQ 2026.

## Descripción

La app cuenta con dos pantallas independientes que consultan fuentes de datos distintas y muestran los resultados en tiempo real:

| Pantalla | Fuente | Datos mostrados |
|---|---|---|
| **Supabase** (pantalla principal) | Supabase REST API | Apellidos/Nombres, Cédula, Correo institucional |
| **MainActivity** | reqres.in (mock API) | Nombres, Correo, Paralelo, Período académico |

## Tecnologías

- **Lenguaje:** Java
- **SDK mínimo:** API 24 (Android 7.0)
- **Target SDK:** API 36
- **HTTP:** [Volley 1.2.1](https://google.github.io/volley/)
- **Base de datos remota:** [Supabase](https://supabase.com/)
- **UI:** ConstraintLayout + Material Design 3

## Estructura del proyecto

```
app/src/main/
├── java/com/uteq/apirest_2026_a/
│   ├── Supabase.java       # Pantalla principal — consume Supabase REST API
│   └── MainActivity.java   # Pantalla secundaria — consume API mock (reqres.in)
└── res/layout/
    ├── activity_supabase.xml
    └── activity_main.xml
```

## Configuración

### Supabase

La actividad `Supabase.java` se conecta a un proyecto Supabase usando la REST API. Los headers requeridos son:

```java
headers.put("apikey", "<TU_SUPABASE_KEY>");
headers.put("Authorization", "Bearer <TU_SUPABASE_KEY>");
```

Reemplaza la URL del endpoint y las claves en `Supabase.java` con las de tu propio proyecto Supabase.

## Cómo ejecutar

1. Clona el repositorio
2. Abre el proyecto en **Android Studio**
3. Espera que Gradle sincronice las dependencias
4. Conecta un dispositivo o inicia un emulador (API 24+)
5. Presiona **Run**

La pantalla de inicio es la actividad `Supabase`, que realiza la petición automáticamente al iniciar.

## Permisos

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## Universidad

**Universidad Técnica Estatal de Quevedo (UTEQ)**  
Ingeniería en Sistemas / Desarrollo de Aplicaciones Móviles — 2026
