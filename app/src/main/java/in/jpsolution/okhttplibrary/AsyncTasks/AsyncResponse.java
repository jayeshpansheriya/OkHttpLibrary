package in.jpsolution.okhttplibrary.AsyncTasks;


public interface AsyncResponse {
    void onCallback(String response);
    void onFailure(String message);
}
