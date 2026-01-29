public class ReturnObject
{
    public bool Success { get; set; }
    public string Message { get; set; }

    public ReturnObject(bool success, string message)
    {
        Success = success;
        Message = message;
    }
}