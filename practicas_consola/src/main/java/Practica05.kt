// 1. INTERFACES Y CLASES BASE
interface Evaluable {
    val notaMinima: Int
        get() = 70

    fun estaAprobado(nota: Int): Boolean {
        return nota >= notaMinima
    }

    fun descripcion(): String
}

open class Persona(
    val nombre: String,
    val apellido: String,
    val cedula: String
) {
    val nombreCompleto: String
        get() = "$nombre $apellido"

    init {
        require(cedula.length == 11) {
            "La cédula debe tener 11 dígitos"
        }
    }

    open fun presentarse(): String {
        return "Soy $nombreCompleto, cédula $cedula"
    }

    override fun toString(): String {
        return nombreCompleto
    }
}

// 2. CLASES DERIVADAS
class Estudiante(
    nombre: String,
    apellido: String,
    cedula: String,
    val matricula: String,
    val carrera: String
) : Persona(nombre, apellido, cedula), Evaluable {

    private val notasInternas = mutableListOf<Int>()

    val notas: List<Int>
        get() = notasInternas

    fun agregarNota(nota: Int) {
        require(nota in 0..100) {
            "La nota debe estar entre 0 y 100"
        }
        notasInternas.add(nota)
    }

    val promedio: Double
        get() = if (notasInternas.isEmpty()) 0.0 else notasInternas.average()

    override fun descripcion(): String {
        return "Estudiante: $nombreCompleto | Promedio: %.1f".format(promedio)
    }

    override fun presentarse(): String {
        return super.presentarse() +
                " | Matrícula: $matricula | Carrera: $carrera"
    }
}

class Docente(
    nombre: String,
    apellido: String,
    cedula: String,
    val departamento: String,
    val aniosExperiencia: Int
) : Persona(nombre, apellido, cedula), Evaluable {

    override fun presentarse(): String {
        return super.presentarse() +
                " | Departamento: $departamento" +
                " | Experiencia: $aniosExperiencia años"
    }

    override fun descripcion(): String {
        return "Docente: $nombreCompleto | Departamento: $departamento"
    }
}

// 3. FUNCIONES AUXILIARES
fun imprimirReporte(personas: List<Persona>) {
    println("\n===== REPORTE DEL SISTEMA =====")
    for (persona in personas) {
        println(persona.presentarse())
        if (persona is Evaluable) {
            println("  → ${persona.descripcion()}")
        }
        println("----------------------------------------")
    }
}

// 4. PUNTO DE ENTRADA ÚNICO
fun main() {
    // Inicialización de Estudiantes
    val est1 = Estudiante(
        "Ana",
        "Lopez",
        "00112345678",
        "2024-001",
        "Ing. Software"
    )
    est1.agregarNota(85)
    est1.agregarNota(92)
    est1.agregarNota(78)

    val est2 = Estudiante(
        "Carlos",
        "Ruiz",
        "00198765432",
        "2024-002",
        "Ing. Software"
    )
    est2.agregarNota(55)
    est2.agregarNota(68)

    // Inicialización de Docentes
    val docente1 = Docente(
        "Maria",
        "Gomez",
        "00111222333",
        "Tecnologia",
        12
    )

    val docente2 = Docente(
        "Jose",
        "Martinez",
        "00144556677",
        "Matematicas",
        8
    )

    // Lista general del reporte
    val personas: List<Persona> = listOf(
        est1,
        est2,
        docente1,
        docente2
    )

    // Ejecución de reportes y lógica de negocio
    imprimirReporte(personas)

    val estudiantesAprobados = personas
        .filterIsInstance<Estudiante>()
        .filter { estudiante ->
            estudiante.estaAprobado(estudiante.promedio.toInt())
        }

    println()
    println("Estudiantes aprobados:")
    for (estudiante in estudiantesAprobados) {
        println("- ${estudiante.nombreCompleto}")
    }
}