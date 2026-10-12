package metier;

import dao.IDao;

public class MetierImpl implements IMetier {

    private IDao dao;

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        if (dao == null) {
            throw new IllegalStateException(
                    "Le DAO n'a pas ete injecte."
            );
        }

        double valeur = dao.getValue();
        double resultat = valeur * 2;

        System.out.println(
                "[METIER] Resultat : " + resultat
        );

        return resultat;
    }
}