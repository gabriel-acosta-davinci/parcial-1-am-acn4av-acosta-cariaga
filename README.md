# MedicalShift

MedicalShift es una aplicación mobile desarrollada en Android Studio que permite visualizar trámites médicos recientes y acceder a la cartilla de profesionales de salud. Este proyecto fue realizado como parte de una entrega académica, cumpliendo con requisitos técnicos específicos y buenas prácticas de diseño.

---

## Objetivo

Diseñar e implementar una pantalla funcional y visualmente coherente que represente el inicio de una app médica, integrando componentes reales, navegación fluida y estética profesional.

---

## Pantalla seleccionada


Se desarrolló la **pantalla de inicio**, que incluye:

- Logo y nombre de la app
- Saludo personalizado
- Credencial digital con datos hardcodeados
- Sección de últimos trámites
- Sección de cartilla médica con búsqueda
- Barra de navegación inferior

---

## Herramientas y tecnologías

- **Android Studio**
- **Java**
- **ViewPager2** para navegación entre fragments
- **ConstraintLayout** y **LinearLayout**
- **RecyclerView** con adaptadores personalizados
- **BottomNavigationView**
- **XML** para layouts
- **GitHub** para control de versiones

---

## Componentes implementados

| Componente         | Uso en el proyecto                            |
|--------------------|-----------------------------------------------|
| `ConstraintLayout` | Ítems de RecyclerView (`item_tramite.xml`, `item_profesional.xml`) |
| `LinearLayout`     | Estructura vertical y horizontal en `fragment_inicio.xml` |
| `TextView`         | Títulos, saludos, datos del usuario, trámites |
| `Button`           | Botones “Ver todos” y “Ver cartilla” con eventos |
| `EditText`         | Búsqueda en cartilla médica                   |
| `RecyclerView`     | Listado de trámites y profesionales           |
| `ImageView`        | Logo de la app y flechas decorativas          |

---

## Funcionalidades

- **Navegación por ViewPager2** entre Inicio, Trámites, Cartilla y Perfil
- **Filtro dinámico** en cartilla médica por nombre, especialidad o localidad
- **Botones con eventos** que redirigen a otros fragments
- **Elemento dinámico agregado desde Java**: saludo según la hora del día
- **Diseño responsive** con fondo en gradiente y tipografía personalizada

---

## ¿Cómo ejecutar?

1. Clonar el repositorio
2. Abrir en Android Studio
3. Ejecutar en emulador o dispositivo físico

---

## Autores

### **Gabriel Hernán Acosta**

### **María del Rosario Cariaga**


---

## Licencia

Este proyecto fue desarrollado con fines académicos. Su uso está permitido para revisión, aprendizaje y mejora personal.
