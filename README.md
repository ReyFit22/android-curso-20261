1. app/src/main/AndroidManifest.xml
¿Qué función cumple / Qué contiene?
Es el archivo de configuración global y esencial de la aplicación. Contiene los metadatos que el sistema operativo Android necesita saber antes de ejecutar cualquier línea de código. Define componentes clave como el nombre de la app, su ícono, las pantallas (activities) que tiene, y los permisos que requiere (como acceso a internet o cámara).

¿Qué es el atributo android:name en <activity>?
Especifica el nombre de la clase de Java o Kotlin que controla esa pantalla (por ejemplo, .MainActivity). Le dice al sistema operativo exactamente qué archivo de código debe buscar y cargar cuando se quiere abrir esa ventana.

2. app/build.gradle.kts
 compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
        minSdk = 24
        targetSdk = 36

¿Qué función cumple?
Es el script de configuración de Gradle para el módulo de tu aplicación. Sirve para definir cómo se compila la app, qué versiones del SDK de Android se van a usar y qué librerías externas o dependencias necesita tu código para funcionar.

¿Cuál es el valor de minSdk?
Determina la versión mínima de Android que debe tener un celular para poder instalar tu aplicación. (Suele ser un número como 24 o 26). Cualquier teléfono con una versión inferior no podrá instalarla.

¿Y de compileSdk?
Es la versión del SDK de Android con la que se compila la aplicación. Le dice a Android Studio qué herramientas y APIs modernas tienes disponibles para escribir tu código al momento de compilar. (Actualmente suele ser 34 o 35).

3. libs.versions.toml
¿Qué función cumple?
Es el archivo de "Catálogo de Versiones" (Version Catalog). Su objetivo es centralizar en un solo lugar todos los números de versión de las librerías y plugins que usa el proyecto para que no estén regados por todo el código, facilitando su actualización.

¿Qué versión de Kotlin está configurada?
kotlin = "2.2.10"


4. app/src/main/java/.../MainActivity.kt
¿Qué función cumple?
Es el archivo de código fuente principal. Es el punto de entrada de la aplicación (la primera pantalla que ve el usuario al abrir la app).
