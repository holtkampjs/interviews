namespace UnitTests;

using Application;

public class WordleTests
{
    [Theory]
    [InlineData("12345",false)]
    [InlineData("CATS",false)]
    [InlineData("",false)]
    public void WordIsValid(string word, bool expected)
    {
        Assert.Equal(expected, Wordle.Validate(word));
    }
    [Theory]
    [InlineData("apple",true)]
    [InlineData("melon",false)]
    public void IsInList(string word, bool expected)
    {
        Assert.Equal(expected, Wordle.IsInList(word));
    }

    [Theory]
    [InlineData("mango", true)]
    [InlineData("apple", false)]
    [InlineData("MANGO", true)]
    public void IsWordOfTheDay(string word, bool expected)
    {
        Assert.Equal(expected, Wordle.IsWordOfTheDay(word));
    }

    [Theory]
    [InlineData("about", "10100")]
    [InlineData("maple", "22000")]
    
    public void WrongLetter(string word, string expected)
    {
        Assert.Equal(expected, Wordle.CheckLetters(word));
    }

    //0 means no match, 1 means wrong position, 2 means correct position
}