package models;
public class Vendedor {
    
    private String nome, usuario, senha;
    private int cd_vendedor ;

    public int getCd_vendedor() {
        return cd_vendedor;
    }

    public void setCd_vendedor(int cd_vendedor) {
        this.cd_vendedor = cd_vendedor;
    }
    
    private static Vendedor instance;
    
    public static synchronized Vendedor getInstance(){
        if(instance == null){
            instance = new Vendedor();
        }
        return instance;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
