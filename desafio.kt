enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(var nome: String, var idade: Int, var sexo: String)

data class ConteudoEducacional(val disciplina: String, var duracao: Int, var nivel: Nivel)

data class Formacao(val curso: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuarios: Usuario) {
        for (usuario in usuarios){
            inscritos.add(usuario)
        }
    }
}

fun main() {
    var maria = Usuario("Maria", 28, "F")
    var antonia = Usuario("Antonia", 23, "F")
    var jose = Usuario("Jose", 33, "M")
    var raimundo = Usuario("Raimundo", 40, "M")
    
    var matematica = ConteudoEducacional("Matematica", 300, Nivel.AVANCADO)
    var portugues = ConteudoEducacional("Portugues", 230, Nivel.INTERMEDIARIO)
    var ingles = ConteudoEducacional("Ingles", 100, Nivel.BASICO)
    var fisica = ConteudoEducacional("Fisica", 150, Nivel.INTERMEDIARIO)
    var quimica = ConteudoEducacional("Quimica", 350, Nivel.AVANCADO)
    
    val conteudoBasico = mutableListOf<ConteudoEducacional>(ingles)
    val conteudoIntermediario = mutableListOf<ConteudoEducacional>(portugues, fisica)
    val conteudoAvancado = mutableListOf<ConteudoEducacional>(matematica, quimica)
    
    var formacaoBasica = Formacao("Curso Basico", conteudoBasico)
    var formacaoIntermediaria = Formacao("Curso Intermediario", conteudoIntermediario)
    var formacaoAvancada = Formacao("Curso Avancado", conteudoAvancado)
    
    formacaoBasica.matricular(maria, raimundo)
    formacaoIntermediaria.matricular(jose)
    formacaoAvancada.matricular(antonia, raimundo, jose)
    
    println(formacaoBasica.inscritos)
    println(formacaoIntermediaria.inscritos)
    println(formacaoAvancada.inscritos)
}