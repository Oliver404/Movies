package com.oliverbotello.movies.data

import com.oliverbotello.movies.models.Movie
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object MoviesData {
    fun getPopularMovies(): List<Movie> {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd");
        return listOf(
            Movie(
                1,
                "Mortal Kombat",
                dateFormat.parse("2021-04-07"),
                7.5f,
                "mortalcombatposter.jpg",
                "mortalback.jpg",
                "Un boxeador fracasado descubre un secreto familiar que lo lleva a un " +
                        "torneo místico llamado Mortal Kombat donde se encuentra con un grupo de " +
                        "guerreros que luchan hasta la muerte para salvar los reinos del malvado " +
                        "hechicero Shang Tsung."
            ),
            Movie(
                2,
                "Estados Unidos: La Película",
                dateFormat.parse("2021-06-30"),
                5.6f,
                "usaposter.jpg",
                "usaback.jpg",
                "George Washington debe reunir a un grupo de luchadores revolucionarios " +
                        "para combatir al tiránico Rey James."
            ),
            Movie(
                3,
                "Godzilla vs. Kong",
                dateFormat.parse("2021-03-24"),
                8f,
                "gvkposter.jpg",
                "gvkback.jpg",
                "Godzilla y Kong, dos de las fuerzas más poderosas de un planeta " +
                        "habitado por todo tipo de aterradoras criaturas, se enfrentan en un " +
                        "espectacular combate que sacude los cimientos de la humanidad. Monarch " +
                        "(Kyle Chandler) se embarca en una misión de alto riesgo y pone rumbo " +
                        "hacia territorios inexplorados para descubrir los orígenes de estos " +
                        "dos titanes, en un último esfuerzo por tratar de salvar a dos bestias " +
                        "que parecen tener las horas contadas sobre la faz de la Tierra."
            ),
            Movie(
                4,
                "Spirit - Indomable",
                dateFormat.parse("2021-05-20"),
                7.7f,
                "spiritposter.jpg",
                "spirtiback.jpg",
                "La vida de Lucky Prescott cambia para siempre cuando se muda de su " +
                        "casa en la gran ciudad a un pequeño pueblo fronterizo en el que entabla" +
                        " amistad con un caballo salvaje llamado Spirit."
            ),
            Movie(
                5,
                "Space Jam",
                dateFormat.parse("1996-11-15"),
                6.8f,
                "spacejamposter.jpg",
                "spaceback.jpg",
                "Bugs Bunny y su equipo desafían a los Nerdlucks (un grupo de pequeños " +
                        "extraterrestres) a un partido de baloncesto para decidir si los Looney " +
                        "Tunes permanecen en la Tierra o se trasladan a una lejana galaxia para " +
                        "trabajar en un parque de atracciones de Montaña Tontolandia. Los " +
                        "Nerdlucks cuentan con una poderosa arma secreta que los hace superiores: " +
                        "se han apoderado de las mejores cualidades de las estrellas de la NBA " +
                        "(Charles Barkley y Patrick Ewing). Pero también los Looney poseen un " +
                        "arma secreta: ¡Michael Jordan!"
            ),
        )
    }
}