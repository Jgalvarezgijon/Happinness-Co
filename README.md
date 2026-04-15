# HappinessCo

Proyecto de primer curso del ciclo de **Desarrollo de Aplicaciones Multiplataforma (DAM)**, compuesto por dos módulos principales: una aplicación de consola en Java y un sitio web estático en HTML/CSS.

---

## 📁 Estructura del proyecto

```
HappinnessCo/
├── PROG/        → Aplicación Java (módulo de Programación)
├── LMSGI/       → Sitio web estático (módulo de LMSGI)
├── BADAT/       → Base de datos (módulo de Bases de Datos)
└── RSS/         → Feed RSS
```

---

## ☕ PROG — Aplicación Java

Aplicación de gestión por consola para la organización **HappinessCo**. Permite administrar usuarios, eventos, galerías y favoritos mediante un menú interactivo.

### Funcionalidades

- ✅ Añadir y eliminar **usuarios**
- ✅ Añadir y eliminar **eventos**
- ✅ Añadir y eliminar **galerías** asociadas a eventos
- ✅ Añadir y eliminar **favoritos** (relación usuario–evento)
- ✅ Mostrar información de usuarios, eventos y favoritos
- ✅ Generación de **elementos de prueba** automáticos

### Estructura de paquetes

```
com.happinesssco/
├── modelo/      → Clases de entidad (Usuario, Evento, Galeria, Favorito)
├── servicio/    → Lógica de negocio por entidad
├── utilidad/    → Validador y constantes de mensajes
└── principal/   → Clase Main (punto de entrada)
```

### Cómo ejecutar

1. Abre el proyecto en tu IDE favorito (Eclipse, IntelliJ, VS Code…).
2. Compila el proyecto.
3. Ejecuta la clase `Main` dentro del paquete `com.happinesssco.principal`.

---

## 🌐 LMSGI — Sitio web estático

Sitio web de la organización **HappinessCo** desarrollado con HTML y CSS estándar.

### Páginas principales

- `index.html` — Página de inicio
- `pages/SobreNosotros.html` — Información sobre la organización
- `pages/ProximosEventos.html` — Eventos próximos
- `pages/HistorialDeEventos.html` — Historial de eventos pasados
- `pages/Contacto.html` — Formulario y datos de contacto
- `pages/Fuentes.html` — Fuentes y referencias

---

## 🛠️ Tecnologías utilizadas

| Módulo | Tecnología |
|--------|-----------|
| PROG   | Java       |
| LMSGI  | HTML5, CSS3 |
| BADAT  | SQL        |

---

## 👤 Autor

**Juan García Álvarez**  
1º DAM — Curso 2025/2026
