package heros.dto.response;

public class AuthResponse {
    private String token;
    private Integer id;

    public AuthResponse(String token, Integer id) {
        this.token = token;
        this.id=id;
    }

    public String getToken() {
        return token;
    }

    public Integer getId() {
        return id;
    }
    
}
