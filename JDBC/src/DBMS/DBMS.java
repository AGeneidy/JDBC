package DBMS;

public interface DBMS {

	public void createDB(String DBName) throws Exception;

	public void removeDB(String DBName);

	public Database getUsedDB();

	public void setUsedDB(String dbName) throws Exception;
}