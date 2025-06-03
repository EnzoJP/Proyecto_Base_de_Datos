package ar.edu.uncuyo.user;

//esta clase se usa agregar usuarios con la contraseña encriptada

//this is just a simple user management it's not the best solution 
//but it works for the purpose of this project basically compares the hashed password
//with the one entered by the user in the login panel :)
// no se porque cambie a ingles ajajaja

public class user_management {
    private String username;
    private String password;

    public user_management(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public String getUsername() {
        return username;
    }

}
