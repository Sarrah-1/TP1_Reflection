package dao;

public class DaoImpl implements IDao {

    @Override
    public double getValue() {
        System.out.println("[DAO] Recuperation de la valeur");
        return 100.0;
    }
}