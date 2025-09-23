# DOSW_TALLER-2
### Taller 2 - DOSW
#### Integrantes:
- Ana Gabriela Fiquitiva Poveda
---
### Enunciado:
Caso de estudio: GESTOR DE TAREAS COLABORATIVO
Una empresa fintech quiere desarrollar un Sistema de Reportes Financieros que permita generar informes dinámicos y personalizables para sus clientes.
El sistema debe permitir a los usuarios:
1.	Crear reportes con información básica: título, fecha de generación, autor, lista de transacciones y contenido.
2.	Extender dinámicamente los reportes con decoradores:
      - Reporte con gráficas.
      - Reporte con marcas de agua de seguridad.
      - Reporte con resumen estadístico.
      - Reporte con exportación a PDF/Excel.
3.	Usar el patrón Builder para construir los objetos Reporte paso a paso, asegurando flexibilidad en su creación.
4.	Listar todos los reportes generados y filtrar por fecha usando Streams.
5.	Persistir los reportes en MongoDB.
---
#### Desarrollo:
## 1. Desarrollo de Ramas:
- Se creó la rama `main` para el código base.
- Se creo la rama develop para el desarrollo del ejercicio.
- Se crearon ramas feature/ParteInicial para la implementación inicial del taller.
## 2. Implementación de Diagrama de Componentes Específico:
Explicación del Diagrama de Componentes:
##  3. Diagrama de Clases:
Explicación del Diagrama de Clases:
## 4. Implementación de los principios SOLID:
- **S**ingle Responsibility Principle (SRP): Cada clase tiene una única responsabilidad. 
- **O**pen/Closed Principle (OCP): Las clases están abiertas para extensión pero cerradas para modificación. Se pueden agregar nuevas funcionalidades mediante la creación de nuevas clases que extienden las existentes.
- **L**iskov Substitution Principle (LSP): Las clases derivadas pueden sustituir a sus clases base sin alterar el comportamiento del programa.
- **I**nterface Segregation Principle (ISP): Las interfaces son específicas y no obligan a las clases a implementar métodos que no utilizan.
- **D**ependency Inversion Principle (DIP): Las clases dependen de abstracciones y no de implementaciones concretas.
## 5. Implementación de Patrones de Diseño:
- 
### Patrón Decorator:
El patrón Decorator se utiliza para añadir funcionalidades adicionales a los reportes sin modificar su estructura original
### Patrón Builder:
El patrón Builder se utiliza para construir objetos Reporte de manera flexible y paso a paso, permitiendo la creación de reportes con diferentes configuraciones.
## MONGODB:
