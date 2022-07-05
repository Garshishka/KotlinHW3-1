fun main() {
    val secondsAgo =23*60*60 +1

    println("был(а) "+agoToText(secondsAgo))
}

fun agoToText(secondsAgo:Int): String{
    val firstText = when (secondsAgo){
        in 0..60 -> "только что"
        in 61..60*60 -> "${secondsAgo/60} минут назад"
        in (60*60+1)..24*60*60 -> "в сети ${secondsAgo/(60*60)} часов назад"
        in (24*60*60+1)..2*24*60*60 -> "сегодня"
        in (2*24*60*60+1)..3*24*60*60 -> "вчера"
        else -> "давно"
    }

    return when (secondsAgo){
        in 61..5*60 -> changeWordEndingForMinutes(firstText)
        in 20*60+1..60*60 -> changeWordEndingForMinutes(firstText)
        in 60*60+1..5*60*60 -> changeWordEndingForHours(firstText)
        in 20*60*60+1..24*60*60 -> changeWordEndingForHours(firstText)
        else -> firstText
    }
}

fun changeWordEndingForMinutes (inputText: String):String{
    return when{
        inputText[inputText.length-13] =='1' -> inputText.replace("минут","минуту")
        inputText[inputText.length-13].digitToInt() <5 -> inputText.replace("минут","минуты")
        else ->inputText
    }
}

fun changeWordEndingForHours (inputText: String):String{
    return when{
        inputText[inputText.length-13] =='1' -> inputText.replace("часов","час")
        inputText[inputText.length-13].digitToInt() <5 -> inputText.replace("часов","часа")
        else ->inputText
    }
}