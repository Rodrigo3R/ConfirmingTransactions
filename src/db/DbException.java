package db;

// classe que faz a excecao caso der algum problema no banco
public class DbException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DbException(String msg) {
		super(msg);
	}

}
