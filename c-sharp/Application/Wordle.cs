


namespace Application;

public static class Wordle
{
    public static string WordOfTheDay = "mango";
    public static bool Validate(string guess)
    {
        if (guess.Length != 5)
        {
            return false;
        }
        if (!System.Text.RegularExpressions.Regex.IsMatch(guess, "^[a-zA-Z]+$"))
        {
            return false;
        }
        return true;
    }

    public static bool IsInList(string word)
    {
        List<string> listOfWords = new List<string>
        {
            "apple",
            "grape",
            "peach",
            "berry",
            "maple",
            "about",
            "mango"
        };

        return listOfWords.Contains(word.ToLower());
    }

    public static bool IsWordOfTheDay(string word) // 3min
    {
        var THING = String.Compare(word,WordOfTheDay, StringComparison.CurrentCultureIgnoreCase);
        if (word == WordOfTheDay) 
        {
            return true;
        }
        return false;
    }



    public static string CheckLetters(string word) // 4 min
    {
        var WordleCode = new System.Text.StringBuilder();
        foreach (char letter in word)
        {
            if (WordOfTheDay.Contains(letter) && WordOfTheDay.IndexOf(letter) == word.IndexOf(letter))
            {
                WordleCode.Append('2'); // Letter is in the correct position
            }
            else if (!WordOfTheDay.Contains(letter))
            {
                WordleCode.Append('0'); // Letter is not in the word
            }
            else
            {
                WordleCode.Append('1'); // Letter is in the word but in the wrong position
            }
        }
        return WordleCode.ToString();
    }
}